package com.fg.thread;

import java.util.concurrent.locks.ReentrantLock;

import com.fg.thread.ReEnterLock;

/**
 * 重入锁测试
 */
public class ReEnterLock {
	public static ReentrantLock lock=new ReentrantLock();
	public static int i=0;
	public static class ReEnterLockRun implements Runnable{
		@Override
		public void run(){
			for(int j=0;j<1000000;j++){
				lock.lock();
				try{
					i++;
				}finally{
					lock.unlock();
				}
			}
		}
	}
	public static void test(){
		ReEnterLockRun tl=new ReEnterLockRun();

		Thread t_1=new Thread(tl); 
		Thread t_2=new Thread(tl);
		t_1.start();
		t_2.start();
		try{
		t_1.join();
		t_2.join();
		}catch(InterruptedException  e){
			e.printStackTrace();
		}
		System.out.println(i);
	}
}

