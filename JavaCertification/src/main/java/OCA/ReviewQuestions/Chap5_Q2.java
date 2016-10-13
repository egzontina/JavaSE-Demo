package OCA.ReviewQuestions;

public class Chap5_Q2 {
    public static void main(String[] args) {
    }
}

// @formatter:off
 
/**
 * Q2
 */
class Mammal {
    public Mammal(int age) {
        System.out.print("Mammal");
    }
}

class Platypus extends Mammal {

    // Will not compile | implicite constructor Mamma() is not defined
    /*
     * public Platypus() { System.out.print("Platypus"); }
     */

    // correction | must define explicite constructor
    public Platypus() {
        super(10); // a first line should be an explicite call to parentClass construtor
        System.out.print("Platypus");

    }

    public static void main(String[] args) {
        new Mammal(5); // Mammal
        new Platypus(); // MammalPlatypus
    }
}

/**
 * Q3
 */
interface CanHop {
}

class Frog implements CanHop {
    public static void main(String[] args) {
        Frog frog = new TurtleFrog();
        TurtleFrog frog2 = new TurtleFrog();
        CanHop frog3 = new TurtleFrog();
        Object frog4 = new TurtleFrog();
    }
}

class BrazilianHornedFrog extends Frog {
}

class TurtleFrog extends Frog {
}

/**
 * Q12
 */
interface Nocturnal {
    default boolean isBlind() { return true; }
}

class Owl implements Nocturnal {
    public boolean isBlind() { return false; }

    public static void main(String[] args) {
        Nocturnal nocturnal = (Nocturnal) new Owl();
        System.out.println(nocturnal.isBlind());
        // output : false
    }
}

/**
 * Q13
 */

class Arthropod {
    public void printName(double input) { System.out.print("Arthropod"); }
}

class Spider extends Arthropod {
    public void printName(int input) { System.out.print("Spider"); }
    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.printName(4);
        spider.printName(9.0);
        
        // output : SpiderArthropod
    }
}

/**
 * Q19
 */
class Snake {}
class Cobra extends Snake {}
class GardenSnake {}
class SnakeHandler {
private Snake snake;
public void setSnake(Snake snake) { this.snake = snake; }
public static void main(String[] args) {
new SnakeHandler().setSnake(new Cobra() );
new SnakeHandler().setSnake(new Snake() );
new SnakeHandler().setSnake(null);
}
}


//@formatter:on

abstract class Bird {
    private void fly() {
        System.out.println("Bird is flying");
    }

    public static void main(String[] args) {
        Bird bird = new Pelican();
        bird.fly();
        // ouput : Bird is Flying
    }
}

class Pelican extends Bird {
    protected void fly() {
        System.out.println("Pelican is flying");
    }
}