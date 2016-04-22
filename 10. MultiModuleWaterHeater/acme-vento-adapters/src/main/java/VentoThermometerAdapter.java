
public class VentoThermometerAdapter implements AcmeThermometerDevice {
	
	private VentoThermometer ventoThermometer;
	
	public VentoThermometerAdapter(VentoThermometer ventoThermometer) {
		this.ventoThermometer = ventoThermometer;
	}

	@Override
	public int getTemperature() {
		return ventoThermometer.getTemperature();
	}
}
