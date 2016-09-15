package algorithm;

/**
 * FIZZBUZZ
 * <p>
 * A program that prints the numbers from 1 to 100.
 * <ul>
 * <li>But for multiples of 3 print "Fizz" instead of the number</li>
 * <li>and for the multiples of 5 print"Buzz".</li>
 * <li>For numbers which are multiples of both three and five print "FizzBuzz"</li>
 * </ul>
 */
public class FizzBuzz {

    static String newLine = System.getProperty("line.separator");

    public static void main(String[] args) {
        fizzBuzz0();
        fizzBuzz1();
        // fizzBuzz2();
        // fizzBuzz3();
    }

    /**
     * no good way
     */
    public static void fizzBuzz0() {
        System.out.println(newLine + "fizzBuzz0() :");
        for (int i = 1; i <= 100; i++) {
            String test = "";
            test += (i % 3) == 0 ? "fizz" : "";
            test += (i % 5) == 0 ? "buzz" : "";
            System.out.println(!test.isEmpty() ? test : i);
        }
    }

    /**
     * StringBuilder seems a faster approach than += in this case
     */
    public static void fizzBuzz1() {
        // StringBuilder builder = new StringBuilder(1000); //do not care about the capacity, It automatically grows to
        // accomodate whatever is necessary. You can play with it to improve performance, but it's still asymptotically
        // linear.
        StringBuilder builder = new StringBuilder("fizzBuzz1() with StringBuilder : ");

        for (int i = 1; i <= 100; i++) {
            final int length = builder.length();

            if (i % 3 == 0)
                builder.append("Fizz");
            if (i % 5 == 0)
                builder.append("Buzz");
            if (length == builder.length())
                builder.append(i);

            builder.append(',');
        }
        System.out.println(newLine + builder);
    }

    /**
     * The % 15 version is simpler and easier to read. This version neatly
     */
    public static void fizzBuzz2() {
        String buzz = "buzz";
        String fizz = "fizz";

        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                System.out.println(buzz + fizz + " " + i);
            } else if (i % 3 == 0) {
                System.out.println(buzz + " " + i);
            } else if (i % 5 == 0) {
                System.out.println(fizz + " " + i);
            }
        }
    }

    /**
     * succint way
     */
    public static void fizzBuzz3() {
        for (int i = 0; i < 100; i++) {
            System.out.println(newLine + "fizzBuzz1() :"
                    + ((i % 3 == 0 || i % 5 == 0) ? ((i % 3) == 0 ? "fizz" : "") + ((i % 5) == 0 ? "buzz" : "") : i));
        }
    }

}
