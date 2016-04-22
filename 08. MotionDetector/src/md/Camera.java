package md;

import java.util.Scanner;

public class Camera implements CameraDevice {

	Scanner in = new Scanner(System.in);
	String picture;

	@Override
	public String capture() {		
		picture = in.nextLine();		
			if (picture.length() == 0) {
				return null;
			}
		return picture;
	}
}
