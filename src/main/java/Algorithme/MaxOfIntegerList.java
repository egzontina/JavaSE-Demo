package Algorithme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxOfIntegerList {
	/**
	 * Chercher le plus grand / petit élément
	 * Vous disposez d'une liste d'entiers positifs, et vous voulez trouver le plus grand de la liste. 
	 *  N comparaisons : une par élément | compléxité linéraire : O(N)
	 *  l'occupation mémoire de notre algorithme est constante (on note aussi O(1)
	 *  */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,5,5,6,6,7,8,9,9));
		System.out.println(maxOfIntegerListElement(list));
	}
	
	public static Integer maxOfIntegerListElement(List<Integer> list) {
		
		if (list != null & !list.isEmpty()) {
			Integer maxActuel = list.get(0);
			for (Integer element : list) {
				if (element > maxActuel) {
					maxActuel = element;
				}
			}
			return maxActuel;
		}
		return null;
	}
	public static Integer maxOfIntegerListElementJava8(List<Integer> list) {
		Integer maxActuel = 0;	
		list.stream().forEach((element) -> {
			if(element > maxActuel) {
//				maxActuel = element;
			}
		});
		
		return maxActuel;
	}
	
}
