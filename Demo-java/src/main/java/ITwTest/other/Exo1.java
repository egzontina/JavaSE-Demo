package ITwTest.other;

/**
 * Main Class
 */
public class Exo1 {

    public static void main(String[] args) {

        ClassA A = new ClassB();

        System.out.println("\n");
        
        ClassB B = new ClassB();
    }

}

/**
 * B Class
 */
class ClassA {

    public ClassA() {
        System.out.println(" A ");
    }

}

/**
 * A Class
 * 
 * @author Malick
 */
class ClassB extends ClassA {

    public ClassB() {
        System.out.println(" B ");
    }

}
