package Optional;

import java.util.List;
import java.util.Optional;

import utils.Order;
import utils.Person;
import utils.PersonsDB;
import utils.Product;
/**
 *  using Optional, and never working with null
 * @author a614412
 *
 */
public class OptionalDemo {
	public static void main(String[] args) {
		
		final List<Person> listPerson = PersonsDB.PERSONS;
		
		String firstNane = listPerson.get(15).getFirstname();
		
		System.out.println("firstname : " + firstNane);
		
		/* Creating Optional objects */
		
		// empty Optional:
		Optional<Person> oPers = Optional.empty();
		
		// an Optional with a non-null value 	
		Person p = listPerson.get(30); // If p were null, a NullPointerException would be immediately thrown
		Optional<Person> oP = Optional.ofNullable(p); // If oP were null, the resulting Optional object would be empty
		
		/* Do Something If a Value Is Present */
		if (oP.isPresent()) {
			oP.get().printPerson();
		}
		
		/* Avoid Null and NullPointerException Altogether */
		
		String unsafePersonOrderProductName = listPerson.get(0).getOrder().get(0).getProduct().get(0).getName();
		// This can obviously break with NullPointerException if any term is null.
		System.out.println("unsafePersonOrderProductName : " + unsafePersonOrderProductName); 
		// The old way
		if (listPerson != null && !listPerson.isEmpty()) {
			Order order = listPerson.get(1).getOrder().get(0);
			if (order !=null) {
				Product product = order.getProduct().get(0);
				if (product != null) {
					System.out.println("Old way : unsafePersonOrderProductName: " + product.getName());
				}
			}
		}
		// the JAVA8 way
		Optional<List<Person>> oListPerson = Optional.ofNullable(PersonsDB.PERSONS); 
		Optional<Person> oPerson = Optional.ofNullable(PersonsDB.PERSONS.get(0));
		Optional<String> java8PersonOrderProductName = oPerson
				.map(person -> person.getOrder().get(0))
				.map(order -> order.getProduct().get(0))
				.map(product -> product.getName());
		if (java8PersonOrderProductName.isPresent()) {
			System.out.println("New way : java8 PersonOrderProductName: " + java8PersonOrderProductName);
		}
		

		
		
	}

}
