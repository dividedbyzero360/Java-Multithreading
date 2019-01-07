package producer_consumer_using_blocking_queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

	static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			producer();
		});
		Thread t2 = new Thread(() -> {
			consumer();
		});
		t1.start();
		t2.start();
	}

	public static void producer() {
		Random random = new Random();
		while (true) {
			try {
				queue.put(random.nextInt(100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void consumer() {
		Random random = new Random();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (true) {
			if (random.nextInt(10) == 0) {
				try {
					System.out.println("Taken out value is " + queue.take() + " queue size is " + queue.size());
					;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
