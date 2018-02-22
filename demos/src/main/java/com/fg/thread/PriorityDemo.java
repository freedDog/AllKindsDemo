package com.fg.thread;
/**
 * 线程的优先级测试
 */
public class PriorityDemo {
	public static class HightPriority extends Thread{
		static int count=0;
		@Override
		public void run(){
			while(true){
				//这里设置为类锁
				synchronized(PriorityDemo.class){
					count++;
					if(count>100000){
						System.out.println("HightPriority is complete");
						break;
					}
				}
			}
		}
	}
	public static class LowPriority extends Thread{
		static int count=0;
		@Override
		public void run(){
			while(true){
				synchronized(PriorityDemo.class){
					count++;
					if(count>100000){
						System.out.println("LowPriority is complete");
						break;
					}
				}
			}
		}
	}
	public static void test(){
		Thread high=new HightPriority();
		Thread low=new LowPriority();

		//设置线程的优先级
		high.setPriority(Thread.MAX_PRIORITY);
		low.setPriority(Thread.MIN_PRIORITY);
		
		high.start();
		low.start();
	}
}

