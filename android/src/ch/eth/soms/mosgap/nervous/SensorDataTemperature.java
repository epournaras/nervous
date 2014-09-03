package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

public class SensorDataTemperature extends SensorData {
	private final int accuracy;
	private final float temperature;

	public SensorDataTemperature(final long timestamp, final int accuracy,
			final float temperature) {
		super(timestamp);
		this.accuracy = accuracy;
		this.temperature = temperature;
	}

	@Override
	public String getSensorIdentifier() {
		return "temp";
	}

	@Override
	public String toString() {
		ArrayList<String> values = new ArrayList<String>();
		values.add(getTimestamp() + "");
		values.add(getSensorIdentifier());
		values.add(String.valueOf(accuracy));
		values.add(String.valueOf(temperature));
		return StringUtility.separate(values, ";");
	}

	public int getAccuracy() {
		return accuracy;
	}

	public float getTemperature() {
		return temperature;
	}

}
