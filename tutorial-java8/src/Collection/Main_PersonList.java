package Collection;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import utils.Person;

public class Main_PersonList {

	static String newLine = System.getProperty("line.separator");

	public static void main(String[] args) {

		// final List<Person> listPerson = PersonsDB.PERSONS;

	}



	/**
	 * EXTRACT =================================================================
	 * 
	 */

	public static void ExtractFirstNameList(final List<Person> listPerson) {
		System.out.println("------------------ stream not distinct ------------------- ");

		List<String> mesPrenom = listPerson.stream().map(mp -> mp.getFirstname()).collect(Collectors.toList()); // ou
																												// collect(Collectors.toCollection(ArrayList::new))

		for (String item : mesPrenom) {
			System.out.println(item);
		}
	}

	public static void ExtractFirstNameListDistinct(final List<Person> listPerson) {
		System.out.println("------------------ stream distinct ------------------- ");

		List<String> mesPrenomdsitinct = listPerson.stream().map(mp -> mp.getFirstname()).distinct()
				.collect(Collectors.toList());
		for (String item : mesPrenomdsitinct) {
			System.out.println(item);
		}
	}

	/**
	 * FILTER =================================================================
	 * 
	 */

	public static List<Person> filterByStartLetter(final List<Person> listPerson) {
		final List<Person> subList = listPerson.stream().filter((p) -> p.getLastname().startsWith("D"))
				.collect(Collectors.toList());

		return subList;
	}

	public static void filterandCountSum(final List<Person> listPerson) {
		System.out.println("----- accumulate Ages -------- ");
		final int accumulatedAges = listPerson.stream().filter((person) -> person.getLastname().startsWith("D"))
				.map((person) -> person.getAge()).reduce(0, (x, y) -> x + y);
		System.out.println(accumulatedAges);

	}

	public static Integer filterandCountSum2(final List<Person> listPerson) {
		Integer ageTotal = listPerson.stream().collect(Collectors.summingInt(Person::getAge));

		return ageTotal;
	}

	public static Person filterFirstElement(final List<Person> listPerson) {
		System.out.println("First element in Stream " + newLine);
		Optional<Person> person = listPerson.stream().sorted((p1, p2) -> p1.getHireDate().compareTo(p2.getHireDate()))
				.findFirst();
		// p4.get().printPerson();
		if(person.isPresent()) {
			return person.get();
		}
		return null;
	}

}
