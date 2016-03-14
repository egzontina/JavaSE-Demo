package Collection;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import utils.Person;
import utils.PersonsDB;

public class List_Predicate {

	public static void main(String[] args) {

		// Exemple data list from model

		Person p1 = new Person("Vladimir", "Poutine", 19, LocalDate.of(1988, Month.APRIL, 12));
		Person p2 = new Person("Fran�ois", "Hollande", 25, LocalDate.of(1988, Month.APRIL, 12));

		List<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);

		Predicate<Person> plusVieuxQue = (p) -> {
			return p.getAge() >= 20;
		};

		Predicate<Person> plusJeuneQue = (p) -> {
			return p.getAge() < 20;
		};

		Predicate<Person> ComprisEntre = p -> p.getAge() >= 14 && p.getAge() <= 25;

		Predicate<Person> startWith = p -> p.getLastname().startsWith("D");

		Consumer<Person> afficherPerson = (p) -> {
			p.printPerson();
		};

		Consumer<Person> ajouterUnAn = (p) -> {
			p.setAge(p.getAge() + 1);
			// p.printPerson();
		};

		final List<Person> listPerson = PersonsDB.PERSONS;

		System.out.println("Qui a entre 14 et 25 ans ?");
		processPersonsWithPredicate(listPerson, ComprisEntre, afficherPerson);

		System.out.println("Qui a plus de 20 ans ?");
		processPersonsWithPredicate(persons, plusVieuxQue, afficherPerson);

		System.out.println("Qui a strictement moins de 20 ans ?");
		processPersonsWithPredicate(persons, plusJeuneQue, afficherPerson);

		System.out.println("Les plus jeunes que 20 ans grandissent d'un an ...");
		processPersonsWithPredicate(persons, plusJeuneQue, ajouterUnAn);

		System.out.println("Et maintenant, qui a plus de 20 ans ?");
		processPersonsWithPredicate(persons, plusVieuxQue, afficherPerson);

		final List<Person> listPerson2 = getSubList(listPerson, startWith);
		System.out.println("getSubList() :" + listPerson2);

		
		System.out.println(" ----- Tri par age -------- ");
		final List<Person> listPerson3 = getSubList(listPerson, (p) -> p.getLastname().startsWith("D"));
		Collections.sort(listPerson3, Person::sortByAge);
		listPerson3.stream().forEach((p) -> {
			p.printPerson();
		});


	}

	// affiche la liste des personne qui r�ponde � un certain crit�re
	public static void processPersonsWithPredicate(List<Person> persons, Predicate<Person> tester,
			Consumer<Person> blocConsumer) {
		for (Person p : persons) {
			if (tester.test(p)) {
				blocConsumer.accept(p);
			}
		}
	}

	// e.g : Single Abstract Method (SAM)
	public static List<Person> getSubList(List<Person> persons, Predicate<Person> tester) {
		final List<Person> list = new ArrayList<Person>();

		for (Person p : persons) {
			if (tester.test(p)) {
				list.add(p);
			}
		}

		return list;
	}

}
