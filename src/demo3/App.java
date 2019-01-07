package demo3;

public class App {

	public static void main(String[] args) {
		
		Thread runner1=new Thread(()->{
			run();
		});
		Thread runner2=new Thread(App::run);
		runner1.start();
		runner2.start();
		System.out.println("Main thread ");
		System.out.println(runner1.isDaemon());// false 
		System.out.println(runner2.isDaemon());// false
		
		

	}
	
	
	public static void run(){
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
