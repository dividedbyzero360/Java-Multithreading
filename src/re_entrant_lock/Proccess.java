package re_entrant_lock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Proccess {
	private Lock lock=new ReentrantLock();
	private Condition cond=lock.newCondition();
	private int count=0;
	private void increment()
	{
		for(int i=0; i<1000;i++)
		{
			
			count++;
		}
	}
	
	public void firstThread()
	{
		lock.lock();
		System.out.println("Waiting");
		try {
			cond.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Woken up");
		try{
			increment();
		}finally{
			lock.unlock();
		}
		
	}
	
	public void secondThread()
	{
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lock.lock();
		System.out.println("Second thread running. Press the return key to signal firstThread to run after I unlock the lock");
		new Scanner(System.in).nextLine();
		cond.signal();
		try{
			increment();
		}finally{
			lock.unlock();
		}
	}
	
	public void finished()
	{
		System.out.println("The count is "+count);
	}

}
