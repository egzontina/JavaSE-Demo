package OCA;

import java.util.Arrays;

public class Chap3_Arrays {

    public static void main(String args[]) {

        // looping();
        // sorting();
        // multidimensionalArrays();
        equality();
    }

    /**
     * Create and instanciate
     */
    public static void instaciate() {
        // declares and initializes the array
        String[] mammals = { "monkey", "chimp", "donkey" };
        System.out.println(mammals.length); // 3
        System.out.println(mammals[0]); // monkey
        System.out.println(mammals[1]); // chimp
        System.out.println(mammals[2]); // donkey

        // length
        String[] birds = new String[6];
        System.out.println(birds.length); // 6
    }

    /**
     * Loop in array
     */
    public static void looping() {
        // loop when reading from or writing to an array.
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i + 5;

        System.out.println(Arrays.toString(numbers));
    }

    /**
     * SORT an Array
     */
    public static void sorting() {
        int[] numbers = { 6, 9, 1 };
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
        // output : 1 6 9

        System.out.println(System.lineSeparator());

        String[] strings = { "10", "9", "100" };
        Arrays.sort(strings);
        for (String string : strings)
            System.out.print(string + " ");
        // ouput : 10 100 9
        // is that String sorts in alphabetic order

    }

    /**
     * Search in array
     */
    public static void searching() {
        int[] numbers = { 2, 4, 6, 8 }; // sorted array.return index of searched keys
        System.out.println(Arrays.binarySearch(numbers, 2)); // 0
        System.out.println(Arrays.binarySearch(numbers, 4)); // 1
        System.out.println(Arrays.binarySearch(numbers, 1)); // -1
        System.out.println(Arrays.binarySearch(numbers, 3)); // -2
        System.out.println(Arrays.binarySearch(numbers, 9)); // -5
    }

    /**
     * Multidimensional Arrays
     */
    public static void multidimensionalArrays() {

        int[][] vars1; // 2D array // BETTER WAY
        int vars2[][]; // 2D array
        int[] vars3[]; // 2D array
        int[] vars4[], space[][]; // a 2D AND a 3D array

        // specify the size
        int[][] twoD = new int[3][2];
        String[][] rectangle = new String[3][2];
        // three arrays of two elements
        // this statement is an array rectangle with three elements, each of which refers to an array of two elements
        rectangle[0][1] = "set";

        /* asymmetric arrays */

        int[][] differentSize = { { 1, 4 }, { 3 }, { 9, 8, 7 } };

        int[][] args = new int[2][];
        args[0] = new int[5];
        args[1] = new int[3];

        /* loop in 2DArrays */

        // for loop
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i].length; j++)
                System.out.print(rectangle[i][j] + " "); // print element
            System.out.println(); // time for a new row
        }
        // enhanced for loop | less complex
        System.out.println(System.lineSeparator());
        System.out.println("enhanced for loop");
        for (int[] inner : args) {
            for (int num : inner)
                System.out.print(num + " ");
            System.out.println();
        }

    }

    /**
     * EQUALITY of two array
     */
    public static void equality() {
        // equality
        String[] bugs = { "cricket", "beetle", "ladybug" };
        String[] bugs2 = { "cricket", "beetle", "ladybug" };
        String[] alias = bugs;
        System.out.println(bugs.equals(bugs2)); // false
        System.out.println(bugs.equals(alias)); // true
        System.out.println(bugs == alias); // true
        System.out.println(Arrays.toString(bugs)); // [cricket, beetle, ladybug]
        System.out.println(Arrays.toString(bugs)); // [cricket, beetle, ladybug]

        String[] strings = { "stringValue" };
        Object[] objects = strings;
        String[] againStrings = (String[]) objects;
        // againStrings[0] = new StringBuilder(); // DOES NOT COMPILE
        objects[0] = new StringBuilder(); // careful!, throw ArrayStoreException. We have a String[] referred to from
                                          // an Object[] variable.
    }
}
