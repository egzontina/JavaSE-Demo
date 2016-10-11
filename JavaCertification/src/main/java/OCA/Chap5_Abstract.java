package OCA;

public class Chap5_Abstract {
    public static void main(String[] args) {
    }
}

/**
 * Defining an Abstract Class
 * 
 * @see page 259
 */

abstract class Cow {
}

// public final abstract class Tortoise {} // DOES NOT COMPILE

class Chicken {
    // public abstract void peck(); // DOES NOT COMPILE, not abstract class
}

abstract class Turtle {

    // DOES NOT COMPILE, abstrct method do not have body
    // public abstract void swim() {}
    // public abstract int getAge() {return 10;}

    // DOES NOT COMPILE, abstrat method cannot be final
    // public abstract final void chew();

    // DOES NOT COMPILE, method may not be marked as both abstract and private
    // private abstract void sing();
}

abstract class Eel {
    public static void main(String[] args) {
        // final Eel eel = new Eel(); // DOES NOT COMPILE
    }
}

abstract class Animal1 {
    protected int age;

    public void eat() {
        System.out.println("Animal is eating");
    }

    public abstract String getName();
}

class Swan1 extends Animal1 {
    public String getName() {
        return "Swan";
    }
}

// DOES NOT COMPILE, it must implement all inherited abstract methods
// public class Walrus extends Animal1 {
// }

abstract class Eagle extends Animal1 {
}

abstract class BigCat extends Animal1 {
    public String getName() {
        return "BigCat";
    }

    public abstract void roar();
}

class Lion extends BigCat {
    // Lion inherits the two abstract method

    public String getName() {
        return "Lion";
    }

    public void roar() {
        System.out.println("The Lion lets out a loud ROAR!");
    }
}

class Lion2 extends BigCat {
    // Lion2 inherits only one abstract method

    public void roar() {
        System.out.println("The Lion lets out a loud ROAR!");
    }
}