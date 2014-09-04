package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

public class SensorDataHumidity extends SensorData {
	private final int accuracy;
	private final float humidity;

	public SensorDataHumidity(final long timestamp, final int accuracy,
			final float humidity) {
		super(timestamp);
		this.accuracy = accuracy;
		this.humidity = humidity;
	}

	@Override
	public String getSensorIdentifier() {
		return "humid";
	}

	@Override
	public ArrayList<String> getSensorValuesDescription() {
		ArrayList<String> values = new ArrayList<>();
		values.add(getSensorIdentifier());
		values.add("accuracy");
		values.add("humidity");
		return values;
	}
	
	@Override
	public String toString() {
		ArrayList<String> values = new ArrayList<String>();
		values.add(getTimestamp() + "");
		values.add(getSensorIdentifier());
		values.add(String.valueOf(accuracy));
		values.add(String.valueOf(humidity));
		return StringUtility.separate(values, ";");
	}

	public int getAccuracy() {
		return accuracy;
	}

	public float getHumidity() {
		return humidity;
	}

}
