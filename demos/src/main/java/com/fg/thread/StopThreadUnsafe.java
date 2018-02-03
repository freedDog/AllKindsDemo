package com.fg.thread;


/**
 * 测试线程的stop()方法
 */
public class StopThreadUnsafe {
	public static User u=new User();
	public static class User{
		private int id;
		private String name;

		public void setId(int id) {
				this.id = id;
		}

		public int getId() {
				return id;
		}

		public void setName(String name) {
				this.name = name;
		}

		public String getName() {
				return name;
		}

		public User() {
			this.id=0;
			this.name="0";
		}
		@Override
		public String toString() {
			return "User [id="+this.id+", name="+this.name+"]";
		}
	}
	public static class ChangeObjectThread extends Thread{
		@Override 
		public void run() { 
			while(true){
				synchronized(u){
					int v=(int)(System.currentTimeMillis()/1000);
					u.setId(v);
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
					u.setName(String.valueOf(v));
				}	
				Thread.yield();
			}
		}
	}
	public static class ReadObjectThread extends Thread{
		@Override
		public void run(){
			while(true){
				synchronized(u){
					if(u.getId()!=Integer.parseInt(u.getName())){
						System.out.println(u.toString());
					}
				}
				Thread.yield();
			}
		}	
	}
	public static void test(){
		try{
		new ReadObjectThread().start();
		while(true){
			Thread t= new ChangeObjectThread();
			t.start();
			Thread.sleep(150);
			t.stop();
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

