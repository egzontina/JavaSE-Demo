package OCA;

public class Chap1 {
    
    
    
    public static void main(String ...vargs) {

        // primitive Type

        /* undescore in number */
        int million1 = 1000000;
        int million2 = 1_000_000;
        // double notAtStart = _1000.00; // DOES NOT COMPILE
        // double notAtEnd = 1000.00_;
        // double notByDecimal = 1000_.00;
        double annoyingButLegal = 1_00_0.0_0;

        // page 23 | conveting backto binary
        System.out.println(56); // 56
        System.out.println(0b11); // 3
        System.out.println(017); // 15
        System.out.println(0x1F); // 31

        /* Object Reference and primitive type */

        // long max = 3123456789; // DOES NOT COMPILE
        long max = 3123456789L;

        // int value = null; // DOES NOT COMPILE
        String s = null;
        String reference = "hello";
        int len = reference.length(); // len = 5
        // int bad = len.length(); // DOES NOT COMPILE

        /* page 25 | Declaring and Initializing Variables */
        String zooName = "The Best Zoo";
        int numberAnimals = 100;
        String s1, s2;
        String s3 = "yes", s4 = "no";
        int i1, i2, i3 = 0;
        // int num, String value; // DOES NOT COMPILE
        boolean b1, b2;
        String s5 = "1", s6;
        // double d1, double d2; // DOES NOT COMPILE
        int i4; int i5;
        // int i6; i7; // DOES NOT COMPILE
        
        // legal identifiers
        String okidentifier;
        String $OK2Identifier;
        String _alsoOK1d3ntifi3r;
        String __SStillOkbutKnotsonice$;
        // not legal identifiers
        // String 3DPointClass ; // identifiers cannot begin with a number
        // String hollywood@vine ; // @ is not a letter, digit, $ or _
        // String *$coffee ; // * is not a letter, digit, $ or _
        // String public ; // public is a reserved word
    }

}

/**
 * Page 19 : Chapter 1 ■ Java Building Blocks
 * 
 * @author Malick
 */
class Chick {

    private String name = "Fluffy";

    {
        System.out.println("setting field");
    }

    public Chick() {
        name = "Tiny";
        System.out.println("setting constructor");
    }

    public static void main(String[] args) {
        Chick chick = new Chick();
        String a;
        System.out.println(chick.name);

        /* Running this example prints this: */
        // setting field
        // setting constructor
        // Tiny
    }
}

/**
 * Page 20 : Chapter 1 ■ Java Building Blocks
 * 
 * @author Malick
 */
class Egg {

    public Egg() {
        number = 5;
    }

    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number);
    }

    private int number = 3;
    {
        number = 4;
    }

    /* What do you think this code prints out ? */
    // If you answered 5, you got it right. Fields and blocks are run first in order, setting
    // number to 3 and then 4. Then the constructor runs, setting number to 5
}