package Collection;


import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import utils.Person;
import utils.PersonsDB;


public class UnitTest {

	@Test
	public void TestSortByAge() {
		final List<Person> list = PersonsDB.PERSONS;
	    Collections.sort(list, Person::sortByAge);
	 	
//	    Assert.assertEquals(new Person("Anne", "Derri ", 14), list.get(0));
	    Assert.assertTrue(list.get(4).equals(new Person("Dan", "Druff", 38,  LocalDate.of(1988, Month.APRIL, 12))));
	    Assert.assertTrue(list.get(5).equals(new Person("Moe", "Dess", 47,  LocalDate.of(1988, Month.APRIL, 25))));
	    Assert.assertTrue(list.get(6).equals(new Person("Leda", "Doggslife", 50,  LocalDate.of(1988, Month.APRIL, 12))));
	}

}
