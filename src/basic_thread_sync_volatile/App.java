package basic_thread_sync_volatile;

import java.util.Scanner;

class Processor implements Runnable
{
	private volatile boolean running=true;
	public void run()
	{
		while(running)
		{
			System.out.println("Hello");
		}
		
	}
	
	public void shutdown()
	{
		running=false;
	}
}

public class App {

	public static void main(String[] args) {
		Processor p=new Processor();
		Thread runner=new Thread(p);
		runner.start();
		Scanner scan=new Scanner(System.in);
		scan.nextLine();
		p.shutdown();
		

	}

}
