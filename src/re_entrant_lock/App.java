package re_entrant_lock;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Proccess p = new Proccess();
		Thread t1 = new Thread(() -> {
			p.firstThread();
		});
		Thread t2 = new Thread(() -> {
			p.secondThread();
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.finished();

	}

}
