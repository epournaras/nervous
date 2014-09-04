package ch.eth.soms.mosgap.nervous;

import java.util.ArrayList;
import java.util.List;

public class StringUtility {

	/**
	 * Separates all values with the given separator. <br>
	 * Example <br>
	 * <b>Input: </b> values = {"a","b","c","d"} <br>
	 * separator = "_"<br>
	 * <b>Output: </b>
	 * "a_b_c_d"
	 * 
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String separate(List<String> list, String separator) {
		StringBuilder sb = new StringBuilder();
		if (list != null && !list.isEmpty()) {
			for (String value : list) {
				sb.append(value + separator);
			}
			int total_length = sb.length();
			sb.delete(total_length - separator.length(), total_length);
		}

		return sb.toString();
	}
}
