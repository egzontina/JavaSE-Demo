package utils;
import java.time.LocalDate;
import java.util.List;

public class Person {

	private String firstname;
	private String lastname;
	private int age;
	private LocalDate hireDate;
	private  List<Order> order;
	
	/*
	 * Contructors
	 */

	public Person(String firstname, String lastname, int age, LocalDate hiredate) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	public Person(String firstname, int age) {
		this.firstname = firstname;
		this.age = age;
	}

	/*
	 * Others Methodes
	 */


	public void printPerson() {
		System.out.println(firstname + ", " + lastname + ", " + age);
	}

	
	public static int sortByAge(Person p1, Person p2) {
		if (p1.getAge() > p2.getAge()) {
			return 1;
		} else if (p1.getAge() < p2.getAge()) {
			return -1;
		} else {
			return 0;
		}
	}
	

	/*
	 * Getters et Setters
	 */

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}


	
	

}
