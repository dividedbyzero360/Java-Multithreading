package callable_and_runnable;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {
        ExecutorService executors= Executors.newCachedThreadPool();
        Future<Integer> future=   executors.submit(()->{
        	System.out.println("Starting thread");
        	Random random=new Random();
        	int duration=random.nextInt(4000);
        	if(duration > 2000)
        	{
        		throw new IOException("Slept for too long");
        	}
        	Thread.sleep(duration);
        	System.out.println("Finished");
        	return duration;
        });
        
        executors.shutdown();
        try {
			System.out.println("The duration is "+future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ex=(IOException)e.getCause();
			System.out.println(ex.getMessage());
		}
	}

}
