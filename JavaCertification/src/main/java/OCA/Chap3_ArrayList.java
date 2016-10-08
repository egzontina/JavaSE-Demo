package OCA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * The following shows an example of Main ArraysList manipulation
 * 
 * @see Page 129 on book
 */
public class Chap3_ArrayList {

    final static String newLine = System.lineSeparator();

    public static void main(String args[]) {

        // commonMethod();

        autoboxing();

        // conversion();

        // sorting();

        // TODO build use case that show all method at meantime
    }

    /**
     * common methods
     */
    public static void commonMethod() {

        /* creating an ArrayList */
        List<String> birds = new ArrayList<>();

        // add ()
        {
            System.out.println(newLine + "========= add() - get() ");
            birds = new ArrayList<>();
            birds.add("hawk"); // [hawk]
            birds.add(1, "robin"); // [hawk, robin]
            birds.add(0, "blue jay"); // [blue jay, hawk, robin]
            birds.add(1, "cardinal"); // [blue jay, cardinal, hawk, robin]
            System.out.println(birds); // [blue jay, cardinal, hawk, robin]
            System.out.println("birds.get(1) = " + birds.get(1));

        }
        // remve()
        {
            System.out.println(newLine + "========= remove() ");
            birds = new ArrayList<>();
            birds.add("hawk"); // [hawk]
            birds.add("hawk"); // [hawk, hawk]
            System.out.println("remove cardinal = " + birds.remove("cardinal")); // prints false
            System.out.println("remove hawk = " + birds.remove("hawk")); // prints true
            System.out.println("remove index 0 = " + birds.remove(0)); // prints hawk
            System.out.println("list after remove() = " + birds); // []
            System.out.println("remove empty array = " + birds.remove("hawk")); // print false
            System.out.println("remove empty array with index 0 = " + birds.remove(0)); // IndexOutOfBoundsException

            List<Integer> numbers = new ArrayList<>();
            numbers.add(1);
            numbers.add(2);
            numbers.add(3);
            numbers.remove(2); // remove index 3 , Be careful when autoboxing into Integer
            System.out.println(numbers); // [1, 2]
            numbers.remove(new Integer(2)); // to force wrapper class use.
            System.out.println(numbers); // [1]

        }
        // set()
        {
            System.out.println(newLine + "========= set() ");
            birds = new ArrayList<>();
            birds.add("hawk"); // [hawk]
            System.out.println(birds.size()); // 1
            birds.set(0, "robin"); // [robin]
            System.out.println(birds.size()); // 1
            // birds.set(1, "robin"); // IndexOutOfBoundsException
        }
        // isEmpty() and size() and clear()
        {
            System.out.println(newLine + "========= isEmpty() - size() - clear() ");
            birds = new ArrayList<>();
            System.out.println(birds.isEmpty()); // true
            System.out.println(birds.size()); // 0
            birds.add("hawk"); // [hawk]
            birds.add("hawk"); // [hawk, hawk]
            System.out.println(birds.isEmpty()); // false
            System.out.println(birds.size()); // 2
            birds.clear(); // []
            System.out.println(birds.isEmpty()); // true
            System.out.println(birds.size()); // 0
        }
        // contains()
        {
            birds = new ArrayList<>();
            birds.add("hawk"); // [hawk]
            System.out.println(birds.contains("hawk")); // true
            System.out.println(birds.contains("robin")); // false
        }
        // equals()
        {
            System.out.println(newLine + "========= contain() ");
            List<String> one = new ArrayList<>();
            List<String> two = new ArrayList<>();
            System.out.println(one.equals(two)); // true
            one.add("a"); // [a]
            System.out.println(one.equals(two)); // false
            two.add("a"); // [a]
            System.out.println(one.equals(two)); // true
            one.add("b"); // [a,b]
            two.add(0, "b"); // [b,a]
            System.out.println(one.equals(two)); // false
        }
    }

    /**
     * Converting Between array and List
     */
    public static void conversion() {

        System.out.println(newLine + "========= list -> Arrays");

        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray(); // defaults to an array of class Object
        System.out.println(objectArray.length); // 2
        String[] stringArray = list.toArray(new String[0]); // specifies "string" is the type of the array
        System.out.println(stringArray.length); // 2

        System.out.println(newLine + "========= arrays -> list");

        String[] array = { "hawk", "robin" }; // [hawk, robin]
        list = Arrays.asList(array); // returns fixed size list
        System.out.println(list.size()); // 2
        list.set(1, "test"); // [hawk, test]
        array[0] = "new"; // [new, test]
        System.out.println("array = " + Arrays.toString(array)); // [new, test]
        // list.remove(1); // throws UnsupportedOperation Exception, not allowed to change size of list

    }

    /**
     * Autoboxing
     */
    public static void autoboxing() {
        List<Integer> ages = new ArrayList<>();
        ages.add(Integer.parseInt("5"));
        ages.add(Integer.valueOf("5"));
        ages.add(7);
        ages.add(null);
        for (Integer age : ages) {
            System.out.println(age);
        }
        /*
         * output 5 5 7 null
         */
    }

    /**
     * Equality
     */
    public static void equality() {
        List<String> one = new ArrayList<String>();
        one.add("abc");
        List<String> two = new ArrayList<>();
        two.add("abc");
        System.out.println(one == two); // false | the variables do not point to the same object
        System.out.println(one.equals(two)); // true | same element in the same order
    }

    /**
     * Sorting
     */
    public static void sorting() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(5);
        numbers.add(81);
        Collections.sort(numbers);
        System.out.println(numbers); // [5, 81, 99]
    }

}
