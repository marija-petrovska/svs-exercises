import java.util.ArrayList;

import md.Alarm;
import md.AlarmDevice;
import md.Camera;
import md.CameraDevice;
import md.MotionDetector;

public class MotionDetectorApplication {

	public static void main(String[] args) {

		CameraDevice camera = new Camera();
		ArrayList<AlarmDevice> channels = new ArrayList<>();
		AlarmDevice channel = new Alarm();
		channels.add(channel);

		MotionDetector detector = new MotionDetector(camera, channels);
		
		System.out.println("Start detecting...");
		detector.run();
		System.out.println("Finished detecting.");
	}
}
