package technichalTest.eurogiciel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Exo2 {
/**
 * Ajout un lement a une liste triée , quelque soit le sens du tri
 * et retourné une nouvelle liste intégrant l'élément et trié
 * @param args
 */
	public static void main(String[] args) {

		List<Integer> sortedListASC = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
		List<Integer> sortedListDESC = sortedListASC.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

		try {
			System.out.println("sorted List ASC: " + sortedListASC);
			System.out.println("insertAndSort ASC: " + insertAndSort(4, sortedListASC));
			System.out.println("\n");
			System.out.println("sorted List DESC: " + sortedListDESC);
			System.out.println("insertAndSort DESC: " + insertAndSort(4, sortedListDESC));
		} catch (Exo2Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static List<Integer> insertAndSort(Integer num, List<Integer> l) throws Exo2Exception {

		List<Integer> result = new ArrayList<>();

		if (num == null) {
			throw new Exo2Exception("la valleur a ajoutée est null");
		} else if (l == null && !l.isEmpty()) {
			throw new Exo2Exception("la liste est null ou vide");
		} else {

			int firstElement = l.get(0);
			int lastElement = l.get(l.size() - 1);
			boolean flagNotAlredyAdded = true; // flag if num already added

			if (firstElement <= lastElement) {
				// list ASC
				for (Integer e : l) {
					if (num < e && flagNotAlredyAdded) {
						result.add(num);
						result.add(e);
						flagNotAlredyAdded = false;
					} else {
						result.add(e);
					}
				}

			} else {
				// list DESC
				for (Integer e : l) {
					if (num > e && flagNotAlredyAdded) {
						result.add(num);
						result.add(e);
						flagNotAlredyAdded = false;
					} else {
						result.add(e);
					}
				}
			}
		}

		return result;

	}

}
