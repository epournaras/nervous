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

	@Override
	public String getSensorIdentifier() {
		return "acc";
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
		Log.d(DEBUG_TAG, "Accelerometer Value: " + StringUtility.separate(values, ";"));
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
