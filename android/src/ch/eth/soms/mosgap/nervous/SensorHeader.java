package ch.eth.soms.mosgap.nervous;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import android.hardware.Sensor;
import android.hardware.SensorManager;

public class SensorHeader {

	long TS = System.currentTimeMillis();

	private static final String OS_INFO = System.getProperty("os.version")
			+ "(" + android.os.Build.VERSION.INCREMENTAL + ")";
	private static final int API_LEVEL = android.os.Build.VERSION.SDK_INT;
	private static final String DEVICE = android.os.Build.DEVICE;
	private static final String MODEL = android.os.Build.MODEL + " ("
			+ android.os.Build.PRODUCT + ")";

	private final LinkedList<Class<? extends SensorData>> sensorDataClasses;
	private final LinkedList<Boolean> sensorTypeListenerList;

	private final SensorManager sensorManager;

	public SensorHeader(final SensorManager sensorManager) {
		// assigns all the sensor classes
		sensorDataClasses = new LinkedList<Class<? extends SensorData>>();
		sensorTypeListenerList = new LinkedList<Boolean>();
		this.sensorManager = sensorManager;
	}

	public void addSensor(Class<? extends SensorData> sensorClass,
			boolean sensorTypeListener) {
		sensorDataClasses.add(sensorClass);
		sensorTypeListenerList.add(sensorTypeListener);
	}

	public String toString() {

		// a string that contains all the information
		// and the different types of sensors
		// and headers of the columns of observations
		StringBuilder sb = new StringBuilder();
		// Header

		sb.append(TS + "\n");
		sb.append("meta.os;" + OS_INFO + "\n");
		sb.append("meta.api.level;" + String.valueOf(API_LEVEL) + "\n");
		sb.append("device.type;" + String.valueOf(DEVICE) + "\n");
		sb.append("model.number;" + String.valueOf(MODEL) + "\n");
		sb.append("\n");

		// Sensor information
		List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
		for (Sensor sensor : sensorList) {
			switch (sensor.getType()) {
			case Sensor.TYPE_ACCELEROMETER:
				sb.append("Type;" + String.valueOf(sensor.getType())
						+ "-ACCELEROMETER\n");
				appendSensorInfo(sb, sensor);
				sb.append("values;"
						+ StringUtility.separate((new SensorDataAccelerometer(
								0, 0, 0, 0, 0).getSensorValuesDescription()),
								";"));
				sb.append("\n\n");
				break;
			case Sensor.TYPE_AMBIENT_TEMPERATURE:
				sb.append("Type;" + String.valueOf(sensor.getType())
						+ "-AMBIENT_TEMPERATURE\n");
				appendSensorInfo(sb, sensor);
				sb.append("values;"
						+ StringUtility.separate((new SensorDataTemperature(0,
								0, 0).getSensorValuesDescription()), ";"));
				sb.append("\n\n");
				break;
			case Sensor.TYPE_GYROSCOPE:
				sb.append("Type;" + String.valueOf(sensor.getType())
						+ "-GYROSCOPE\n");
				appendSensorInfo(sb, sensor);
				sb.append("values;"
						+ StringUtility.separate((new SensorDataGyroscope(0, 0,
								0, 0, 0).getSensorValuesDescription()), ";"));
				sb.append("\n\n");
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				sb.append("Type;" + String.valueOf(sensor.getType())
						+ "-MAGNETIC_FIELD\n");
				appendSensorInfo(sb, sensor);
				sb.append("values;"
						+ StringUtility.separate((new SensorDataMagnetic(0, 0,
								0, 0, 0).getSensorValuesDescription()), ";"));
				sb.append("\n\n");
				break;
			case Sensor.TYPE_LIGHT:
				sb.append("Type;" + String.valueOf(sensor.getType())
						+ "-LIGHT\n");
				appendSensorInfo(sb, sensor);
				sb.append("values;"
						+ StringUtility.separate((new SensorDataLight(0, 0, 0)
								.getSensorValuesDescription()), ";"));
				sb.append("\n\n");
				break;
			case Sensor.TYPE_PRESSURE:
				sb.append("Type;" + String.valueOf(sensor.getType())
						+ "-PRESSURE\n");
				appendSensorInfo(sb, sensor);
				// TODO: add sensorValuesDescription
				sb.append("\n\n");
				break;
			case Sensor.TYPE_PROXIMITY:
				sb.append("Type;" + String.valueOf(sensor.getType())
						+ "-PROXIMITY\n");
				appendSensorInfo(sb, sensor);
				sb.append("values;"
						+ StringUtility.separate((new SensorDataProximity(0, 0,
								0).getSensorValuesDescription()), ";"));
				sb.append("\n\n");
				break;
			default:
				break;
			}
		}
		return sb.toString();
	}

	private void appendSensorInfo(StringBuilder sb, Sensor sensor) {
		sb.append("Name;" + sensor.getName() + "\n");
		sb.append("Maximum.Range;" + String.valueOf(sensor.getMaximumRange())
				+ "\n");
		sb.append("Min.Delay;" + String.valueOf(sensor.getMinDelay()) + "\n");
		sb.append("Power;" + String.valueOf(sensor.getPower()) + "\n");
		sb.append("Resolution;" + String.valueOf(sensor.getResolution()) + "\n");
		sb.append("Type;" + String.valueOf(sensor.getType()) + "\n");
		sb.append("Vendor;" + String.valueOf(sensor.getVendor()) + "\n");
		sb.append("Version;" + String.valueOf(sensor.getVersion()) + "\n");
	}

	// getSensorDataClasses() returns a linked list of type class
	public LinkedList<Class<? extends SensorData>> getSensorDataClasses() {
		return sensorDataClasses;
	}

	public LinkedList<Boolean> getSensorTypeListenerList() {
		return sensorTypeListenerList;
	}

}
