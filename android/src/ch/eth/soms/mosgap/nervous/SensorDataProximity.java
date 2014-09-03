package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

public class SensorDataProximity extends SensorData {
	private final int accuracy;
	private final float proximity;

	public SensorDataProximity(final long timestamp, final int accuracy,
			final float proximity) {
		super(timestamp);
		this.accuracy = accuracy;
		this.proximity = proximity;
	}

	@Override
	public String getSensorIdentifier() {
		return "prox";
	}

	@Override
	public String toString() {
		ArrayList<String> values = new ArrayList<String>();
		values.add(getTimestamp() + "");
		values.add(getSensorIdentifier());
		values.add(String.valueOf(accuracy));
		values.add(String.valueOf(proximity));
		return StringUtility.separate(values, ";");
	}

	public int getAccuracy() {
		return accuracy;
	}

	public float getProximity() {
		return proximity;
	}

}
