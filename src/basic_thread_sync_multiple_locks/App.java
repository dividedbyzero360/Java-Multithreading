package basic_thread_sync_multiple_locks;

public class App {

	public static void main(String[] args) {
		Worker worker=new Worker();
		worker.main();
	}

}
