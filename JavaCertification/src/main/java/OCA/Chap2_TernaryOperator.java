package OCA;

/**
 * booleanExpression ? expression1 : expression2
 * 
 * @author Malick
 */
public class Chap2_TernaryOperator {

    public static void main(String[] args) {

        eg1();
    }

    /**
     * Example Given 1
     */
    public static void eg1() {
        int y = 1;
        int z = 1;
        final int x = y < 10 ? y++ : z++;
        System.out.println("y:" + y + ", z:" + z + ", x:" + x);
        // Outputs y:2, z:1, x:1
        // only one of the right-hand expressions of the ternary operator will be evaluated at runtime
    }

    /**
     * Example Given 2
     */
    public static void eg2() {
        int y = 10;
        int x = (y > 5) ? (2 * y) : (3 * y);

        System.out.println("y:" + y + ", x:" + x); // Outputs y:10, x:20

        System.out.println((x > 10) ? 21 : "Zebra");

        // int animal = (y < 91) ? 9 : "Horse"; // DOES NOT COMPILE
    }

}
