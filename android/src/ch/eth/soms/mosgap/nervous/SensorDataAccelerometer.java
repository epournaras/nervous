package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

import android.util.Log;

public class SensorDataAccelerometer extends SensorData {
	private final int accuracy;
	private final float accX;
	private final float accY;
	private final float accZ;

	public SensorDataAccelerometer(final long timestamp, final int accuracy,
			final float accX, final float accY, final float accZ) {
		super(timestamp);
		this.accuracy = accuracy;
		this.accX = accX;
		this.accY = accY;
		this.accZ = accZ;
	}

	public SensorDataAccelerometer(String data) {
		super(0);
		String[] values = data.split(";");
		long v_timestamp = 0;
		int v_accuracy = 0;
		float v_accX = 0, v_accY = 0, v_accZ = 0;
		try {
			v_timestamp = Long.parseLong(values[0]);
			v_accuracy = Integer.parseInt(values[2]);
			v_accX = Float.parseFloat(values[3]);
			v_accY = Float.parseFloat(values[4]);
			v_accZ = Float.parseFloat(values[5]);
		} catch (NumberFormatException e) {
			Log.e(DEBUG_TAG, "Unparsable line: " + data);
		}
		this.timestamp = v_timestamp;
		this.accuracy = v_accuracy;
		this.accX = v_accX;
		this.accY = v_accY;
		this.accZ = v_accZ;
	}

	@Override
	public String getSensorIdentifier() {
		return "acc";
	}

	@Override
	public ArrayList<String> getSensorValuesDescription() {
		ArrayList<String> values = new ArrayList<>();
		values.add(getSensorIdentifier());
		values.add("accuracy");
		values.add("x");
		values.add("y");
		values.add("z");
		return values;
	}

	private static final String DEBUG_TAG = "SensorService";

	@Override
	public String toString() {
		ArrayList<String> values = new ArrayList<String>();
		values.add(getTimestamp() + "");
		values.add(getSensorIdentifier());
		values.add(String.valueOf(accuracy));
		values.add(String.valueOf(accX));
		values.add(String.valueOf(accY));
		values.add(String.valueOf(accZ));
		Log.d(DEBUG_TAG,
				"Accelerometer Value: " + StringUtility.separate(values, ";"));
		return StringUtility.separate(values, ";");
	}

	public int getAccuracy() {
		return accuracy;
	}

	public float getAccX() {
		return accX;
	}

	public float getAccY() {
		return accY;
	}

	public float getAccZ() {
		return accZ;
	}

}
