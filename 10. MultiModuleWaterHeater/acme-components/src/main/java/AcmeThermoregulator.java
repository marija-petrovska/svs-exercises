
public abstract class AcmeThermoregulator implements Runnable {

	protected boolean powerEnabled = false;
	protected Integer valueToObtain;
	protected AcmeHeaterDevice heater;
	protected AcmeThermometerDevice thermometer;
	protected Thread thread;

	public AcmeThermoregulator(AcmeHeaterDevice heater, AcmeThermometerDevice thermometer) {
		this.heater = heater;
		this.thermometer = thermometer;
	}

	public void enablePower() {
		thread = new Thread(this);
		powerEnabled = true;
		thread.start();
	}

	public void disablePower() {
		powerEnabled = false;
		thread.interrupt();
	}

	public void setTemperature(Integer temperature) {
		valueToObtain = temperature;
	}
}
