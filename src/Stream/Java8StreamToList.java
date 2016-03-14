package Stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** * Java Program to convert Stream to List in Java 8 * * @author Javin Paul */

public class Java8StreamToList {
	public static void main(String args[]) throws IOException {
		Stream<String> streamOfString = Stream.of("Java", "C++", "JavaScript", "Scala", "Python");
		// converting Stream to List using Collectors.toList() method
		streamOfString = Stream.of("code", "logic", "program", "review", "skill");
		List<String> listOfStream = streamOfString.collect(Collectors.toList());

		System.out.println("Java 8 Stream to List, 1st example : " + listOfStream);

		// Java 8 Stream to ArrayList using Collectors.toCollection method
		streamOfString = Stream.of("one", "two", "three", "four", "five");
		listOfStream = streamOfString.collect(Collectors.toCollection(ArrayList::new));

		System.out.println("Java 8 Stream to List, 2nd Way : " + listOfStream);

		// 3rd way to convert Stream to List in Java 8
		// go through all element of Stream one by one and add them into a new List or ArrayList.
		streamOfString = Stream.of("abc", "cde", "efg", "jkd", "res");
		ArrayList<String> list = new ArrayList<>();
		streamOfString.forEach(list::add);
		System.out.println("Java 8 Stream to List, 3rd Way : " + list);

		// 4th way to convert Parallel Stream to List
		// add them into the same order they were present in Stream
		streamOfString = Stream.of("one", "two", "three", "four", "five");
		ArrayList<String> myList = new ArrayList<>();
		streamOfString.parallel().forEachOrdered(myList::add);
		System.out.println("Java 8 Stream to List, 4th Way : " + myList);

		// 5th way of creating List from Stream in Java
		// but unfortunately this creates array of Objects
		// as opposed to array of String
		Stream<String> streamOfNames = Stream.of("James", "Jarry", "Jasmine", "Janeth");
		Object[] arrayOfString = streamOfNames.toArray();
		List<Object> listOfNames = Arrays.asList(arrayOfString);
		System.out.println("5th example of Stream to List in Java 8 : " + listOfNames);

		// can we convert the above method to String[] instead of
		// Object[], yes by using overloaded version of toArray()
		// as shown below :
		Stream<String> streamOfShapes = Stream.of("Rectangle", "Square", "Circle", "Oval");
		String[] arrayOfShapes = streamOfShapes.toArray(String[]::new);
		List<String> listOfShapes = Arrays.asList(arrayOfShapes);
		System.out.println("modified version of last example : " + listOfShapes);
	}
}
