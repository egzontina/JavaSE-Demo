package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * MinMax
 * <p>
 * Chercher le plus grand et le plus petit élément Vous disposez d'une liste d'entiers positifs, et vous voulez trouver
 * le plus grand de la liste.
 * <p>
 * N comparaisons : une par élément | compléxité linéraire : O(N) l'occupation mémoire de notre algorithme est constante
 * (on note aussi O(1)
 */
public class MaxOfIntegerList {

    /**
     * Main method
     */
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 5, 5, 6, 6, 7, 8, 9, 9));
        System.out.println("maxOfIntegerListElement : " + maxOfIntegerListElement(list));
        System.out.println("maxOfIntegerListElementJava8 : " + maxOfIntegerListElementJava8(list));
        System.out.println("minOfIntegerListJava8 : " + minOfIntegerListJava8(list));
    }

    /**
     * @param list
     * @return
     */
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

    /**
     * @param list
     * @return
     */
    public static Integer maxOfIntegerListElementJava8(List<Integer> list) {

        /*
         * Integer currenMaxValue = 0; list.stream().forEach((element) -> { if (element > currenMaxValue) {
         * currenMaxValue = element; } }); return currenMaxValue;
         */
        Optional<Integer> max = list.stream().sorted((e1, e2) -> e2.compareTo(e1)).findFirst();
        return max.isPresent() ? max.get() : null;

    }

    /**
     * @param list
     * @return
     */
    public static Integer minOfIntegerListJava8(List<Integer> list) {
        Optional<Integer> max = list.stream().sorted((e1, e2) -> e1.compareTo(e2)).findFirst();
        return max.isPresent() ? max.get() : null;
    }

}
