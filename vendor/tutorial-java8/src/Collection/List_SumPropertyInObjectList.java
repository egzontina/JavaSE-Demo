package Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import utils.Person;
import utils.PersonsDB;

public class List_SumPropertyInObjectList {

	public static void main(String[] args) {
		
		getSumPropertyOfList();
		
	}

	/**
	 * SUM PROPERTY OF LIST OBJECT TOTAL DES AGE DES PERSONNE
	 */
	public static long getSumPropertyOfList() {
		List<Person> personnes = PersonsDB.PERSONS;
		personnes.forEach(item -> {
			System.out.println(item.getFirstname() + item.getLastname() + " : " + item.getAge());
		});

		long ageSum = personnes.stream().map(e -> e.getAge()).reduce(0, Integer::sum);
		// OR :  long ageSum = personnes.stream().map(e -> e.getAge()).reduce(0, (x, y) -> x + y);
		
		System.out.println("sum of age : " + ageSum);
		return ageSum;
		
	}
	
	/**
	 * sim of integer list
	 * @return
	 */
	public static Integer getSumList() {

		// get sum of list of integer
		List<Integer> integers = Arrays.asList(1, 2, 3, 4);
		int sumList = integers.parallelStream().reduce(0, Integer::sum);
		System.out.println("sumList of (1, 2, 3, 4) = " + sumList);

		List<Integer> randomIntegerList = Collections
				.unmodifiableList(new Random().ints(-100, 101).limit(20).boxed().collect(Collectors.toList()));
		

		Integer sumInteger = randomIntegerList.stream().map((i) -> i).reduce(0,
				(accumulator, _item) -> accumulator + _item);

		
		
		return sumInteger;
		
		/**
		List<Integer> randomLongList = Collections
				.unmodifiableList(new Random().ints(-100, 101).limit(20).boxed().collect(Collectors.toList()));
		randomIntegerList.stream().forEach(System.out::println);
		
		long sumLong = randomLongList.stream().map((i) -> (long) i).reduce(0L,
				(accumulator, _item) -> accumulator + _item);
		*/

	}


	/**
	 * SUM of Map
	 * 
	 * @return
	 */
	public static Integer getSumOfMap() {
		// sum for a map
		Map<String, Integer> map = new HashMap<>();
		map.put("v0", 1);
		map.put("v1", 2);
		Integer sumMap = map.values().stream().reduce(0, Integer::sum);
		// integers.values().stream().mapToInt(i -> i).reduce(0, (x,y) -> x+y);
		System.out.println("sumMap of (1, 2) = " + sumMap);

		return sumMap;
	}

}
