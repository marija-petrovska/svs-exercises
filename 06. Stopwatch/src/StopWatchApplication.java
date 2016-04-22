import java.util.Scanner;

public class StopWatchApplication {

	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		StopWatch watch = new StopWatch();

		String command;
		System.out.println("Enter 'start' for starting a stopwatch...");
		
		while (!(command = in.nextLine()).equals("exit")) {
			
			System.out.println(command);

			switch (command) {
				case "start":
					watch.start();
					break;
				case "pause":
					watch.pause();
					break;
				case "resume":
					watch.resume();
					break;
				case "stop":
					watch.stop();
					break;
				}
		}
		in.close();
	}

}
