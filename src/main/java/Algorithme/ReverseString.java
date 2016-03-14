package Algorithme;


/**
 *  fonction Java qui renverse une Chaine 
 *
 */
public class ReverseString {
	
	// version string builder
	public static String reverse(final String s) {
	    if (s == null) {
	        return null;
	    }
	    return new StringBuilder(s).reverse().toString();
	}
	
	// version artisanal
	public static String reverse2(final String chaine) {
		final char[] chaineArray = chaine.toCharArray();
		final StringBuilder s2 = new StringBuilder();
		for (final char c : chaineArray) {
		    s2.insert(0, c);
		}
		return s2.toString();
	}
	
	
	
}
