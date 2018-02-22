package com.fg.thread;
/**
 * 设置守护线程测试
 */
public class DaemonDemo {
	public static class DaemonT extends Thread{
		@Override 
		public void run(){
			while(true){
				System.out.println("i am alive");
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){}
			}
		}
	}
	public static void test() {
		Thread t=new DaemonT();
		//设置线程守护线程
		t.setDaemon(true);
		t.start();
		try{
			Thread.sleep(2000);	
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

