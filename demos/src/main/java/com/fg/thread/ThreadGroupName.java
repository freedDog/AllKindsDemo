package com.fg.thread;
/**
 * 线程组
 */
public class ThreadGroupName {
	public static void test(){
		ThreadGroup tg=new ThreadGroup("PrintGroup");
		Thread t1=new Thread(tg,new ThreadName(),"T1");
		Thread t2=new Thread(tg,new ThreadName(),"T2");

		t1.start();
		t2.start();
		System.out.println(tg.activeGroupCount());
		tg.list();
	}
	public static class ThreadName implements  Runnable{
		@Override
		public void run(){
			String groupName=Thread.currentThread().getThreadGroup().getName()+"-"
					+Thread.currentThread().getName();
			while(true){
				System.out.println("I am "+groupName);
				try{
					Thread.sleep(3000);
				}catch(InterruptedException e){}
			}
		}

	}
}

