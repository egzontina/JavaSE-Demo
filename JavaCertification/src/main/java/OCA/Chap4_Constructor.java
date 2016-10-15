package OCA;

public class Chap4_Constructor {

    public static void main(String[] args) {
    }
}

//@formatter:off

/**
 * @see pge 197
 * @author Malick
 */
class Bunny {
    
    private String color;
    private int height;
    private int length;

    // public bunny() { } // DOES NOT COMPILE

    public void Bunny() { // method but not constructor
    }

    public Bunny() {
        System.out.println("Default constructor");
    }

    public Bunny(String color) {
        this.color = color;
    }

    public Bunny(int length, int theHeight) {
        // length = this.length; // backwards – no good!
        height = theHeight; // fine because a different name
        this.color = "white"; // fine, but redundant
    }

    public static void main(String[] args) {
        Bunny b = new Bunny(1, 2);
        System.out.println(b.length + " " + b.height + " " + b.color); //
    }
}

/**
 * @see page 198
 * @author Malick
 */
class Rabbit {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit(); // Calls default constructor
    }
}

class Rabbit1 {
}

class Rabbit2 {
    public Rabbit2() {}
}

class Rabbit3 {
    public Rabbit3(boolean b) {}
}

class Rabbit4 {
    private Rabbit4() {}
}

class RabbitsMultiply {
    public static void main(String[] args) {
        Rabbit1 r1 = new Rabbit1();
        Rabbit2 r2 = new Rabbit2();
        Rabbit3 r3 = new Rabbit3(true);
        // Rabbit4 r4 = new Rabbit4(); // DOES NOT COMPILE
    }
}

//@formatter:on

/**
 * Overloading Constructors @ page 199
 */
class Hamster {
    private String color;
    private int weight;

    public Hamster(int weight, String color) { // first constructor
        this.weight = weight;
        this.color = color;
    }

    public Hamster(int weight) { // second constructor
        this(weight, "brown"); // call first constructor
    }
}

/**
 * Constructor Chaining
 * 
 * @see page 201
 */
class Mouse {
    private int numTeeth;
    private int numWhiskers;
    private int weight;

    public Mouse(){} // default contructor can be call using this();
    
    public Mouse(int weight) {
        this(weight, 16); // calls constructor with 2 parameters
    }

    public Mouse(int weight, int numTeeth) {
        this(weight, numTeeth, 6); // calls constructor with 3 parameters
    }

    public Mouse(int weight, int numTeeth, int numWhiskers) {

        this.weight = weight;
        this.numTeeth = numTeeth;
        this.numWhiskers = numWhiskers;
    }

    public void print() {
        System.out.println(weight + " " + numTeeth + " " + numWhiskers);
    }

    public static void main(String[] args) {
        Mouse mouse = new Mouse(15);
        mouse.print(); // print 15 16 6
    }

}

/**
 * Final Field
 * 
 * @see page 202
 */
class MouseHouse {
    private final int volume;
    private final String name = "The Mouse House";

    public MouseHouse(int length, int width, int height) {
        volume = length * width * height;
    }
}

/**
 * Order of initialization
 * 
 * @see page 202, 203, 204
 */
class InitializationOrderSimple {
    private String name = "Torchie";
    {
        System.out.println(name);
    }
    private static int COUNT = 0;
    static {
        System.out.println(COUNT);
    }
    static {
        COUNT += 10;
        System.out.println(COUNT);
    }

    public InitializationOrderSimple() {
        System.out.println("constructor");
    }
}

class CallInitializationOrderSimple {
    public static void main(String[] args) {
        InitializationOrderSimple init = new InitializationOrderSimple();
        // The output is:
        // 0
        // 10
        // Torchie
        // constructor
    }
}

class InitializationOrder {
    private String name = "Torchie";
    {
        System.out.println(name);
    }
    private static int COUNT = 0;
    static {
        System.out.println(COUNT);
    }
    {
        COUNT++;
        System.out.println(COUNT);
    }

    public InitializationOrder() {
        System.out.println("constructor");
    }

    public static void main(String[] args) {
        System.out.println("read to construct");
        new InitializationOrder();
    }

    // The output looks like this:
    // 0
    // read to construct
    // Torchie
    // 1
    // constructor

}

class YetMoreInitializationOrder {
    static {
        add(2);
    }

    static void add(int num) {
        System.out.print(num + " ");
    }

    YetMoreInitializationOrder() { // construtor
        add(5);
    }

    static {
        add(4);
    }
    {
        add(6);
    }
    static {
        new YetMoreInitializationOrder();
    }
    {
        add(8);
    }

    public static void main(String[] args) {
        System.out.println("main ");
    }

    // The correct answer is 2 4 6 8 5 main
}