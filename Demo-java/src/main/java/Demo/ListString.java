package Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * « Ecrire une classe Java avec 3 méthodes statiques pour manipuler une collection de chaîne. 
 * Une méthode pour transformer une liste de String en une seule String, 
 * chaque élément étant séparé par une virgule. 
 * deuxième méthode pour afficher en ordre inverse le contenu de ma liste de chaine. 
 * Enfin une troisième méthode pour mettre en majuscule chacune des Strings de ma liste. »
 * 
 * réalisable en 8-10 minutes, 2 mn si vous êtes très fort et 20 mn si vous êtes vraiment pas bon.
 * @author a614412
 *
 */
public class ListString {
	
	/**
	 * Returns a new String composed of list of string 
	 * @param list
	 * @return
	 */
	public static String concatenate(List<String> list) {
		String stringListJoined = String.join(",", list);
		return stringListJoined;
	}
	
	/**
	 * Reverses the order of the elements in the specified list.
	 * @param list
	 * @return
	 */
public static List<String> reverseList(final List<String> list) {
	Collections.reverse(list);
		return list;
	}

/**
 * maps all strings in the items collection to their uppercase equivalents.
 * @param list
 * @return
 */
public static List<String> toUppercase(List<String> list) {
	
	return list.stream().map( item -> item.toUpperCase()).collect(Collectors.toList());
}

/**
 *  merge multiple List into a single List
 */
public static List<String> joinTwoList(List<String> listA, List<String> listB) {
	List<String> listFinal = new ArrayList<String>();
	listFinal.addAll(listA);
	listFinal.addAll(listB);
	return listFinal;
}

}
