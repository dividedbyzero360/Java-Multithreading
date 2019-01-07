package basic_thread_sync_multiple_locks;

import java.util.*;

public class Worker {

	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	private Random random = new Random();
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void main() {
		long startTime = System.currentTimeMillis();
		Thread t1 = new Thread(() -> {
			process();
		});
		Thread t2 = new Thread(() -> {
			process();
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
		long end = System.currentTimeMillis();
		System.out.println("Time taken " + (end - startTime) + " ms");
		System.out.println("Size of list1 " + list1.size());
		System.out.println("Size of list2 " + list2.size());

	}

	public synchronized void stageOne() {

		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list1.add(random.nextInt(100));
	}

	public synchronized void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		list2.add(random.nextInt(100));
	}

	public void stageOne2() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list1.add(random.nextInt(100));
		}

	}

	public void stageTwo2() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list2.add(random.nextInt(100));
		}

	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne2();
			stageTwo2();
		}
	}

}
