package wait_notify;

public class App {

	public static void main(String[] args) {
		Process p=new Process();
		Thread t1=new Thread(()->{
			p.producer();
		});
		Thread t2=new Thread(()->{
			p.consumer();
		});
		Thread t3=new Thread(()->{
			p.producer2();
		});
		t1.start();
		t2.start();
		t3.start();

	}

}
