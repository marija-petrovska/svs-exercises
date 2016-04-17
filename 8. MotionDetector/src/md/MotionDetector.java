package md;

import java.util.ArrayList;

public class MotionDetector {

	private CameraDevice camera;
	private ArrayList<AlarmDevice> channels;

	public MotionDetector(CameraDevice camera, ArrayList<AlarmDevice> channels) {
		this.camera = camera;
		this.channels = channels;
	}

	public void run() {

		String img1 = camera.capture();
			if (img1 == null) {
				return;
			}
		String img2 = img1;
		while ((img1 = camera.capture()) != null) {

			if (!img1.equals(img2)) {
				for (AlarmDevice channel : channels) {
					channel.signalAlarm(img2, img1);
				}
			}
			img2 = img1;
		}
	}
}
