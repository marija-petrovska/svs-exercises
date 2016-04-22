package acme.vento.adapters;

import acme.components.AcmeHeaterDevice;
import com.ventoelectrics.waterheater.VentoHeater;

public class VentoHeaterAdapter implements AcmeHeaterDevice {
	
	private VentoHeater ventoHeater;
	
	public VentoHeaterAdapter(VentoHeater ventoHeater) {
		this.ventoHeater = ventoHeater;
	}
	
	@Override
	public void disable() {
		ventoHeater.disable();
	}
	
	@Override
	public void enable() {
		ventoHeater.enable();
	}
}
