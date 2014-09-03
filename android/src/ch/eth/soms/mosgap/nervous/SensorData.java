package ch.eth.soms.mosgap.nervous;

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

	public long getTimestamp() {
		return timestamp;
	}
	

}
