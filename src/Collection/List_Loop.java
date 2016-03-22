package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import utils.Person;

public class List_Loop {

	public static void main(String[] args) {
		System.out.println("=============== Parcours avec IERATEUR ===================================");
		System.out.println("=============== Parcours avec BOUCLE ===================================");

		loopwithForeach();
	}

	public static void loopAndReplace() {
		// List : replaceAll : Remplace un objet par sa transformée
		List<String> strings3 = Arrays.asList("one", "two", "three", "four");
		List<String> list3 = new ArrayList<>(strings3);
		list3.replaceAll(String::toUpperCase);
		System.out.println("List replaceAll : " + list3);
	}

	/**
	 * Parcour avec un iterator USE : quand vous devez supprimer des éléments de la collection
	 */

	public static void loopWithIteratorFor(List<String> list) {
		// clever way - It would be the same as doing - do it.next() before instruction
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String str = iterator.next();
			if (str.equals("4")) {
				iterator.remove();
			}
		}
	}



	/**
	 * Parcour avec Suppression
	 */
	public static void loopAndRemove(List<String> list) {
		// Collection : removeIf : Retire un objet : prend un prédicat - removes an element on a predicate
		// works « in place », no Collections.unmodifiable...
		List<String> strings2 = Arrays.asList("one", "two", "three");
		Collection<String> list2 = new ArrayList<>(strings2);
		// returns true if the list has been modified, if string are more than 4 character
		boolean b = list2.removeIf(s -> s.length() > 4);
		System.out.println("List RemoveIf : " + list2);
	}
	
	public static void loopwithIteratorWhile(List<String> list) {
		// Nous recup�rons notre it�rrateur
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			// nous recup�rons l'�l�ment courant
			String str = it.next();
			// si nous sommes sur l'�l�ment 4, nous le retirons de la collection
			if (str.equals("4"))
				it.remove();
		}
	}

	/**
	 * Parcour avec un foreach
	 */
	public static void loopwithForeach() {
		List<String> items = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));
		System.out.println("list = " + items);
		
		// foreach : lambda
		System.out.println("===================== Lambda ===============");
		items.forEach(item -> { // Output : C
			if ("C".equals(item)) {
				System.out.println(item);
			}
		});
		
		// foreach : method reference
		System.out.println("===================== method reference ===============");
		items.forEach(System.out::println); // Output : A,B,C,D,E

		// foreach : Steam and filter
		System.out.println("===================== stream and filter================");
		items.stream().filter(s -> s.contains("B")).forEach(System.out::println); // Output : B
		
		// can't change liste value with with foreach
		//The method forEach only iterates through the elements of the list without changing them
		
		
	}

	/**
	 * Parcour avec boucle traditionnelle USE :quand vous devez parcourir plusieurs collections en parallèle
	 */
	public static void loopwithFor(List<String> list) {
		// way 1
		for (String item : list) {
			System.out.println(item);
		}

		// Way two
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	/*
	 * L'itération sur les éléments d'une collection est fastidieuse avec la déclaration d'un objet de type Iterator. La
	 * nouvelle forme de l'instruction for, spécifiée dans la JSR 201, permet de simplifier l'écriture du code pour
	 * réaliser une telle itération et laisse le soin au compilateur de générer le code nécessaire.
	 * 
	 * l'intérêt d'utiliser un iterator au lieu d'une boucle for ou while ? la différence c'est que l'itérator est
	 * thread-safe (ConcurrentModificationException) alors qu'en utilisant un for, on ne se prémunit pas d'une
	 * modification en cours de lecture. for est plus long potentiellement. ca hausse le niveau d'abstraction Niveau
	 * perf, pour une ArrayList, ça revient au même d'utiliser un Iterator ou de faire des get(index) dans une boucle
	 * for would be not being able to remove items with for-each
	 * 
	 */

	/**
	 * LOOP Person =================================================================
	 * 
	 */
	public static void loop(final List<Person> listPerson) {
		/** for loop to foreach statement */

		System.out.println("----- For LOOP --------\n"); // good
		for (Person person : listPerson) {
			person.printPerson();
		}

		System.out.println("----- Forearch Statement --------\n"); // better
		listPerson.stream().forEach((p) -> {
			p.printPerson();
		});

		System.out.println("----- Parallelle Forearch  --------\n");
		Person newP = new Person("Ido", 25);
		listPerson.parallelStream().filter(p -> p.getFirstname().equals(newP.getFirstname())).forEach((string) -> {
			System.out.println("Content: " + string);
		});
	}

}
