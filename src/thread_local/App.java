package thread_local;

public class App {

	public static void main1(String[] args) throws InterruptedException {
		Processor p=new Processor();
		Thread t1=new Thread(()->{
			p.increment(11);
		});
		Thread t2=new Thread(()->{
			p.increment(12);
		});
		
		t1.start();
		t2.start();
		Thread.sleep(2000);
		p.value=16;
	}
	
	public static void main(String[] args) throws InterruptedException {
		Processor_ThreadLocal p=new Processor_ThreadLocal();
		Thread t1=new Thread(()->{
			p.increment(11);
		});
		Thread t2=new Thread(()->{
			p.increment(12);
		});
		
		t1.start();
		t2.start();
		Thread.sleep(2000);
		System.out.println(p.value.get());
	}

}
