
public class AcmeEfficientThermoregulator extends AcmeThermoregulator {

	public AcmeEfficientThermoregulator(AcmeHeaterDevice heater, AcmeThermometerDevice thermometer) {
		super(heater, thermometer);
	}

	@Override
	public void run() {
		int current;
		while (powerEnabled) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
			current = thermometer.getTemperature();
			System.out.println("Current temperature is: " + current);
			if (current > valueToObtain) {
				heater.disable();
			}
			if (current < valueToObtain) {
				heater.enable();
			}
		}
	}
}
