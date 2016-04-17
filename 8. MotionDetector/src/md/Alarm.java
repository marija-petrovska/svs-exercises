package md;

public class Alarm implements AlarmDevice {

	@Override
	public void signalAlarm(String img1, String img2) {
		System.out.println("Different images : " + img1 + " " + img2);
	}
	
}
