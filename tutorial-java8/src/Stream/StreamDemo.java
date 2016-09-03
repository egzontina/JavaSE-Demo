package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args){		
//		concatStreamArrays();
//		concatStreamList();
//		concatStreamList2();
//		concatStreamList3();
		
		CountDemo();
		DistinctDemo();
		SortedDemo();
		
	}
	
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
		
		System.out.println("======== stream concat list ============ ");
//		System.out.println(Arrays.toString(arrayFinal));
		System.out.println(listFinal);
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
		System.out.println("with streamof " + listOfString);

	}
	public static void concatStreamList3() {
	
	List<String> list1 = Arrays.asList("A1","A2","A3");
    List<String> list2 = Arrays.asList("B1","B2","B3");
    Stream<String> resStream = Stream.concat(list1.stream(), list2.stream());
//    resStream.forEach(s->System.out.println(s));
    List<String> list = resStream.collect(Collectors.toList());
	System.out.println("with concatStreamList3() " + list);
	}
	
	/**
	 * COUNT
	 * ======================================================================
	 */
	public static void CountDemo() {
		List<String> list = Arrays.asList("AA","AB","CC");
        Predicate<String> predicate = s-> s.startsWith("A");
        long l= list.stream().filter(predicate).count();
        System.out.println("CountDemo() - List : " + list);
        System.out.println("CountDemo() - Number of Matching Element:"+l);
	}
	/**
	 * SORT 
	 * ======================================================================
	 */
	public static void SortedDemo() {
		List<String> list = Arrays.asList("DC","CD","AD","DE");
        // list.stream().sorted().forEach(s->System.out.println(s));
        List<String> sortedListASC = list.stream().sorted().collect(Collectors.toList());
        List<String> sortedListDESC = sortedListASC.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("SortedDemo() - List : " + list);
        System.out.println("SortedDemo() - Sorted List ASC : " + sortedListASC);
        System.out.println("SortedDemo() - Sorted List DESC : " + sortedListDESC);
	}
	
	/**
	 * DISTINCT 
	 * ======================================================================
	 */
	public static void DistinctDemo() {
        List<String> list = Arrays.asList("AA","AA","BB");
        long l = list.stream().distinct().count();
        System.out.println("DistinctDemo() - List : " + list);
        System.out.println("DistinctDemo() - Number of distinct element :"+l);
    }

}
