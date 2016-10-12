package OCA;

public class Chap5_Interface {
    public static void main(String[] args) {
    }
}

// @formatter:off

/**
 * Defining an Interface
 */

interface WalksOnTwoLegs {
}

// DOES NOT COMPILE | interfaces may not be marked as final
// final interface WalksOnEightLegs {}

// DOES NOT COMPILE |  private, which conflicts with the public or default required access for interfaces.
// private interface WalksOnEightLegs {}

interface HasTrunk {
    
    // DOES not compile | no private, protected or final marker
    // private void dig(int depth); 
    // protected abstract double depth();
    // public final void surface();
}


class TestClass1 {
    public static void main(String[] args) {

        // DOES NOT COMPILE, interface cannot be instantiated directly
        // WalksOnTwoLegs example = new WalksOnTwoLegs();
    }
}

/**
 * CanFly are equivalent to CanFly2, the compiler will convert them both to the second example:
 */

interface CanFly { // or "public interface Canfly"
    void fly(int speed);
    abstract void takeoff();
    public abstract double dive();
}

abstract interface CanFly2 { // or "abstract interface CanFly2"
    public abstract void fly(int speed);
    public abstract void takeoff();
    public abstract double dive();
}


/**
 * Inheriting an Interface
 * @see page 269
 */

interface HasTail {
    public int getTailLength();
}

interface HasWhiskers {
    public int getNumberOfWhiskers();
}

interface Seal extends HasTail, HasWhiskers {
}

abstract class HarborSeal implements HasTail, HasWhiskers {
}

// DOES NOT COMPILE, required to implement all of the methods in the HasTail and HasWhiskers interface
// class LeopardSeal1 implements HasTail, HasWhiskers {}

// COMPILE
class LeopardSeal2 implements HasTail, HasWhiskers {
    @Override
    public int getNumberOfWhiskers()  {return 0; }
    @Override
    public int getTailLength() { return 0; }    
}
// COMPILE
class LeopardSeal3 extends HarborSeal {
    @Override
    public int getNumberOfWhiskers()  {return 0; }
    @Override
    public int getTailLength() { return 0; } 
    
}

/**
 * Classes, Interfaces, and Keywords 
 * @see page 270
 */

interface CanRun {}

class Hyena {}

// DOES NOT COMPILE | a class cannot extend an interface. 
// class Cheetah extends CanRun {} 

// DOES NOT COMPILE | interfae cannot extend a class
// interface HasFur extends Hyena {} 


/**
 * Abstract Methods and Multiple Inheritance
 * 
 * @see page 271
 */
interface Herbivore {
    public void eatPlants();
    public int eatPlants(int quantity);
}

interface Omnivore {
    public void eatPlants();
    public void eatMeat();
}

class BearAnimal implements Herbivore, Omnivore {
    public void eatPlants() { 
        System.out.println("Eating plants"); 
    }
    public int eatPlants(int quantity) {
        System.out.println("Eating plants: "+quantity);
        return quantity;
    }
    public void eatMeat() { 
        System.out.println("Eating meat"); 
    }
}


/**
 * Interface Variables
 */
// twoo inteface are equivalent : the compiler will automatically convert them both to the second example
interface CanSwim {
    int MAXIMUM_DEPTH = 100;
    final static boolean UNDERWATER = true;
    public static final String TYPE = "Submersible";
}

interface CanSwim2 {
    public static final int MAXIMUM_DEPTH = 100;
    public static final boolean UNDERWATER = true;
    public static final String TYPE = "Submersible";
}

interface CanSwim3 {
    // DOES NOT COMPILE, Interface variables are assumed to be public, static, and final
    // private int MAXIMUM_DEPTH = 100;
    // protected abstract boolean UNDERWATER = false;
    // public static String TYPE;
}

/**
 * Default Interface Methods
 * 
 * @see apge 274
 */
interface IsWarmBlooded {
    boolean hasScales();

    public default double getTemperature() { // default inteface method
        return 10.0;
    }

    // public default void eatMeat(); // DOES NOT COMPILE

    // public int getRequiredFoodAmount() { return 13; } // DOES NOT COMPILE
}

/** @see page 276 */
interface HasFins {
    public default int getNumberOfFins() {
        return 4;
    }

    public default double getLongestFinLength() {
        return 20.0;
    }

    public default boolean doFinsHaveScales() {
        return true;
    }
}

interface SharkFamily extends HasFins {
    public default int getNumberOfFins() {
        return 8;
    }

    public double getLongestFinLength();

    // public boolean doFinsHaveScales() { return false; } // DOES NOT COMPILE
}

/** 
 * Default Methods and Multiple Inheritance
 */

interface Walk {
    public default int getSpeed() {
        return 5;
    }
}

interface Run {
    public default int getSpeed() {
        return 10;
    }
}

// DOES NOT COMPILE, duplicate default method
/*
class Cat implements Walk, Run { 
    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed()); 
     }
}
*/
// COMPILE 
class Cat implements Walk, Run {
    public int getSpeed() {
        return 1;
    }
    public static void main(String[] args) {
        System.out.println(new Cat().getSpeed());
    }
}

//@formatter:on
/**
 * Static Interface Methods
 */
interface Hop {
    static int getJumpHeight() {
        return 8;
    }
}

class BunnyHop implements Hop {
    public void printDetails() {
        // System.out.println(getJumpHeight()); // DOES NOT COMPILE
        System.out.println(Hop.getJumpHeight()); // print 8
    }
}