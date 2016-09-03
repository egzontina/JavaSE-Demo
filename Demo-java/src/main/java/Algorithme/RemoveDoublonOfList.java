package Algorithme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDoublonOfList {

	
	/**
	 * 
	 * une liste d'éléments, qui contient des doublons
	 * Trouver les éléments uniques , eliminer les doublons 
	 * 
	 */
	
	public static void main(String[] args) {
List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,5,5,6,6,7,8,9,9));
		
		System.out.println(uniqueElementOfIntegerListElement(list));

	}

	//  complexité en temps de O(L2 ) - quadratique
	public static List<Integer> uniqueElementOfIntegerListElement(List<Integer> list) {	
		List<Integer> copyList = new ArrayList<>();
		if (list != null & !list.isEmpty()) {			
			for (Integer element : list) {
				if (!copyList.contains(element)) {
					copyList.add(element);
				}
			}
		}
		return copyList;
	}
/*
 * complexité de cet algorithme dépend de la complexité du tri : 
 */
	public static List<Integer> uniqueElementOfIntegerListElement2(List<Integer> list) {	
		List<Integer> copyList = new ArrayList<>();
		// trier de la liste avant 
		
		/*
		 * parcourir la liste en se souvenant du dernier élément parcouru. Si l'élément actuel est le même que l'élément précédent, 
		 * alors c'est un doublon et on ne l'inclut pas dans la liste des éléments uniques.
		 */
		if (list != null & !list.isEmpty()) {			
			for (Integer element : list) {
				if (!copyList.contains(element)) {
					copyList.add(element);
				}
			}
		}
		return copyList;
	}

}
