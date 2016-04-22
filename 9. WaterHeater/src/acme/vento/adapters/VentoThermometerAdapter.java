package acme.vento.adapters;

import acme.components.AcmeThermometerDevice;
import com.ventoelectrics.waterheater.VentoThermometer;

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
