package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

public class SensorDataGyroscope extends SensorData {
	private final int accuracy;
	private final float gyrX;
	private final float gyrY;
	private final float gyrZ;

	public SensorDataGyroscope(final long timestamp, final int accuracy,
			final float gyrX, final float gyrY, final float gyrZ) {
		super(timestamp);
		this.accuracy = accuracy;
		this.gyrX = gyrX;
		this.gyrY = gyrY;
		this.gyrZ = gyrZ;
	}

	@Override
	public String getSensorIdentifier() {
		return "gyr";
	}

	@Override
	public String toString() {
		ArrayList<String> values = new ArrayList<String>();
		values.add(getTimestamp() + "");
		values.add(getSensorIdentifier());
		values.add(String.valueOf(accuracy));
		values.add(String.valueOf(gyrX));
		values.add(String.valueOf(gyrY));
		values.add(String.valueOf(gyrZ));
		return StringUtility.separate(values, ";");
	}

	public int getAccuracy() {
		return accuracy;
	}

	public float getGyrX() {
		return gyrX;
	}

	public float getGyrY() {
		return gyrY;
	}

	public float getGyrZ() {
		return gyrZ;
	}

}
