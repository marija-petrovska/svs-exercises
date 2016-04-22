public class Logger {

	public static void log(String msg) {
		System.out.println(Thread.currentThread().getName() + ": " + msg);
	}
}
