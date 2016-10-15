package OCA;

import java.util.ArrayList;

public class Chap4_Static {
    public static void main(String[] args) {
    }
}

/**
 * @see page 183 on study Book
 */
class Static {
    private String name = "Static class";

    public static void first() {
    }

    public static void second() {
    }

    public void third() {
        System.out.println(name);
    }

    public static void main(String args[]) {
        first();
        second();
        // third(); // DOES NOT COMPILE
    }
}

/**
 * @see page 184 on study Book
 */
class Gorilla {
    public static int count;

    public static void addGorilla() {
        count++;
    }

    public void babyGorilla() {
        count++;
    }

    public void announceBabies() {
        addGorilla();
        babyGorilla();
    }

    public static void announceBabiesToEveryone() {
        addGorilla();
        // babyGorilla(); // DOES NOT COMPILE, a static method cannot call an instance method
    }

    public int total;
    // public static average = total / count; // DOES NOT COMPILE a static variable cannot call an instance variable
}

/**
 * Final
 * 
 * @see page 185 on study Book
 */
class Initializers {

    private static final int NUM_BUCKETS = 45;
    private static final ArrayList<String> values = new ArrayList<>();

    public static void main(String[] args) {
        // NUM_BUCKETS = 5; // DOES NOT COMPILE, connot update a final variable

        values.add("changed"); // allowed
        // values = new ArrayList<>(); // DOES NOT COMPILE, not allowed

    }

    /* static initializer, run hen the class is used first */

    private static final int NUM_SECONDS_PER_HOUR;
    static {
        int numSecondsPerMinute = 60;
        int numMinutesPerHour = 60;
        NUM_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
    }

    private int zero;
    private static int one;
    private static final int two;
    private static final int three = 3;
    // private static final int four; // DOES NOT COMPILE, final variable never gets initialized
    static {
        // zero = 5; // can't make a static reference to a non static field
        one = 1;
        two = 2;
        // three = 3; // DOES NOT COMPILE, not alloweb to asign it again
        // two = 4; // DOES NOT COMPILE, seond attemps
    }
}