package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import utils.Person;
import utils.PersonsDB;

public class List_Sort {

	/**
	 * developers frequently sort in two ways. One is using the sort() method of Collections or Arrays, and the other is
	 * using sorted data structures, such as TreeMap and TreeSet.
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * SORT in Java8=================================================================
	 * 
	 */

	public static void sortList1() {

		// List : sort Tri une liste en place, prend un comparateur
		List<String> strings4 = Arrays.asList("one", "two", "three", "four", "aaa", "bbb");
		List<String> list4 = new ArrayList<>(strings4);
		List<Integer> list5 = new ArrayList<>(Arrays.asList(3, 9, 6, 3, 15, 1));
		List<Integer> list6 = new ArrayList<>(Arrays.asList(1, 2, 3));
		list4.sort(Comparator.naturalOrder());
		list5.sort(Comparator.naturalOrder());
		list6.sort(Comparator.reverseOrder());
		System.out.println("List String - Tri Natural comparator : " + list4);
		System.out.println("List Integer - Tri Natural comparator : " + list5);
		System.out.println("List Integer - Tri Reverse : " + list6);

	}
	public static void sortList2 () {
		// Tresset : contenu naturellement trier 
		Set<String> tree = new TreeSet(Arrays.asList("André","Gislain" ,"Matthieu" ,"Cyrille" ,"Zoé" ,"Thierry" ));
		System.out.println("Treeset : " + tree + "\n");
		
		// méthode Sort
		List<Double> list = new ArrayList<Double>(Arrays.asList(-0.25d,12.52d,56.25d,-45.12d,-100.11d,0.005d));
		System.out.println("Méthode Sort() - List avant tri : " + list);
		Collections.sort(list);
		System.out.println("Méthode Sort() - List avec tri : " + list);
	}

	public static void sortByAge(final List<Person> sousListe) {
		System.out.println(" ----- Tri par age -------- "); // pas mal
		List<Person> listPerson5 = PersonsDB.PERSONS;
		listPerson5.sort(Comparator.comparing(Person::getAge));
		sousListe.forEach((p) -> p.printPerson());
	}

	public static void sortByAge2(final List<Person> listPerson) {
		// use method sortByAge in Peson class
		System.out.println(" ----- Tri par age -------- ");
		Collections.sort(listPerson, Person::sortByAge);
		listPerson.stream().forEach((p) -> {
			p.printPerson();
		});
	}

	public static void sortByAge3(final List<Person> listPerson) {
		System.out.println(" ----- Tri par age -------- "); // mieux
		// lamda expression
		Comparator<Person> sortbyage = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());
		listPerson.stream().sorted(sortbyage).forEach(p -> p.printPerson());

	}

	public static void sortByFirstName(final List<Person> listPerson) {
		System.out.println(" ----- Sort all by first name; And then reversed -------- "); //
		Comparator<Person> comparator = Comparator.comparing(e -> e.getFirstname());
		listPerson.sort(comparator.reversed());
		// or sort by firstname
		listPerson.sort((p1, p2) -> p1.getFirstname().compareTo(p2.getFirstname()));
	}

	public static void sortByFirstNameandLastName(final List<Person> sousListe) {
		System.out.println(" ----- Tri multiple, par firsname et Lastname, et age -------- "); //
		// Sort all employees by first name; And then reversed
		List<Person> listPerson9 = PersonsDB.PERSONS;
		// Sorting on multiple fields; Group by.
		Comparator<Person> groupByComparator = Comparator.comparing(Person::getFirstname)
				.thenComparing(Person::getLastname).thenComparing(Person::getAge);
		listPerson9.sort(groupByComparator);
	}

	public static void sortByFirstNameandLastName2(final List<Person> sousListe) {
		final List<Person> listPerson4 = PersonsDB.PERSONS;
		System.out.println("Multiple sort criteria : by firstname then byLastnAME");
		Comparator<Person> byFirstName = (e1, e2) -> e1.getFirstname().compareTo(e2.getFirstname());
		Comparator<Person> byLastName = (e1, e2) -> e1.getLastname().compareTo(e2.getLastname());
		listPerson4.stream().sorted(byFirstName.thenComparing(byLastName)).forEach(e -> e.printPerson());
	}

	public static void sortByDate(final List<Person> listePerson) {
		// TODO
		System.out.println("Tri : Longuest turnered employee");
		listePerson.stream().sorted((p1, p2) -> p1.getHireDate().compareTo(p2.getHireDate()))
				.forEach(p -> p.printPerson());
	}

	/**
	 * Using sort() Method, l'interface Comparator
	 * <T> =================================================================================== very convenient if a
	 * collection or an array is already set up
	 */

	public void sortWithComparatorInJava7(List<Person> listPerson) {
		if (listPerson != null && !listPerson.isEmpty()) {

			Collections.sort(listPerson, new Comparator<Person>() {
				@Override
				public int compare(final Person p1, final Person p2) {
					int result = p1.getLastname().compareTo(p2.getLastname());
					// dans le cas ou 2 personnes auraient le même prenom...on compare par le nom
					if (result == 0) {
						return p1.getFirstname().compareTo(p2.getFirstname());
					}
					return result;
				}
			});
			// OR
			Collections.sort(listPerson, new Comparator<Person>() {
				@Override
				public int compare(final Person p1, final Person p2) {
					int result = 0;
					if (p1.getLastname() != null && p2.getLastname() != null
							&& p1.getLastname().compareTo(p2.getLastname()) > 0) {
						result = 1;
					} else {
						result = -1;
					}
					return result;
				}
			});

		}
	}

	/**
	 * Using Sorted Data Structure ===================================================================================
	 * If it is a list or set, use TreeSet to sort.
	 */
	public static void sortTreeSetInJava7(List<Person> listPersons) {

		// will give you an unsorted set
		Set<Person> unsortedSet = listPersons.isEmpty() ? new HashSet<>() : new HashSet<Person>(listPersons);

		// will give you an sorted set
		Set<Person> sortedSet = new TreeSet<Person>(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
		sortedSet.addAll(unsortedSet);
		// or dirctly : sortedSet.addAll(listPersons);

		// if Person implements Comparable, if Person implements Comparable
		// Set<Person> sortedSet = new TreeSet<Person>(listPersons);

	}

}
