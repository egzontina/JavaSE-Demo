package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class java8StreamConcatList {
	public static void main(String[] args){		
//		concatStreamArrays();
		concatStreamList();
		concatStreamList2();
		concatStreamList3();
		
	}
	
	/**
	 * CONCAT ARRAY 
	 * ======================================================================
	 */
	public static void concatStreamArrays() {
		String[] arr1 = { "a", "b", "c", "d" };
		String[] arr2 = { "e", "f", "g" };
		Stream<String> stream1 = Stream.of(arr1);
		Stream<String> stream2 = Stream.of(arr2);
		 
		Stream<String> stream3 = Stream.concat(stream1, stream2);
		String[] arrFinal = stream3.toArray(String[]::new);

		System.out.println("======== stream concat arrays ============ ");
		System.out.println("with concat " + Arrays.toString(arrFinal));
		
		//use Stream.of(T... values)

		String[] arr3 = { "h", "i", "j" };
		Stream<String> myStream1 = Stream.of(arr1);
		Stream<String> myStream2 = Stream.of(arr2);
		Stream<String> myStream3 = Stream.of(arr3);
		 
		Stream<String> streamFinal = Stream.of(myStream1, myStream2, myStream3).flatMap(x -> x);
		 
		String[] arr = streamFinal.toArray(String[]::new);
		System.out.println("with streamof " + Arrays.toString(arr));

	}
	
	/**
	 * CONCAT LIST 
	 * ======================================================================
	 */
	public static void concatStreamList() {
		
		String[] arr1 = { "a", "b", "c", "d" };
		String[] arr2 = { "e", "f", "g" };
		List<String> list1 = Arrays.asList(arr1);
		List<String> list2 = Arrays.asList(arr2);
		
		Stream stream1 = Stream.of(list1);
		Stream stream2 = Stream.of(list2);
		Stream stream3 = Stream.of("h", "i", "j");

		Stream streamOfString = Stream.concat(Stream.concat(stream1, stream2), stream3);
//		List listOfString  = streamOfString.collect(Collectors.toCollection(ArrayList::new));
//		List listOfString2 = streamOfString.collect(Collectors.toList());
//		List<String> listFinal2 = (List<String>) streamOfString.collect(Collectors.toCollection(ArrayList::new));
		
		ArrayList listFinal = new ArrayList<>();
		streamOfString.forEach(listFinal::add);	
		System.out.println("concat 3 List - with foreach :" + listFinal);
	}
	
	/**
	 * merge two stream
	 * code more readable,
	 */
	public static void concatStreamList2() {
		
		String[] arr1 = { "a", "b", "c", "d" };
		String[] arr2 = { "e", "f", "g" };
		String[] arr3 = { "h", "i", "j" };
		List<String> list1 = Arrays.asList(arr1);
		List<String> list2 = Arrays.asList(arr2);
		List<String> list3 = Arrays.asList(arr3);
		
		Stream<List<String>> stream1 = Stream.of(list1);
		Stream<List<String>> stream2 = Stream.of(list2);
		Stream<List<String>> stream3 = Stream.of(list2);

		Stream<Object> streamFinal = Stream.of(stream1, stream2, stream3).flatMap(x -> x);
		List listOfString = streamFinal.collect(Collectors.toCollection(ArrayList::new));
		System.out.println("concat 3 List - with streamof " + listOfString);

	}
	
	
	public static void concatStreamList3() {
	
	List<String> list1 = Arrays.asList("A1","A2","A3");
    List<String> list2 = Arrays.asList("B1","B2","B3");
    List<String> list3 = Arrays.asList("C1","C2","C3");
    // Stream<String> resStream = Stream.concat(list1.stream(), list2.stream());
    Stream<String> resStream = Stream.concat(Stream.concat(list1.stream(), list2.stream()),list3.stream());
//    resStream.forEach(s->System.out.println(s));
    List<String> list = resStream.collect(Collectors.toList());
	System.out.println("concat 3 List - with concat " + list);
	}
	
	
	

}
