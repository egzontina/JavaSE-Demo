package algorithm;

import java.util.Arrays;

/**
 * fonction Java qui renverse une Chaine de caractère
 */
public class ReverseString {

    /**
     * Main METHOD
     */
    public static void main(String[] args) {
        System.out.println("reverseWithStringBulder(\"Malick DIOP\") : " + reverseWithStringBulder("Malick DIOP"));
        System.out.println("Malick DIOP.toCharArray() =>" + Arrays.toString("Malick DIOP".toCharArray()));
        System.out.println("Malick DIOP.split() =>" + Arrays.toString("Malick DIOP".split(" ")));
    }

    /**
     * Reserve String With StringBuilder.reverse()
     * 
     * @param s
     *            La chaine a renverse.
     * @return la chaine renversee.
     */
    public static String reverseWithStringBulder(final String s) {
        if (s == null) {
            return null;
        }
        return new StringBuilder(s).reverse().toString();
    }

    /**
     * Reserve String Without StringBuilder.reverse()
     * 
     * @param s
     *            La chaine a renverse.
     * @return la chaine renversee.
     */
    public static String reverseWithoutStringBulder(final String s) {

        if (s == null) {
            return null;
        }

        final char chaineArray[] = s.toCharArray();
        final StringBuilder s2 = new StringBuilder();
        for (final char c : chaineArray) {
            s2.insert(0, c);
        }
        return s2.toString();
    }

}
