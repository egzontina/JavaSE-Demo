package OCA;

public class Chap3_String {

    /**
     * Main Method
     * 
     * @param args
     */
    public static void main(String args[]) {

        builderString();
    }

    /**
     * CONATENATION
     * <p>
     * <ul>
     * rules
     * <li>1. If both operands are numeric, + means numeric addition</li>
     * <li>2. If either operand is a String, + means
     * <li>concatenation.
     * <li>3. The expression is evaluated left to right.</li>
     * </ul>
     */

    public static void concatenation() {

        System.out.println(1 + 2); // 3
        System.out.println("a" + "b"); // ab
        System.out.println("a" + "b" + 3); // ab3
        System.out.println(1 + 2 + "c"); // 3c

        int three = 3;
        String four = "4";
        System.out.println(1 + 2 + three + four); // 64

        String s = "1";
        s += "2"; // s currently holds "12"
        s += 3; // s currently holds "123"
        System.out.println(s); // 123

    }

    /**
     * IMMUTABILITY
     */
    public static void immutability() {
        String s1 = "1";
        String s2 = s1.concat("2");
        s2.concat("3");
        System.out.println(s2); // 12
    }

    /**
     * THE STRING POOL
     */
    public static void stringPool() {

        // the former says to use the string pool normally.
        String name = "Fluffy";

        // The second says “No, JVM. I really don’t want you to use the string pool. Please create a new object for me
        // even though it is less efficient.”
        String name2 = new String("Fluffy");
    }

    /**
     * COMMON METHODS
     */
    public static void commonMethods() {

        /* length() */
        String string = "animals";
        System.out.println(string.length()); // 7

        /* charAt() */
        String string2 = "animals";
        System.out.println(string2.charAt(0)); // a
        System.out.println(string2.charAt(6)); // s
        System.out.println(string2.charAt(7)); // throws exception

        /* indexOf() */
        String string3 = "animals";
        System.out.println(string3.indexOf('a')); // 0
        System.out.println(string3.indexOf("al")); // 4
        System.out.println(string3.indexOf('a', 4)); // 4
        System.out.println(string3.indexOf("al", 5)); // can’t find a match, return -1

        /* SubString() */
        String string4 = "animals";
        System.out.println(string4.substring(3)); // mals
        System.out.println(string4.substring(string.indexOf('m'))); // mals
        System.out.println(string4.substring(3, 4)); // m
        System.out.println(string4.substring(3, 7)); // mals
        System.out.println(string4.substring(3, 3)); // empty string
        System.out.println(string4.substring(3, 2)); // throws exception
        System.out.println(string4.substring(3, 8)); // throws exception

        /* toLowerCase() and toUpperCase() */
        String string5 = "animals";
        System.out.println(string5.toUpperCase()); // ANIMALS
        System.out.println(string5); // return animals // strings are immutable, so the original string stays the same,
        System.out.println("Abc123".toLowerCase()); // abc123

        /* equals() and equalsIgnoreCase() */
        System.out.println("abc".equals("ABC")); // false
        System.out.println("ABC".equals("ABC")); // true
        System.out.println("abc".equalsIgnoreCase("ABC")); // true

        /* startsWith() and endsWith() */
        System.out.println("abc".startsWith("a")); // true
        System.out.println("abc".startsWith("A")); // false
        System.out.println("abc".endsWith("c")); // true
        System.out.println("abc".endsWith("a")); // false

        /* contains() */
        System.out.println("abc".contains("b")); // true
        System.out.println("abc".contains("B")); // false

        /* replace() */
        System.out.println("abcabc".replace('a', 'A')); // AbcAbc
        System.out.println("abcabc".replace("a", "A")); // AbcAbc

        /* trim() */
        System.out.println("abc".trim()); // abc
        System.out.println("\t a b c\n".trim()); // a b c
    }

    /**
     * METHODS CHAINING
     */
    public static void methodChaining() {

        String result = "AniMaL ".trim().toLowerCase().replace('a', 'A');
        System.out.println(result); // creates four String objects and outputs Animal.

        String a = "abc";
        String b = a.toUpperCase();
        b = b.replace("B", "2").replace('C', '3');
        System.out.println("a=" + a); // a=abc
        System.out.println("b=" + b); // b=A23

    }

    /**
     * EQUALITY
     * <p>
     */
    public static void equality() {

        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        StringBuilder three = one.append("a");
        System.out.println(one == two); // false
        System.out.println(one == three); // true

        String x = "Hello World";
        String y = "Hello World";
        System.out.println(x == y); // true
        // Strings are immutable and literals are pooled

        String u = "Hello World";
        String v = " Hello World".trim();
        System.out.println(u == v); // false
        // we don’t have two of the same String litera

        // The lesson is to never use == to compare String objects.
        // use euqals() to check the values inside the String rather than the String itself.
        String a = "Hello World";
        String b = " Hello World".trim();
        System.out.println(a.equals(b)); // true

    }

    /**
     * StringBuilder
     * <p>
     * StringBuffer does the same thing but more slowly because it is thread safe.
     */
    public static void builderString() {
        StringBuilder alpha = new StringBuilder();
        for (char current = 'a'; current <= 'z'; current++)
            alpha.append(current);
        System.out.println(alpha); // abcdefghijklmnopqrstuvwxyz

        /* append() */
        StringBuilder sb = new StringBuilder().append(1).append('c');
        sb.append("-").append(true);
        System.out.println(sb); // 1c-true

        /* insert() */
        StringBuilder sb0 = new StringBuilder("animals");
        sb0.insert(7, "-"); // sb = animals-
        sb0.insert(0, "-"); // sb = -animals-
        sb0.insert(4, "-"); // sb = -ani-mals
        System.out.println(sb0);

        StringBuilder sb1 = new StringBuilder("start");
        sb.append("+middle"); // sb = "start+middle"
        StringBuilder same = sb1.append("+end");
        System.out.println("sb=" + sb1); // sb = start+middle+end
        System.out.println("same=" + same); // same = start+middle+end

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a=" + a); // a = abcde
        System.out.println("b=" + b); // b = abcdefg

        /* charAt(), indexOf(), length(), and substring() */
        StringBuilder sb2 = new StringBuilder("animals");
        String sub = sb2.substring(sb2.indexOf("a"), sb2.indexOf("al"));
        int len = sb2.length();
        char ch = sb2.charAt(6);
        System.out.println(sub + " " + len + " " + ch); // anim 7 s

        /* delete() and deleteCharAt() */
        StringBuilder sb3 = new StringBuilder("abcdef");
        sb3.delete(1, 3); // sb = adef
        sb3.deleteCharAt(5); // throws an exception StringIndexOutOfBoundsException

        /* reverse( */
        StringBuilder sb4 = new StringBuilder("ABC");
        sb4.reverse();
        System.out.println(sb4); // CBA

        /* toString() */
        StringBuilder sb5 = new StringBuilder("animal");
        String st = sb5.toString();
        System.out.println(sb4); // CBA

    }

}
