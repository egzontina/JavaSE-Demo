package Demo;

import java.util.StringJoiner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringDemo {

    public static String newLine = System.getProperty("line.separator");

    public static void main(String[] args) {

        String str = "babababababababa";
        String str2 = "baba baba baba baba";
        substrCount(str, "baba");
        substrCount(str2, "baba");
        substrCountWithSplit(str, "baba");
        substrCountWithSplit(str2, "baba");
    }

    /**
     * Nombre d'occurence d'un chaine dans un string
     * 
     * @param str
     *            la chaine string à analyser
     * @param needle
     *            le chaine à compter
     * @return nombre d'occurence
     */
    public static int substrCount(String str, String needle) {
        int count = 0;
        int index = -needle.length();
        while ((index = str.indexOf(needle, index + needle.length())) != -1) {
            count++;
        }

        System.out.println(newLine + "substrCount() of " + str + ":" + count);
        return count;
    }

    /**
     * le split de java fait appel au moteur d'expressions régulières et est par conséquent beaucoup plus lent.
     * Une fonction maison n'utilisant pas les expressions régulières est 3 à 5 fois plus rapide que le split standard. 
     * @param stringLine
     * @param str
     * @return
     */
    public static int substrCountWithSplit(String stringLine, String str) {
        stringLine = stringLine + "i";
        String tb[] = stringLine.split(str);       
        System.out.println(newLine + "substrCountWithSplit() of " + str + ":" + (tb.length - 1));
        return (tb.length - 1);
    }

}
