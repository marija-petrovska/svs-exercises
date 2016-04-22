package acme.vento.adapters;

import acme.components.AcmeThermoregulator;
import com.ventoelectrics.waterheater.VentoThermoregulator;

public class VentoRegulatorAdapter implements VentoThermoregulator{

	private AcmeThermoregulator thermoregulator;
	
	public VentoRegulatorAdapter(AcmeThermoregulator thermoregulator) {
		this.thermoregulator = thermoregulator;
	}

	@Override
	public void enablePower() {
		thermoregulator.enablePower();
	}

	@Override
	public void disablePower() {
		thermoregulator.disablePower();
	}

	@Override
	public void setTemperature(Integer temperature) {
		thermoregulator.setTemperature(temperature);
	}
}
