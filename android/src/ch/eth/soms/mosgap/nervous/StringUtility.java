package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;

public class StringUtility {

	public static String separate(ArrayList<String> values, String separator) {
		StringBuilder sb = new StringBuilder();
		if (values == null || values.isEmpty()) {
		} else {
			for (String value : values) {
				sb.append(value + separator);
			}
			int length = sb.length();
			sb.delete(length - separator.length(), length);
		}

		return sb.toString();
	}
}
