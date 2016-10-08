package OCA.ReviewQuestions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Test Class for given snippet in exam question
 */

public class Chap3 {

    public static void main(String[] args) {

        Q33();
    }

    /**
     * QUESTION 1
     */
    public static void Q1() {
        int numFish = 4;
        String fishType = "tuna";
        // String anotherFish = numFish + 1; // not compile | cannot convert from int to String
        // System.out.println(anotherFish + " " + fishType);
        System.out.println(numFish + " " + 1);
    }

    /**
     * QUESTION 2
     */
    public static void Q2() {
        String s = "Hello";
        String t = new String(s);
        if ("Hello".equals(s))
            System.out.println("one");
        if (t == s)
            System.out.println("two");
        if (t.equals(s))
            System.out.println("three");
        if ("Hello" == s)
            System.out.println("four");
        if ("Hello" == t)
            System.out.println("five");

        // output : one three four
    }

    /**
     * QUESTION 3
     */
    public static void Q3() {
        
    }
    /**
     * QUESTION 4
     */
    public static void Q4() {
        StringBuilder sb = new StringBuilder();
        sb.append("aaa").insert(1, "bb").insert(4, "ccc");
        System.out.println(sb);

        // output : abbaccca
    }

    /**
     * QUESTION 5
     */
    public static void Q5() {
        String s1 = "java";
        StringBuilder s2 = new StringBuilder("java");
        // if (s1 == s2) // the code does not compile | Incompatible operand
        // System.out.print("1");
        if (s1.equals(s2))
            System.out.print("2");
    }

    /**
     * QUESTION 6
     */
    public static void roar(String roar1, StringBuilder roar2) {
        roar1.concat("!!!");
        roar2.append("!!!");
    }

    public static void Q6() {
        String roar1 = "roar";
        StringBuilder roar2 = new StringBuilder("roar");
        roar(roar1, roar2);
        System.out.println(roar1 + " " + roar2);

        // output : roar roar!!!
    }

    /**
     * QUESTION 7
     */
    public static void Q7() {
        String letters = "abcdef";
        System.out.println(letters.length()); // 6
        System.out.println(letters.charAt(3)); // d
        System.out.println(letters.charAt(6)); // throws An exception
    }

    /**
     * QUESTION 8
     */
    public static void Q8() {
        String numbers = "012345678";
        System.out.println(numbers.substring(1, 3)); // 12
        System.out.println(numbers.substring(7, 7)); // empty output, a blank line
        System.out.println(numbers.substring(7)); // 78
    }

    /**
     * QUESTION 9
     */
    public static void Q9() {
        String s = "purr";
        s.toUpperCase();
        s.trim();
        s.substring(1, 3);
        s += " two"; // s = "purr two"
        System.out.println(s.length()); // 8
    }

    /**
     * QUESTION 10
     */
    public static void Q10() {
        String a = "";
        a += 2; // a = "2"
        a += 'c'; // a = "2c"
        a += false; // a = "2cfalse"
        if (a == "2cfalse")
            System.out.println("==");
        if (a.equals("2cfalse"))
            System.out.println("equals");

        // output : ==
        // a String concatened with a nother string gives a String
    }

    /**
     * QUESTION 11
     */
    public static void Q11() {
        int total = 0;
        StringBuilder letters = new StringBuilder("abcdefg");
        total += letters.substring(1, 2).length(); // total = 0 + 1 = 1
        total += letters.substring(6, 6).length(); // total = 1 + 0 = 1
        total += letters.substring(6, 5).length(); // throws An exception
        System.out.println(total);
    }

    /**
     * QUESTION 12
     */
    public static void Q12() {
        StringBuilder numbers = new StringBuilder("0123456789");
        numbers.delete(2, 8); // numbers = "0189"
        numbers.append("-").insert(2, "+"); // numbers = "01+89-"
        System.out.println(numbers);

        // output : 01+89-
    }

    /**
     * QUESTION 13
     */
    public static void Q13() {

        // given code : Does not compile
        // StringBuilder b = "rumble";

        // correct code, output : rum4
        StringBuilder b = new StringBuilder("rumble");

        b.append(4).deleteCharAt(3).delete(3, b.length() - 1);
        System.out.println(b);
    }

    /**
     * QUESTION 14
     */
    public static void Q14() {

        StringBuilder puzzle = new StringBuilder("Java");

        // INSERT CODE to to print "avaJ"

        puzzle.reverse();
        System.out.println(puzzle); // avaJ

        // or

        puzzle = new StringBuilder("Java");
        puzzle.append("vaJ$").delete(0, 3).deleteCharAt(puzzle.length() - 1);
        System.out.println(puzzle); // avaJ

    }

