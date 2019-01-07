package producer_consumer_using_wait_notify;



public class App {

	public static void main(String[] args) {
		Process p=new Process();
		Thread t1=new Thread(()->{
			p.producer();
		});
		Thread t2=new Thread(()->{
			p.consumer();
		});
		
		t1.start();
		t2.start();
	}

}
