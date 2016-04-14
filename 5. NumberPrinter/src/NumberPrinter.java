public class NumberPrinter {

	public static void main(String[] args) throws Exception {

		int untilNumber = Integer.parseInt(args[0]);
		long timeInterval = Long.parseLong(args[1]);
		
		final Task task = new Task(untilNumber);
		final Thread taskThread = new Thread(task);
		taskThread.start();
		
		Thread.sleep(timeInterval);
		Logger.log("Interupting the task...");
		taskThread.interrupt();
	}

	public static class Task implements Runnable {

		private int number = 1;

		public Task(int number) {
			this.number = number;
		}

		@Override
		public void run() {
			for (int i = 1; i <= number; i++) {
				if (Thread.interrupted()) {
					Logger.log("I've been interrupted.");
					return;
				}
				System.out.println(i);
			}
		}
	}
}
