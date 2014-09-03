package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

public class SensorDataLight extends SensorData {
	private final int accuracy;
	private final float light;

	public SensorDataLight(final long timestamp, final int accuracy,
			final float light) {
		super(timestamp);
		this.accuracy = accuracy;
		this.light = light;
	}

	@Override
	public String getSensorIdentifier() {
		return "light";
	}

	@Override
	public String toString() {

		ArrayList<String> values = new ArrayList<String>();
		values.add(getTimestamp() + "");
		values.add(getSensorIdentifier());
		values.add(String.valueOf(accuracy));
		values.add(String.valueOf(light));
		return StringUtility.separate(values, ";");
	}

	public int getAccuracy() {
		return accuracy;
	}

	public float getLight() {
		return light;
	}

}
