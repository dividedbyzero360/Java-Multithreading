package basic_thread_sync_synchronization;

import java.util.concurrent.atomic.AtomicInteger;

//https://stackoverflow.com/questions/4818699/practical-uses-for-atomicinteger
//Every object has what is called intrinsic lock, monitor or mutex.
public class App {

	private int count=0;
	private AtomicInteger count2=new AtomicInteger(0);
	
	public static void main(String[] args) {
      App app=new App();
      app.doWork();
	}
	
	public synchronized void increment()
	{
		count++;
	}
	
	private void doWork()
	{
		Thread t1=new Thread(()->{
			for(int i=0; i< 10000; i++)
			{
				increment();
			    count2.getAndIncrement();
			}
		});
		Thread t2=new Thread(()->{
			for(int i=0; i< 10000; i++)
			{
				increment();
				count2.getAndIncrement();
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(count);
		System.out.println(count2.get());
	}

}
