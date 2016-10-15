package OCA.ReviewQuestions;

/**
 * Test Class for given snippet in exam question
 */

public class Chap1 {
    public static void main(String[] args) {

        // @formatter:off

    }
}

//@formatter:off

/**
 * Question 2
 */
class WaterBottle {
    private String brand;
    private boolean empty;

    public static void main(String[] args) {
        WaterBottle wb = new WaterBottle();
        System.out.print("Empty = " + wb.empty);
        System.out.print(", Brand = " + wb.brand);

        // ouput : Empty = false, Brand = null
    }
}

/**
 * Question 24
 */
class Salmon {
    int count;
    public void Salmon() {
        count = 4;
    }
    public static void main(String[] args) {
        Salmon s = new Salmon();
        System.out.println(s.count);
    }
    
    // ouput : 0
}

//@formatter:on