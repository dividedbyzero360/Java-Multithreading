package thread_local;

public class Processor {
	int value;

	public void increment(int v) {
		value = v;
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(value);
	}

}
