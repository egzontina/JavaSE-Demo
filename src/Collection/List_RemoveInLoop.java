package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Parcour avec Suppression
 * 
 * @author Malick
 *
 */
public class List_RemoveInLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Parcour avec un iterator USE : quand vous devez supprimer des Ã©lÃ©ments de la collection
	 */

	public static void removeWithIteratorFor(List<String> list) {
		// clever way - It would be the same as doing - do it.next() before instruction
		for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
			String str = iterator.next();
			if (str.equals("4")) {
				iterator.remove();
			}
		}
	}
	
	
	public static void removeIf(List<String> list) {
		// Collection : removeIf : Retire un objet : prend un prÃ©dicat - removes an element on a predicate
		// works Â« in place Â», no Collections.unmodifiable...
		List<String> strings2 = Arrays.asList("one", "two", "three");
		Collection<String> list2 = new ArrayList<>(strings2);
		// returns true if the list has been modified, if string are more than 4 character
		boolean b = list2.removeIf(s -> s.length() > 4);
		
		if (Boolean.TRUE.equals(b)) {
			System.out.println("Remove Done");
		}
		
		System.out.println("List RemoveIf : " + list2);
	}
	
	public static void loopwithIteratorWhile(List<String> list) {
		// Nous recupérons notre itérrateur
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			// nous recupérons l'élément courant
			String str = it.next();
			// si nous sommes sur l'élément 4, nous le retirons de la collection
			if (str.equals("4"))
				it.remove();
		}
	}

}
