package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

public class SensorDataMagnetic extends SensorData {
	private final int accuracy;
	private final float magX;
	private final float magY;
	private final float magZ;

	public SensorDataMagnetic(final long timestamp, final int accuracy,
			final float magX, final float magY, final float magZ) {
		super(timestamp);
		this.accuracy = accuracy;
		this.magX = magX;
		this.magY = magY;
		this.magZ = magZ;
	}

	@Override
	public String getSensorIdentifier() {
		return "mag";
	}

	@Override
	public String toString() {
		ArrayList<String> values = new ArrayList<String>();
		values.add(getTimestamp() + "");
		values.add(getSensorIdentifier());
		values.add(String.valueOf(accuracy));
		values.add(String.valueOf(magX));
		values.add(String.valueOf(magY));
		values.add(String.valueOf(magZ));
		return StringUtility.separate(values, ";");
	}

	public int getAccuracy() {
		return accuracy;
	}

	public float getMagX() {
		return magX;
	}

	public float getMagY() {
		return magY;
	}

	public float getMagZ() {
		return magZ;
	}

}
