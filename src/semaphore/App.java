package semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App {

	public static void main1(String[] args) throws InterruptedException {
		Semaphore sem=new Semaphore(0); // The integer is number of permits
		sem.acquire();// Decrements the counter of semaphore, if count reaches to zero this statement blocks
		sem.release();// With locks we have to unlock the lock from the same thread that locked it, no such requirement for semaphores. 
		//Semaphore is used to control access to some resource
		System.out.println("Number of availabe permits "+ sem.availablePermits());

	}
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor=Executors.newCachedThreadPool();
		for(int i=0; i< 200; i++)
		{
			executor.submit(()->Connection.getConnection().connect());
		}
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.DAYS);
	}
}
