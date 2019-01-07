package interrupt;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Starting");
		Thread t=new Thread(()->{
			
			Random random=new Random();
			for(int i=0;i < 1E7;i++)
			{
				if(Thread.currentThread().isInterrupted()){
					System.out.println("Thread interrupted");
					break;
				}
				Math.sin(random.nextDouble());
			}
			System.out.println("Finish");
			
		});
		
		t.start();
		Thread.sleep(10);
		t.interrupt();
		t.join();
		System.out.println("Ending");
		
		
		ExecutorService executors=Executors.newCachedThreadPool();
		Future<?> fu=executors.submit(()->{
			System.out.println("Starting");
			Random random=new Random();
			for(int i=0;i < 1E7;i++)
			{
				if(Thread.currentThread().isInterrupted()){
					System.out.println("Thread interrupted");
					break;
				}
				Math.sin(random.nextDouble());
			}
			System.out.println("Finish");
		});
		executors.shutdown();
		fu.cancel(true); // one way to interrupt
		executors.shutdownNow(); // another way to interrupt
		
	}

}
