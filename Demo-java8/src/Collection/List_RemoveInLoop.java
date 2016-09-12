package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Parcour avec Suppression
 * 
 * @author Malick
 */
public class List_RemoveInLoop {

    public static void main(String[] args) {
	// TODO Auto-generated method stub

    }

    /**
     * La méthode remove de l’interface Iterator L’interface Iterator prévoit la méthode remove qui supprime de la
     * collection le dernier objet renvoyé par next.
     */
    public static void removeWithIteratorInFor(List<String> list) {
	// clever way - It would be the same as doing - do it.next() before instruction
	for (Iterator<String> iterator = list.iterator(); iterator.hasNext();) {
	    String str = iterator.next();
	    if (str.equals("4")) {
		iterator.remove();
	    }
	}

    }

    public static void removeWithIteratorInWhile(List<String> list) {
	Iterator<String> it = list.iterator();
	while (it.hasNext()) {
	    String str = it.next();
	    if (str.equals("4")) {
		it.remove();
	    }
	}
    }

    /**
     * Collection REMOVEIF Method
     */
    public static void removeIf(List<String> list) {
	// Collection : removeIf : Retire un objet : prend un prédicat - removes an element on a predicate
	// works « in place », no Collections.unmodifiable...
	List<String> strings2 = Arrays.asList("one", "two", "three");
	Collection<String> list2 = new ArrayList<>(strings2);
	// returns true if the list has been modified, if string are more than 4 character
	boolean b = list2.removeIf(s -> s.length() > 4);

	if (Boolean.TRUE.equals(b)) {
	    System.out.println("Remove Done");
	}

	System.out.println("List RemoveIf : " + list2);
    }

    /**
     * Interface LISTITERATOR
     * parcourir à l’envers une une liste chaînée (du type LinkedList)
     */
    public static void ReverseBrowserWithListIterator(LinkedList<String> l) {
	ListIterator<String> iter;
	iter = l.listIterator(l.size()); /* position courante : fin de liste */
	while (iter.hasPrevious()) {
	    String o = iter.previous(); // Object o=iter.previous() ; <-- avant JDK 5.0
	    // utilisation de l’objet courant o
	    // ...
	}
    }

}
