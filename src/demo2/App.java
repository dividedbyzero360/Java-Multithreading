package demo2;


class Runner implements Runnable
{
	public void run()
	{
		for(int i=0; i<10;i++)
		{
			System.out.println("Hello "+i);
			try{
				Thread.sleep(100);	
			}catch(InterruptedException ex)
			{
				System.out.println("InterruptedException exception occured");
			}
			
		}
	}
}

public class App {

	public static void main(String[] args) {
		Thread runner1=new Thread(new Runner());
		Thread runner2=new Thread(new Runner());
		runner1.start();
		runner2.start();
		System.out.println("Main thread ");
		System.out.println(runner1.isDaemon());// false 
		System.out.println(runner2.isDaemon());// false

	}

}
