package OCA.chap1;

/**
 * Page 20 : Chapter 1 ■ Java Building Blocks
 * 
 * @author Malick
 *
 */
public class Egg {

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
}

// What do you think this code prints out?
// If you answered 5, you got it right. Fields and blocks are run first in order, setting
// number to 3 and then 4. Then the constructor runs, setting number to 5
       