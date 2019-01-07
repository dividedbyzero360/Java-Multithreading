package deadlock_and_avoidance;

public class App {

	public static void main(String[] args) throws InterruptedException {
		//Process_DeadLock processWithDeadLock = new Process_DeadLock();
		Process_NoDeadLock processWithNoDeadLock = new Process_NoDeadLock();
		Thread t1 = new Thread(() -> {
			try {
				//processWithDeadLock.firstThread();
				processWithNoDeadLock.firstThread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				//processWithDeadLock.secondThread();
				processWithNoDeadLock.secondThread();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		//processWithDeadLock.getBalance();
		processWithNoDeadLock.getBalance();

	}

}
