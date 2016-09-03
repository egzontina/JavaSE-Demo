package Collection;

import java.util.List;

import utils.Person;
import utils.PersonsDB;

public class List_Moyenne {

	public static void main(String[] args) {
		
		List<Person> personnes = PersonsDB.PERSONS;
		personnes.forEach(item -> {
			System.out.println(item.getFirstname() + item.getLastname() + " : " + item.getAge());
		});

		// calcul de la moyenne des ages au dessus de 50 ans
		Double moyenne = personnes.stream()
			    .filter(p -> p.getAge() > 50)
			    .mapToInt(Person::getAge)
			    .average()
			    .getAsDouble();
		
		System.out.println("Average of age : " + moyenne);
		
	}

}
