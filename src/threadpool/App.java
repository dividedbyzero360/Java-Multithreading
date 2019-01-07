package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable
{
	private int id=0;
	Processor(int id)
	{
		this.id=id;
		
	}
	public void run()
	{
		System.out.println("Thread with id "+ id +" started");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread with id "+ id +" completed");
		
	}
}



public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor=Executors.newFixedThreadPool(2);
		
		for(int i=0; i< 6;i++)
		{
			executor.submit(new Processor(i));
		}
		executor.shutdown();
		System.out.println("All task submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All task completed");
	}

}
