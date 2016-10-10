package OCA;

import java.io.FileReader;
import java.io.IOException;

public class Chap6_Exception {

    /* P. 306 */
    // Try Catch Finally

    void explore() {
        try {
            fall(); // calling a method that thown exception
            System.out.println("never get here");
        } catch (Exception e) {
            System.out.println("Exception Msg : " + e.getMessage()); 
            getUp();
        } finally {
            seeMoreAnimals();
            // seeAnimals();
        }
        goHome();
    }

    private void goHome() {
    }

    private void seeMoreAnimals() {
    }

    private void seeAnimals() {
    }

    private void getUp() {
        System.out.println("Get Up");
    }

    void fall() throws Exception {
        throw new RuntimeException("Ow! I fell.");
    }

    /** Page 309 */

    void question() {
        String s = "";
        try {
            s += "t";
            // go straight to the finally block
        } catch (Exception e) {
            s += "c";
        } finally {
            s += "f";
        }
        s += "a";
        System.out.print(s); // print tfa
    }

    /** Page 3010 | Catching Various Types of Exceptions */

    void visitPorcupine() {
        try {
            seeAnimals();
        } catch (AnimalsOutForAWalk e) {// first catch block
            System.out.print("try back later");
        } catch (ExhibitClosed e) {// second catch block
            System.out.print("not today");
        }
    }

    public void visitMonkeys() {
        try {
            seeAnimals();
        } catch (ExhibitClosedForLunch e) {// subclass exception
            System.out.print("try back later");
        } catch (ExhibitClosed e) {// superclass exception
            System.out.print("not today");
        }
        // the order of the catch blocks does matter.
        // The reverse does not work.
    }

    public void visitSnakes() {
        try {
            seeAnimals();
        } catch (RuntimeException e) {
            System.out.print("runtime exception");
        }
        // DOES NOT COMPILE | ExhibitClosed is a RuntimeException
        // catch (ExhibitClosed e) { System.out.print("not today"); }
        catch (Exception e) {
            System.out.print("exception");
        }
    }

}

/** All are unchecked exceptions because they directly or indirectly extend RuntimeException. */

class AnimalsOutForAWalk extends RuntimeException {
}

class ExhibitClosed extends RuntimeException {
}

class ExhibitClosedForLunch extends ExhibitClosed {
}

/**
 * Throwing a Second Exception
 * 
 * @see page 312
 */
class TestClasse {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = read();
        } catch (IOException e) {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException inner) {
            }
        }
    }

    private static FileReader read() throws IOException {
        // CODE GOES HERE
        return null;
    }

    /* hardst example , page 313 */
    public String exceptions() {
        String result = "";
        String v = null;
        try {
            try {
                result += "before";
                v.length(); // thows NPE
                result += "after";
            } catch (NullPointerException e) {
                result += "catch";
                throw new RuntimeException();
            } finally {
                result += "finally";
                throw new Exception();
            }
        } catch (Exception e) {
            result += "done";
        }
        return result; // The correct answer is " before catch finally done "
    }
}

/**
 * Subclasse 
 * @see page 319
 */

//@formatter:off

class CanNotHopException extends Exception {
}

class Hopper {
    public void hop1() {}
    public void hop2() throws CanNotHopException { }
    public void hop3() throws Exception { }
}

class Bunny1 extends Hopper {
    // public void hop1() throws CanNotHopException { } // DOES NOT COMPILE
    public void hop1() throws IllegalStateException { }
    public void hop2() { }
    public void hop3() throws CanNotHopException { }
}

/**
 * Printing exception
 * @see page 321
 */

class ExceptionTestClasse2 {
    public static void main(String[] args) {
        try {
            hop();
        } catch (Exception e) {
            System.out.println(e);              // java.lang.RuntimeException: cannot hop
            System.out.println(e.getMessage()); // cannot hop
            e.printStackTrace();                // java.lang.RuntimeException: cannot hop at trycatch.Handling.hop(Handling.java...
        }
     }
     private static void hop() {
         throw new RuntimeException("cannot hop");
     }

}
