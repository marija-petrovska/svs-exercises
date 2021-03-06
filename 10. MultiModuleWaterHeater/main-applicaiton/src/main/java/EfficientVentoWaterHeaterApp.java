
public class EfficientVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final VentoHeaterAdapter heaterAdapter = new VentoHeaterAdapter(ventoHeater);
		final VentoThermometerAdapter thermometerAdapter = new VentoThermometerAdapter(ventoThermometer);
		final AcmeThermoregulator efficientRegulator = new AcmeEfficientThermoregulator(heaterAdapter, thermometerAdapter);
		final VentoRegulatorAdapter regulatorAdapter = new VentoRegulatorAdapter(efficientRegulator);

		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);
		ventoPowerSwitch.controlPowerFor(regulatorAdapter);

		VentoWaterHeaterApp.run(regulatorAdapter, ventoPowerSwitch);
	}
}
