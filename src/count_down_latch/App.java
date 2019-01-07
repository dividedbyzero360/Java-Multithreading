package count_down_latch;


// check countdownlatch vs join
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor implements Runnable
{
	CountDownLatch latch=null;
	Processor(CountDownLatch latch)
	{
		this.latch=latch;
	}
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " started");
		latch.countDown();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " completed");
		
	}
}


public class App {

	public static void main(String[] args) {
		CountDownLatch latch=new CountDownLatch(7);
		ExecutorService executor=Executors.newFixedThreadPool(3);
		for(int i=0;i <6;i++)
		{
			executor.submit(new Processor(latch));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Done");
	}

}
