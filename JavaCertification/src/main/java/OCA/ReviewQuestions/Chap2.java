package OCA.ReviewQuestions;

/**
 * Test Class for given snippet in exam question
 */

public class Chap2 {
    public static void main(String[] args) {
    }
}

//@formatter:off

/**
 * QUESTION 3
 */
class CompareValues {
    public static void main(String[] args) {
        int x = 0;
        while (x++ < 10) {}
        // String message = x > 10 ? "Greater than" : false; // given code, The code will not compile because of line
        String message = x > 10 ? "Greater than" : "less than"; // correction
        System.out.println(message + "," + x);

        // ouput : Greater than, 11
    }
}


/**
 * QUESTION 5
 */
class Chap2_Q5 {
    public static void main(String[] args) {
        java.util.List<Integer> list = new java.util.ArrayList<Integer>();
        list.add(10);
        list.add(14);
        for (int x : list) {
            System.out.print(x + ", ");
            break;
        }
    }

    // output : 10,
}

/**
 * QUESTION 6
 */
class Chap2_Q6 {
    public static void main(String[] args) {
        int x = 4;
        long y = x * 4 - x++;
        if(y<10) System.out.println("Too Low");
        else System.out.println("Just right");
        // else System.out.println("Too High"); // The code will not compile because of this line
        
        System.out.println("y="+ y + ", x="+x);

        // ouput : 
        // Just right 
        // y= 12, x=5
    }
}

/**
 * QUESTION 7 | What is the output of the following code snippet?
 */
class Chap2_Q7 {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(x > 2 ? x < 4 ? 10 : 8 : 7);
        
        // output : 8
    }
}

/**
 * QUESTION 8 | What is the output of the following code snippet?
 */
class Chap2_Q8 {
    public static void main(String[] args) {
        boolean x = true, z = true;
        int y = 20;
        x = (y != 10) ^ (z=false); // x = true ^ false = true  
        System.out.println(x+", "+y+", "+z);
        
        // output : true, 20, false 
    }
}


/**
 * QUESTION 9 | How many times will the following code print "Hello World"?
 */
class Chap2_Q9 {
    public static void main(String[] args) {
        for (int i = 0; i < 10;) {
            i = i++;
            System.out.println("Hello World");
        }

        // The code contains an infinite loop and does not terminate
    }
}

/**
 * QUESTION 10 | What is the output of the following code ?
 */
class Chap2_Q10 {
    public static void main(String[] args) {
        byte a = 40, b = 50;
        // byte sum = (byte) a + b; // The code will not compile because of this line
        byte sum = (byte) (a + b); // correction
        System.out.println(sum);

    }
}

/**
 * QUESTION 11 | What is the output of the following code snippet?
 */
class Chap2_Q11 {
    public static void main(String[] args) {
        int x = 5 * 4 % 3; // the two operation are same level of precedence, so java use left-to-right evaluation : x =
                           // (5*4) % 3 = 20 % 3 = 2
        System.out.println(x);

        // output : 2
    }
}

/**
 * QUESTION 12
 */
class Chap2_Q12 {
    public static void main(String[] args) {
        int x = 0;
        String s = null;
        // if(x == s) System.out.println("Success"); // The code will not compile because of line
        // else System.out.println("Failure");
    }
}

/**
 * QUESTION 13 | What is the output of the following code snippet?
 */
class Chap2_Q13 {
    public static void main(String[] args) {
        int x1 = 50, x2 = 75;
        boolean b = x1 >= x2;
        if (b = true)
            System.out.println("Success");
        else
            System.out.println("Failure");

        // output : Sucess
    }
}

/**
 * QUESTION 14 | What is the output of the following code snippet?
 */
class Chap2_Q14 {
    public static void main(String[] args) {
        int c = 7;
        int result = 4;
        result += ++c;
        System.out.println(result);

        // output : 12
    }
}

/**
 * QUESTION 15 | What is the output of the following code snippet?
 */
class Chap2_Q15 {
    public static void main(String[] args) {
        int x = 1, y = 15;
        // while x < 10 // The given code will not compile because of line 6
        // while (x < 10) // correction 
        y--;
        x++;
        System.out.println(x+", "+y);
    }
}

/**
 * QUESTION 16 | What is the output of the following code snippet?
 */
class Chap2_Q16 {
    public static void main(String[] args) {
        /*
        
        do {
            int y = 1;
            System.out.print(y++ + " ");
        } while (y <= 10); // The code will not compile because of line 6
        
        */
    }
}

//@formatter:on

/**
 * QUESTION 17 | What is the output of the following code snippet?
 */
class Chap2_Q17 {
    public static void main(String[] args) {
        boolean keepGoing = true;
        int result = 15, i = 10;
        do {
        i--;
        if(i==8) keepGoing = false;
        result -= 2;
        } while(keepGoing);
        System.out.println(result);
        
        // output : 11
    }
}

/**
 * QUESTION 18 | What is the output of the following code snippet?
 */
class Chap2_Q18 {
    public static void main(String[] args) {
        int count = 0;
        ROW_LOOP: for(int row = 1; row <=3; row++)
            for(int col = 1; col <=2 ; col++) {
                if(row * col % 2 == 0) continue ROW_LOOP;
                count++;
            }
        System.out.println(count);
        
        // OUTPUT : 2
    }
}

/**
 * QUESTION 19 | What is the result of the following code snippet? 
 */
class Chap2_Q19 {
    public static void main(String[] args) {
        int m = 9, n = 1, x = 0;
        while(m > n) {
            m--;
            n += 2;
            x += m + n;
        }
        System.out.println(x);
        
        // OUTPUT : 36
    }
}

/**
 * QUESTION 20 | What is the result of the following code snippet?
 */
class Chap2_Q20 {
    public static void main(String[] args) {
        final char a = 'A', d = 'D';
        char grade = 'B';
        switch(grade) {
            case a:
            case 'B': System.out.print("great");
            case 'C': System.out.print("good"); break;
            case d:
            case 'F': System.out.print("not good");
        }
        
        // OUTPUT : greatgood
    }
}