package Demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class ArraysDemo {

    static String newLine = System.getProperty("line.separator");

    public static void main(String[] args) {

        // int array[] = CastArrayStringToArrayInt2("1 2");
        // Arrays.stream(array).forEach(x -> System.out.println(x));

        String[] arrayOfStrings = { "a", "a", "a", "a" };
        printArrayInString(arrayOfStrings);

        String[] names = { "Java", "JavaScript", "Python", "C", "Ruby", "Java" };
        findDuplicateElementsInArray(names);

    }

    /**
     * ARRAYS LOOP
     */
    public static void arrayLoop() {

        String[] elements = { "a", "a", "a", "a" };
        for (String s : elements) {
            // Do your stuff here
            System.out.println(s);
        }

        for (int i = 0; i <= elements.length - 1; i++) {
            // Do your stuff here
        }
    }

    /**
     * Print ARRAYS to String
     */
    public static void printArrayInString(String[] array) {

        // Arrays.asList
        System.out.println("Arrays.asList : " + Arrays.asList(array));

        // print with util.Arrays
        System.out.println("Arrays.toString : " + Arrays.toString(array));

        // java 8 print
        System.out.println("String.join : " + String.join(",", array));
        
        // print 2D array
        int rows = 5;
        int columns = 3;
        int[][] array2D = new int[rows][columns];
        System.out.println("Arrays.deepToString : " + Arrays.deepToString(array));

        

    }

    /**
     * ARRAYS --> STREAM
     */
    public void arrayToStream() {

        String array[] = { "a", "b", "c", "d", "e" };

        // Arrays.stream
        Stream<String> stream1 = Arrays.stream(array);
        stream1.forEach(x -> System.out.println(x));

        // Stream.of
        Stream<String> stream2 = Stream.of(array);
        stream2.forEach(x -> System.out.println(x));

    }

    /**
     * DUPLICATE an ARRAYS
     * <p>
     * System.arraycopy() qui fait appel à du code natif. System.arrayCopy copies into an existing array.
     * <p>
     * Arrays.copyOf does not only copy elements, it also creates a new array.
     * @see http://www.javapractices.com/topic/TopicAction.do?Id=3
     */
    public int[] coppyOfArray(final int myArray[]) {
        final int lengthToCopy = myArray.length;
        final int copyOfMyArray[] = new int[lengthToCopy];
        System.arraycopy(myArray, 0, copyOfMyArray, 0, lengthToCopy);
        return copyOfMyArray;
    }

    public int[] coppyOfArray2(final int myArray[]) {

        int[] copied = Arrays.copyOf(myArray, myArray.length); // 10 the the length of the new array
        System.out.println(Arrays.toString(copied));

        return copied;
    }

    /**
     * Find Duplicate Elements in Arrays
     * <p>
     * There are two straight forward solution of this problem
     * <ul>
     * <li>first, brute force way</li>
     * <li>second by using HashSet data structure</li>
     * <li>A third solution, similar to second one is by using hashtable data structure e.g. HashMap to store count of
     * each element and print element with count 1.</li>
     * </ul>
     */
    public static void findDuplicateElementsInArray(String names[]) {
        System.out.println("Finding duplicate elements in array ... : " + Arrays.toString(names));

        // First solution : finding duplicates using brute force method
        System.out.println(newLine + "Finding duplicate elements in array using brute force method");
        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].equals(names[j])) {
                    // got the duplicate element
                    System.out.println("found a duplicate element in array : " + names[i]);
                }
            }
        }

        // Second solution : use HashSet data structure to find duplicates
        System.out.println(newLine + "Duplicate elements from array using HashSet data structure");
        Set<String> store = new HashSet<>();
        for (String name : names) {
            if (store.add(name) == false) {
                System.out.println("found a duplicate element in array : " + name);
            }
        }

        // Third solution : using Hash table data structure to find duplicates
        System.out.println(newLine + "Duplicate elements from array using hash table");
        Map<String, Integer> nameAndCount = new HashMap<>();
        // build hash table with count
        for (String name : names) {
            Integer count = nameAndCount.get(name);
            if (count == null) {
                nameAndCount.put(name, 1);
            } else {
                nameAndCount.put(name, ++count);
            }
        }
        // Print duplicate elements from array in Java
        Set<Entry<String, Integer>> entrySet = nameAndCount.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate element from array : " + entry.getKey());
            }
        }

    }

    /**
     * CAST Array String to Array int
     * 
     * @param line
     * @return
     */
    public int[] CastArrayStringToArrayInt(final String line) {
        // String line = scanner.nextLine();
        String numberStrs[] = line.split(",");
        int[] numbers = new int[numberStrs.length];
        for (int i = 0; i < numberStrs.length; i++) {
            // Note that this is assuming valid input
            // If you want to check then add a try/catch
            // and another index for the numbers if to continue adding the others
            numbers[i] = Integer.parseInt(numberStrs[i]);
        }
        return numbers;
    }

    /* java 8 version */
    public static int[] CastArrayStringToArrayInt2(final String line) {
        return Stream.of(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        // \\s+ : This groups all white spaces as a delimiter.
    }

}
