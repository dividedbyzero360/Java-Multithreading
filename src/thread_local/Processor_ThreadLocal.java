package thread_local;

public class Processor_ThreadLocal {
    ThreadLocal<Integer> value=new ThreadLocal<>();
	public void increment(int v) {
		value.set(v);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(value.get());
	}
}
