package OCA.ReviewQuestions;

import java.util.function.Predicate;

/**
 * Test Class for given snippet in exam question
 */

public class Chap4 {

    public static void main(String[] args) {
        Q1();
    }

    /**
     * QUESTION 1
     */
    public static void Q1() {

    }

}

// @formatter:off
 


/**
 * Question 11
 */
class Rope {
    public static void swing() {
        System.out.print("swing ");
    }

    public void climb() {
        System.out.println("climb ");
    }

    public static void play() {
        swing();
        // climb(); // Cannot make a static reference to the non-static
    }

    public static void main(String[] args) {
        Rope rope = new Rope();
        rope.play();
        Rope rope2 = null;
        rope2.play();

        // OutPut : swing swing
    }
}

/**
 * Question 12
 */
class Rope1 {
    public static int length = 0;
}

class RopeSwing1 {
    private static Rope1 rope1 = new Rope1();
    private static Rope1 rope2 = new Rope1();
    {
        System.out.println(rope1.length);
    }

    public static void main(String[] args) {
        rope1.length = 2;
        rope2.length = 8;
        System.out.println(rope1.length);

        // ouput : 8
    }
}

/**
 * Question 11
 * <p>
 * How many compiler errors are in the following code? = 4
 */
class RopeSwing {
    private static final String leftRope;
    private static final String rightRope;
    // private static final String bench; // DOES NOT COMPILE
    private static final String name = "name";
    static {
        leftRope = "left";
        rightRope = "right";
    }
    static {
        // name = "name"; // DOES NOT COMPILE
        // rightRope = "right"; // DOES NOT COMPILE
    }

    public static void main(String[] args) {
        // bench = "bench"; // DOES NOT COMPILE
    }
}

/**
 * Question 15
 * <p>
 * What is the result of the following statements ?
 */
class Test {
    public void print(byte x) {
        System.out.print("byte");
    }

    public void print(int x) {
        System.out.print("int");
    }

    public void print(float x) {
        System.out.print("float");
    }

    public void print(Object x) {
        System.out.print("Object");
    }

    public static void main(String[] args) {
        Test t = new Test();
        short s = 123;
        t.print(s);
        t.print(true);
        t.print(6.789);

        // ouput : intObjectObject
    }
}

/**
 * Question 16
 * <p>
 * What is the result of the following statements ?
 */
class Squares {
    public static long square(int x) {
        long y = x * (long) x;
        x = -1;
        return y;
    }

    public static void main(String[] args) {
        int value = 9;
        long result = square(value); // result = 81
        System.out.println(value); // value is still 9, Java is passed value

        // ouput : 9
    }
}

/**
 * Question 17
 * <p>
 * What is the output of the following statements ?
 */
class StringBuilders {
    public static StringBuilder work(StringBuilder a, StringBuilder b) {
        a = new StringBuilder("a");
        b.append("b");
        return a;
    }

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("s1");
        StringBuilder s2 = new StringBuilder("s2");
        StringBuilder s3 = work(s1, s2);
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);

        /* ouput */
        // s1 = s1
        // s2 = s2b
        // s3 = a

    }
}

/**
 * Question 20
 * <p>
 * Which code can be inserted to have the code print 2 ?
 */
class BirdSeed {
    private int numberBags;
    boolean call;

    public BirdSeed() {
        // LINE 1
        this(2); // INSERTED CODE
        call = false;
        // LINE 2
    }

    public BirdSeed(int numberBags) {
        this.numberBags = numberBags;
    }

    public static void main(String[] args) {
        BirdSeed seed = new BirdSeed();
        System.out.println(seed.numberBags);
    }
}

/**
 * Question 21
 * <p>
 * Which code can be inserted to have the code print 50 ?
 */
class Cheetah {
    int numSpots;

    public Cheetah(int numSpots) {
        this.numSpots = numSpots; // INSERT CODE HERE
    }

    public static void main(String[] args) {
        System.out.println(new Cheetah(50).numSpots);
    }
}

/**
 * Question 22
 * <p>
 * What is the result of the following? ?
 */
class Order {
    static String result = "";
    { result += "c"; }
    static 
    { result += "u"; }
    { result += "r"; }
}

class OrderDriver {
    public static void main(String[] args) {
        System.out.print(Order.result + " ");
        System.out.print(Order.result + " ");
        new Order();
        new Order();
        System.out.print(Order.result + " ");
        
        // Ouput : u u ucrcr 
    }
}


/**
 * Question 23
 * <p>
 * What is the result of the following? ?
 */
class Order1 {
    String value = "t";
    { value += "a"; }
    { value += "c"; }

    public Order1() {
        value += "b";
    }

    public Order1(String s) {
        value += s;
    }

    public static void main(String[] args) {
        Order1 order = new Order1("f");
        order = new Order1();
        System.out.println(order.value);
        
        // output : tacb
    }
}

//@formatter:on

/**
 * Question 24
 * <p>
 * Which of the following will compile when inserted in the following code? (Choose all that apply)
 */
class Order3 {
    final String value1 = "1";
    static String value2 = "2";
    String value3 = "3";
    {
        /* CODE SNIPPET 1 */
        // value1 = "d";
        value2 = "e";
        value3 = "f";
    }
    static {
        /* CODE SNIPPET */
        // value1 = "g";
        value2 = "h";
        // value3 = "i";
    }
}

/**
 * Question 24
 * <p>
 */
class Create {
    Create() {
        System.out.print("1 ");
    }

    Create(int num) {
        System.out.print("2 ");
    }

    Create(Integer num) {
        System.out.print("3 ");
    }

    Create(Object num) {
        System.out.print("4 ");
    }

    Create(int... nums) {
        System.out.print("5 ");
    }

    public static void main(String[] args) {
        new Create(100);
        new Create(1000L);

        // ouput : 2 4
        // The code prints 3 4 if you remove the constructor Create(int num).
    }
}

/**
 * Question 25
 * <p>
 */
class Panda {
    int age;

    public static void main(String[] args) {
        Panda p1 = new Panda();
        p1.age = 1;
        check(p1, p -> p.age < 5);
    }

    private static void check(Panda panda, Predicate<Panda> pred) {
        String result = pred.test(panda) ? "match" : "not match";
        System.out.print(result);
    }
    // ouput : match
}

/**
 * Question 26
 */
interface Climb {
    boolean isTooHigh(int height, int limit);
}

class Climber {
    public static void main(String[] args) {
        // check((h, l) -> h.append(l).isEmpty(), 5); // DOES COMPILE
         check((h, l) -> {h=1; l=6; return (h>l);} , 5); // example of  
    }

    private static void check(Climb climb, int height) {
        if (climb.isTooHigh(height, 10))
            System.out.println("too high");
        else
            System.out.println("ok");
    }
}