    /**
     * QUESTION 20
     */
    public static void Q20() {
        List<String> list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        // list.add(7); // Does not compile
        for (String s : list)
            System.out.print(s);
    }

    /**
     * QUESTION 21
     */
    public static void Q21() {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(4); // values = [4]
        values.add(5);// values = [4 5]
        values.set(1, 6); // values = [4 6]
        values.remove(0); // values = [6]
        System.out.println(values);
        for (Integer v : values)
            System.out.print(v);

        // output : 6
    }

    /**
     * QUESTION 22
     */
    public static void Q22() {
        int[] random = { 6, -4, 12, 0, -10 };
        int x = 12;
        int y = Arrays.binarySearch(random, x);
        System.out.println(y);

        // code compile and run fie, output : 2
        // BUT , array must be sorted for binarysearch to return meaningful result
        // correct Answer : the result is undefined
    }

    /**
     * QUESTION 23
     */
    public static void Q23() {
        List<Integer> list = Arrays.asList(10, 4, -1, 5);
        Collections.sort(list);
        Integer array[] = list.toArray(new Integer[4]);
        System.out.println(array[0]);

        // output : -1
    }

    /**
     * QUESTION 24
     */
    public static void Q24() {
        String[] names = { "Tom", "Dick", "Harry" };

        // given code : Compile error
        // List<String> list = names.asList();

        // correct code, output : Sue
        List<String> list = Arrays.asList(names);

        list.set(0, "Sue");
        System.out.println(names[0]);
    }

    /**
     * QUESTION 25
     */
    public static void Q25() {
        List<String> hex = Arrays.asList("30", "8", "3A", "FF");
        Collections.sort(hex); // hex = [30, 3A, 8, FF]
        int x = Collections.binarySearch(hex, "8"); // x = 2
        int y = Collections.binarySearch(hex, "3A"); // y = 1
        int z = Collections.binarySearch(hex, "4F"); // z = -2-1 = -3

        System.out.println(x + " " + y + " " + z); // output : 2 1 -3
    }

    /**
     * QUESTION 26
     */
    public static void Q26() {
        List<Integer> ages = new ArrayList<>();
        ages.add(Integer.parseInt("5")); // use autoboxing
        ages.add(Integer.valueOf("5"));
        ages.add(7); // use autoboxing
        ages.add(null);
        for (Integer age : ages)
            System.out.println(age);

        // code compile, output 5 5 7 null

    }

    /**
     * QUESTION 27
     */
    public static void Q27() {
        List<String> one = new ArrayList<String>();
        one.add("abc");
        List<String> two = new ArrayList<>();
        two.add("abc");
        if (one == two)
            System.out.println("A");
        else if (one.equals(two))
            System.out.println("B");
        else
            System.out.println("C");

        // output : B
    }

    /**
     * QUESTION 28
     */
    public static void Q28() {

    }

    /**
     * QUESTION 29
     */
    public static void Q29() {
        LocalDate date = LocalDate.parse("2018-04-30", DateTimeFormatter.ISO_LOCAL_DATE);
        date.plusDays(2);
        // date.plusHours(3); // Does not compile, Local date does not have time element
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
    }

    /**
     * QUESTION 30
     */
    public static void Q30() {
        LocalDate date = LocalDate.of(2018, Month.APRIL, 40);
        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());

        // A runtime exception is thrown | invalid date value are passed, no 40th day in month
    }

    /**
     * QUESTION 31
     */
    public static void Q31() {
        LocalDate date = LocalDate.of(2018, Month.APRIL, 30);
        date.plusDays(2);
        date.plusYears(3);

        System.out.println(date.getYear() + " " + date.getMonth() + " " + date.getDayOfMonth());
        // output : 2018 APRIL 30
        // dates are immutable, plus method have their retunr values ignored
    }

    /**
     * QUESTION 32
     */
    public static void Q32() {
        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.of(1, 2, 3);
        d = d.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(d.format(f));

        // output 11:12
        // or 11:12 AM
    }

    /**
     * QUESTION 33
     */
    public static void Q33() {
        LocalDateTime d = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p = Period.ofDays(1).ofYears(2);
        d = d.minus(p);
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(f.format(d));

        // output : 5/10/13 11:22 AM
        // or 10/05/13 11:22
        
        // period does not allow chaining , only hte last method called counts, only two years are subtracted
    }
}
