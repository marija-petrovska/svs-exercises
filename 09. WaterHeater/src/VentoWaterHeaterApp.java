import java.util.concurrent.TimeUnit;
import com.ventoelectrics.waterheater.VentoPowerSwitch;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class VentoWaterHeaterApp {

	public static void run(VentoThermoregulator thermoregulator, VentoPowerSwitch powerSwitch) {
		
		thermoregulator.setTemperature(20);
		System.out.println("Set temperature to 20");
		powerSwitch.turnOn();

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
		thermoregulator.setTemperature(40);
		System.out.println("Set temperature to 40");
		
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
		}
		powerSwitch.turnOff();
	}
}
