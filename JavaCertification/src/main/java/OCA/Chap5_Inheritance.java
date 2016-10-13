package OCA;

/**
 * Main Class With Main Method
 * 
 * @author Malick
 */
public class Chap5_Inheritance {
    public static void main(String[] args) {
    }
}

// @formatter:off
 

/**
 * Calling Constructors page 243
 */
class Primate {
    public Primate() {
        System.out.println("Primate");
    }
}

class Ape extends Primate {
    public Ape() {
        System.out.println("Ape");
    }
}

class Chimpanzee extends Ape {
    public static void main(String[] args) {
        new Chimpanzee();
    }
    /*
     * Output : Primate Ape
     */
}

// cannot extend final class
final class test {}
//class testExtends extends test {}

//@formatter:on

/**
 * Calling Inherited Class Members
 * 
 * @see page 244
 * @author Malick
 */
class Fish {
    protected int size;
    private int age;

    public Fish(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

class Shark extends Fish {
    private int numberOfFins = 8;

    public Shark(int age) {
        super(age);
        this.size = 4;
    }

    public void displaySharkDetails() {
        System.out.print("Shark with age: " + getAge());
        System.out.print(" and " + size + " meters long");
        System.out.println(" with " + numberOfFins + " fins");
    }

    public void displaySharkDetails2() { // with this and super
        System.out.print("Shark with age: " + super.getAge());
        System.out.print(" and " + super.size + " meters long");
        System.out.println(" with " + this.numberOfFins + " fins");
    }
}

class Shark_Main {
    public static void main(String[] args) {
        Shark shark = new Shark(7);
        shark.displaySharkDetails(); // Shark with age: 7 and 4 meters long with 8 fins
        shark.displaySharkDetails2(); // Shark with age: 7 and 4 meters long with 8 fins
    }
}

/**
 * Inheriting Methods
 * 
 * @see page 245
 * @see page 256 | final method
 */
class Canine {
    public double getAverageWeight() {
        return 50;
    }

    public final boolean hasFeathers() {
        return true;
    }
}

class Wolf extends Canine {
    public double getAverageWeight() {
        return super.getAverageWeight() + 20;
        // return getAverageWeight()+20; // error, recursive call, INFINITE LOOP
    }

    // DOES NOT COMPILE, cannot override the final parent method
    // public final boolean hasFeathers() {return false;}

    public static void main(String[] args) {
        System.out.println(new Canine().getAverageWeight()); // 50.0
        System.out.println(new Wolf().getAverageWeight()); // 70.0
        System.out.println(new Wolf().hasFeathers()); // true
    }
}

/**
 * Inheriting Methods | overriding Method
 * 
 * @see page 250
 */
class InsufficientDataException extends Exception {
}

class Reptile {
    protected boolean hasLegs() throws InsufficientDataException {
        throw new InsufficientDataException();
    }

    protected double getWeight() throws Exception {
        return 2;
    }

    protected double getHeight() throws InsufficientDataException {
        return 2;
    }

    protected int getLength() {
        return 10;
    }
}

class Snake extends Reptile {
    protected boolean hasLegs() {
        return false;
    }

    protected double getWeight() throws InsufficientDataException {
        return 2;
    }

    // protected double getHeight() throws Exception { return 2;} // DOES NOT COMPILE

    // protected int getLength() throws InsufficientDataException {return 10;} // DOES NOT COMPILE
}

/**
 * Redeclaring private Methods
 * 
 * @see page 251
 */
class Camel {
    private String getNumberOfHumps() {
        return "Undefined";
    }
}

class BactrianCamel extends Camel {
    private int getNumberOfHumps() {
        return 2;
    }
}

/**
 * Hiding Static Method
 * 
 * @see page 252
 */
class Bear {
    public static void eat() {
        System.out.println("Bear is eating");
    }

    public static void sneeze() {
        System.out.println("Bear is sneezing");
    }

    public void hibernate() {
        System.out.println("Bear is hibernating");
    }
}

class Panda extends Bear {
    public static void eat() { // Hide eat method in parent class
        System.out.println("Panda bear is chewing");
    }

    // DOES NOT COMPILE
    // public void sneeze() { System.out.println("Panda bear sneezes quietly"); }
    // public static void hibernate() { System.out.println("Panda bear is going to sleep");}

    public static void main(String[] args) {
        Panda.eat(); // Panda bear is chewing
    }
}

/**
 * Overriding vs. Hiding Methods
 * 
 * @see page 254
 */

class Marsupial {
    public static boolean isBiped() {
        return false;
    }

    public void getMarsupialDescription() {
        System.out.println("Marsupial walks on two legs: " + isBiped());
    }

    public boolean isBiped2() {
        return false;
    }

    public void getMarsupialDescription2() {
        System.out.println("Marsupial walks on two legs: " + isBiped2()); // call to the child class method isBiped2()
    }
}

class Kangaroo extends Marsupial {
    public static boolean isBiped() { // hide parent class method
        return true;
    }

    public void getKangarooDescription() {
        System.out.println("Kangaroo hops on two legs: " + isBiped());
    }

    public boolean isBiped2() { // overide parent class method
        return true;
    }

    public void getKangarooDescription2() {
        System.out.println("Kangaroo hops on two legs: " + isBiped2());
    }

    public static void main(String[] args) {
        Kangaroo joey = new Kangaroo();
        joey.getMarsupialDescription(); // Marsupial walks on two legs: false
        joey.getKangarooDescription();// Kangaroo hops on two legs: true
        System.out.println();
        joey.getMarsupialDescription2(); // Marsupial walks on two legs: true
        joey.getKangarooDescription2();// Kangaroo hops on two legs: true
    }
}

/**
 * Inheriting Variables | Hiding Variables
 * @see page 257
 */
class Rodent {
    protected int tailLength = 4;

    public void getRodentDetails() {
        System.out.println("[ parentTail= " + tailLength + " ]");
    }
}

class Mouse2 extends Rodent {
    protected int tailLength = 8;

    public void getMouseDetails() {
        System.out.println("[ tail= " + tailLength + ", parentTail=" + super.tailLength + "]");
    }

    public static void main(String[] args) {
        Mouse2 mouse = new Mouse2();
        mouse.getRodentDetails(); // [ parentTail= 4 ]
        mouse.getMouseDetails(); // [ tail= 8, parentTail=4]
    }
}

/**
 * Inheriting Variables | Hiding Variables
 * @see page 258
 */
class Animal2 {
    public int length = 2;
}

class Jellyfish extends Animal2 {
    public int length = 5;

    public static void main(String[] args) {
        Jellyfish jellyfish = new Jellyfish();
        Animal2 animal = new Jellyfish();
        System.out.println(jellyfish.length); // 5
        System.out.println(animal.length); // 2
    }
}