package com.fg.thread;
/**
 * 测试线程的中断方法 interrupt()
 * 当在线程休眠状态中，使用设置中断状态将会出现中断失败的异常
 * 并且会清除中断标志，因此在异常处理中再次设置中断标志
 */
public class InterruptThread {
	public static void test(){
		Thread t1=new Thread(){
			@Override
			public void run(){
				while(true){
					if(Thread.currentThread().isInterrupted()){
						System.out.println("Interrupted!");
						break;
					}
					try{
						System.out.println("start");
						Thread.sleep(1000);
					}catch(InterruptedException e){
						System.out.println("Interrupted when sleep");
						//设置中断状态
						Thread.currentThread().interrupt();
					}
					Thread.yield();
				}
			
			}
		};
		t1.start();
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}
		t1.interrupt();
	}
}

