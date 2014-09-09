package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

import android.util.Log;

public class SensorDataBattery extends SensorData {

	private final float batteryPercent;
	private final boolean isCharging;
	private final boolean isUsbCharge;
	private final boolean isAcCharge;

	public SensorDataBattery(final long timestamp, float batteryPercent,
			final boolean isCharging, final boolean isUsbCharge,
			final boolean isAcCharge) {
		super(timestamp);
		this.batteryPercent = batteryPercent;
		this.isCharging = isCharging;
		this.isUsbCharge = isUsbCharge;
		this.isAcCharge = isAcCharge;
	}

	@Override
	public String getSensorIdentifier() {
		return "batt";
	}

	@Override
	public ArrayList<String> getSensorValuesDescription() {
		ArrayList<String> values = new ArrayList<String>();
		values.add(getSensorIdentifier());
		values.add("percent");
		values.add("isCharging");
		values.add("isUsbCharging");
		values.add("isAcCharging");
		return values;
	}
	
	@Override
	public String toString() {
		ArrayList<String> values = new ArrayList<String>();
		values.add(getTimestamp() + "");
		values.add(getSensorIdentifier());
		values.add(String.valueOf(batteryPercent));
		values.add(String.valueOf(isCharging ? 1 : 0));
		values.add(String.valueOf(isUsbCharge ? 1 : 0));
		values.add(String.valueOf(isAcCharge ? 1 : 0));
		return StringUtility.separate(values, ";");
	}

	public float getBatteryPercent() {
		return batteryPercent;
	}

	public boolean isCharging() {
		return isCharging;
	}

	public boolean isUsbCharge() {
		return isUsbCharge;
	}

	public boolean isAcCharge() {
		return isAcCharge;
	}

}
