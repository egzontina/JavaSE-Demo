package Demo;

public class StringUtils {

	/**
	 * Check if string is null or empty
	 * 
	 * @param str
	 * @return
	 */
	public boolean isEmpty(String str) {
		return str != null && !str.isEmpty() ? false : true; 
	}
}
