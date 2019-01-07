package wait_notify;

import java.util.Scanner;

public class Process {
	
	public void producer()
	{
		synchronized (this) {
			System.out.println("Producer started");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println("Producer resumed");
			
		}
	}
	
	public void consumer()
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (this) {
			System.out.println("consumer started");
			//notify();
			notifyAll();
			Scanner scan=new Scanner(System.in);
			scan.nextLine();
			System.out.println("consumer quitting");
			
		}
	}
	
	public void producer2()
	{
		try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		synchronized (this) {
			System.out.println("Producer2 started");
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			System.out.println("Producer2 resumed");
			
		}
	}

}
