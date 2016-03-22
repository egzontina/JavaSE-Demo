package Collection;

import java.util.List;

import utils.Person;
import utils.PersonsDB;

public class List_UpadateInLoop {

	public static void main(String[] args) {
		
		List<Person> personnes = PersonsDB.PERSONS;
		System.out.println("===================== Start Person List ===============");
		display(personnes);
				
		personnes.stream().filter(item -> (item.getAge() == 63)).forEach(p -> p.setAge(0));
		System.out.println("===================== update Person List ===============");
		display(personnes);
	}
	
	public static void display(List<Person> personnes) {
		personnes.forEach(item -> {
			System.out.println(item.getFirstname() + item.getLastname() + " : " + item.getAge());
		});
	}
	
	// can't change liste value with with ONLY foreach
	//The method forEach only iterates through the elements of the list without changing them

}
