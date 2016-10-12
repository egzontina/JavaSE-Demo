package OCA;

public class Chap5_Polymorphism {
    public static void main(String[] args) {
    }
}

/** @see page 279 */
class Primate1 {
    public boolean hasHair() {
        return true;
    }
}

interface HasTail1 {
    public boolean isTailStriped();
}

class Lemur extends Primate1 implements HasTail1 {
    public boolean isTailStriped() {
        return false;
    }

    public int age = 10;

    public static void main(String[] args) {
        Lemur lemur = new Lemur();
        System.out.println(lemur.age); // 10
        HasTail1 hasTail = lemur;
        System.out.println(hasTail.isTailStriped()); // false
        Primate1 primate = lemur;
        System.out.println(primate.hasHair()); // true

        Object lemurAsObject = lemur;

        // System.out.println(hasTail.age); // DOES NOT COMPILE
        // System.out.println(primate.isTailStriped()); // DOES NOT COMPILE

        /* Casting */

        // Casting an object from a superclass to a subclass requires an explicit cast.
        // Lemur lemur2 = primate; // DOES NOT COMPILE
        Lemur lemur3 = (Lemur) primate;
        System.out.println(lemur3.age); // 10

    }
}

/** @see page 283 */

class Bird {
}

class Fish1 {
    public static void main(String[] args) {
        Fish1 fish = new Fish1();

        // Bird bird = (Bird) fish; // DOES NOT COMPILE
        // the classes Fish and Bird are not related through any class hierarchy
    }
}

class Rodent1 {
}

class Capybara extends Rodent1 {
    public static void main(String[] args) {
        Rodent1 rodent = new Rodent1();

        Capybara capybara1 = (Capybara) rodent;
        // will compile without issue but
        // will Throws ClassCastException at runtime
        // the object being referenced is not an instance of the Capybara class.
        // the object that was created is not related to the Capybara class in any way.

        // check whether an object belongs to a particular class
        if (rodent instanceof Capybara) {
            Capybara capybara2 = (Capybara) rodent;
        }

    }
}

/**
 * Virtual Methods
 * 
 * @see page 284
 */
class Bird1 {
    public String getName() {
        return "Unknown";
    }

    public void displayInformation() {
        System.out.println("The bird name is: " + getName());
    }
}

class Peacock extends Bird1 {
    public String getName() {
        return "Peacock";
    }

    public static void main(String[] args) {
        Bird1 bird = new Peacock();
        bird.displayInformation(); // The bird name is: Peacock
    }
}

/**
 * Polymorphic Parameters
 * 
 * @see page 285
 */

class Reptile1 {
    public String getName() {
        return "Reptile";
    }
}

class Alligator extends Reptile1 {
    public String getName() {
        return "Alligator";
    }
}

class Crocodile extends Reptile1 {
    public String getName() {
        return "Crocodile";
    }
}

class ZooWorker {
    public static void feed(Reptile1 reptile) {
        System.out.println("Feeding: " + reptile.getName());
    }

    public static void main(String[] args) {
        feed(new Alligator()); // Feeding: Aligator
        feed(new Crocodile()); // Feeding: Crocodile 
        feed(new Reptile1()); // Feeding: Reptile
    }
}

//@formatter:off

//@formatter:on