package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import utils.Person;
import utils.PersonsDB;

public class List_ModifyInLoop {

	public static void main(String[] args) {
		
		List<Person> personnes = PersonsDB.PERSONS;
		System.out.println("===================== Started Person List ===============");
		display(personnes);
			
		// loop and modify
		personnes.stream().filter(item -> (item.getAge() == 63)).forEach(p -> p.setAge(0));
		
		System.out.println("===================== updated Person List ===============");
		display(personnes);
		
		System.out.println("===================== started primitive List ===============");
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
	    System.out.println(list);
	    
		System.out.println("===================== upated primitive List ===============");
		
		
		// String 
		
		list.replaceAll(x -> "b" + x);
		System.out.println("String List - replace All item " + list);
		
		list.set(0,"D");
		System.out.println("String List - replace some item " + list);
				
		System.out.println("String List - replace some item " + list);
		
		list = list.stream().filter(item -> item.equals("D")).map(x -> "x-" + x).collect(Collectors.toList());
		System.out.println("String List - replace item D : " + list);
		
		//  integer
		// to update item in position index : use list.set(index, newitem) 

		List<Integer> integerList = new ArrayList<>();
		integerList.add(0, 1);
		integerList.add(0, 2);
		integerList.add(0, 3);
		System.out.println("Integer List " + integerList);
		
		integerList.set(0, 8);
		System.out.println("Integer List " + integerList);
		
		
		
		
	}
	
	
	/**
	 * méthode utilitaire 
	 * @param personnes
	 */
	public static void display(List<Person> personnes) {
		personnes.forEach(item -> {
			System.out.println(item.getFirstname() + item.getLastname() + " : " + item.getAge());
		});
	}
	
	// can't change liste value with with ONLY foreach
	//The method forEach only iterates through the elements of the list without changing them

}
