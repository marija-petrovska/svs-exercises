public class StopWatch implements Runnable {

	private int count;
	private boolean paused = false;
	private Thread thread;

	public void start() {
		count = 1;
		// pause -> start (restart)
		if (paused) {
			resume();
		}
		// stop -> start
		else {
			thread = new Thread(this);
			thread.start();
		}
	}
	// start -> pause
	public void pause() {
		paused = true;
	}
	// pause -> resume
	public void resume() {
		synchronized (this) {
			paused = false;
			notifyAll();
		}
	}
	public void stop() {
		// pause -> stop
		if (paused) {
			resume();
		}
		// start -> stop
		thread.interrupt();
	}
	@Override
	public void run() {
		while (true) {
			// count
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Logger.log("I've been stoped.");
				return;
			}
			System.out.println(count++);
			// interrupt if it is stopped
			if (Thread.interrupted()) {
				Logger.log("I've been stoped.");
				return;
			}
			// wait if pause
			while (paused) {
				synchronized (this) {
					try {
						wait();
					} catch (InterruptedException e) {
						return;
					}
				}
			}
			// continue with count
		}
	}
}
