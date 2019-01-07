package producer_consumer_using_wait_notify;

import java.util.LinkedList;
import java.util.Random;

public class Process {

	private LinkedList<Integer> list = new LinkedList<Integer>();
	private final int LIMIT = 10;
	private Object lock = new Object();

	public void producer() {
		int value = 0;
		while (true) {
			synchronized (lock) {
				while (list.size() == LIMIT) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				list.add(value++);
				lock.notify();
			}
		}

	}
	
	public void consumer()
	{
		Random random=new Random();
		while(true)
		{
			synchronized(lock){
				while(list.size()==0)
				{
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int value=list.removeFirst();
				System.out.println("Value is "+value + " .The list size is "+ list.size());
				lock.notify();
			}
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
