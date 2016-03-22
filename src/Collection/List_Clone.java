package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.Person;
import utils.PersonsDB;

/**
 * CLONER UNE COLLECTION
 * 
 * @author Malick
 *
 */
public class List_Clone {

	public static void main(String[] args) {		
		
		List<Person> persons = PersonsDB.PERSONS;			
		
		// Java 8 provides a new way to call the clone method on the element elegantly and compactly: Stream, lambdas and collectors
		// clone list
		List<Person> personnesClone = persons.stream().collect(Collectors.toList());
		// modify cloning list
		personnesClone.removeIf(item -> item.getAge() > 50);		
		
		System.out.println("===================== start Person List ===============");
		display(persons);
		System.out.println("===================== Cloning Person List ===============");
		display(personnesClone);
	}

	// helper method 
	public static void display(List<Person> personnes) {
		personnes.forEach(item -> {
			System.out.println(item.getFirstname() + item.getLastname() + " : " + item.getAge());
		});
	}
	
	// TODO
	public void cloneList() {

		// Collections.Utils
		// StringUtils (version apache ou spring)

		// addAll : copie une collection sur ue autre
	}
	
	public static void copyListPrimitive() {
		
//		List<String> b = new ArrayList<String>(a.size());
//		Collections.copy(b, a);
		// creates a shallow copy of a within b
		//// note: instantiating with a.size() gives `b` enough capacity to hold everything

		// simple shallow copy
		// the simplest way to copy a List is to pass it to the constructor of the new list:
		List<String> a = new ArrayList<String>(); 
		a.add("a"); 
		a.add("b"); 
		a.add("c"); 
		List<String> b = new ArrayList<>(a);
		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
	}
	
	/**
	 * Copy peu profond
	 */
	public static void shallowCopy() {
		
	}
	
	/**
	 * Copy en profondeur
	 */
	public static void deepCopy() {
		
	}

}
