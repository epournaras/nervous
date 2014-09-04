package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

public abstract class SensorData {
	
	private final long timestamp;

	public abstract String toString();
	
	public SensorData(final long timestamp)
	{
		this.timestamp = timestamp;
	}
	
	public static String[] getDataColumns() {
		return null;
	}
	
	public abstract String getSensorIdentifier();

	public abstract ArrayList<String> getSensorValuesDescription();
	
	public long getTimestamp() {
		return timestamp;
	}
	

}
