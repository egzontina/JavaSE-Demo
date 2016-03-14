package utils;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class PersonsDB {
	public final static List<Person> PERSONS;

	static {
		PERSONS = new ArrayList<>();
		PERSONS.add(new Person("Carson", "Busses", 25, LocalDate.of(1988, Month.APRIL, 12)));
		PERSONS.add(new Person("Patty", "Cake", 72, LocalDate.of(2011, Month.DECEMBER, 15)));
		PERSONS.add(new Person("Anne", "Derri ", 14, LocalDate.of(2005, Month.JUNE, 07)));
		PERSONS.add(new Person("Moe", "Dess", 47, LocalDate.of(2005, Month.JUNE, 07)));
		PERSONS.add(new Person("Leda", "Doggslife", 50, LocalDate.of(1988, Month.APRIL, 17)));
		PERSONS.add(new Person("Dan", "Druff", 38, LocalDate.of(2007, Month.APRIL, 12)));
		PERSONS.add(new Person("Al", "Fresco", 36, LocalDate.of(2008, Month.APRIL, 12)));
		PERSONS.add(new Person("Ido", "Hoe", 2 , LocalDate.of(2004, Month.APRIL, 12)));
		PERSONS.add(new Person("Howie", "Kisses", 23, LocalDate.of(2009, Month.APRIL, 12)));
		PERSONS.add(new Person("Len", "Lease", 63, LocalDate.of(20015, Month.APRIL, 12)));
		PERSONS.add(new Person("Len", "DISTINct", 63, LocalDate.of(20015, Month.APRIL, 12)));
	}

	private PersonsDB() {
	}
}