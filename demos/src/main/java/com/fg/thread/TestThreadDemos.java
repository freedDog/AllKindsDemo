package com.fg.thread;

import com.fg.thread.DaemonDemo;
import com.fg.thread.InterruptThread;
import com.fg.thread.PriorityDemo;
import com.fg.thread.ReEnterLock;
import com.fg.thread.SimpleWN;
import com.fg.thread.StopThreadUnsafe;
import com.fg.thread.ThreadGroupName;

/**
 * 测试所有关于线程的main()方法
 */
public class TestThreadDemos {
	public static void main(String[] args){
		//StopThreadUnsafe.test();
		//InterruptThread.test();
		//SimpleWN.test();
		//ThreadGroupName.test();
		//DaemonDemo.test();
		//PriorityDemo.test();
		ReEnterLock.test();
	}
}

