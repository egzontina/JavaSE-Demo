package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * check if an array contains a certain value ?
 * 
 * @see http://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/
 * @author Malick
 */

public class ExistsInArrays {

    /*
     * 
     * Nombre dans un tableau (tutoriel)
     * 
     * Le but de cet exercice est de vérifier la présence d’un nombre dans un tableau.
     * 
     * Spécifications : Les éléments sont des nombres entiers classés du plus petit au plus grand Le tableau peut
     * contenir jusqu’à 1 million d’éléments Le tableau n’est jamais null Implémentez la méthode boolean A.exists(int[]
     * ints, int k) afin qu’elle retourne true si k est présent dans ints, sinon la méthode devra retourner false.
     * 
     * Important : Essayez de privilégier le temps d'exécution.
     * 
     * Exemple : int[] ints = {-9, 14, 37, 102}; A.exists(ints, 102) retourne true A.exists(ints, 36) retourne false
     * 
     * 
     * test if : La solution fonctionne avec un 'petit' tableau (200 pts) - Résolution de problèmes La solution
     * fonctionne avec un tableau vide (50 pts) - Fiabilité La solution fonctionne en un temps raisonnable avec 1
     * million d'items (700 pts) - Résolution de problèmes La solution utilise l'api J2SE pour effectuer la recherche
     * dichotomique. (200 pts) - Connaissance du langage
     * 
     * search an array of size 5, 1k, 10k. 100K, 1 millons
     * 
     */


    /**
     * LIST
     * <p>
     * this method is inefficient. Pushing the array to another collection requires spin through all elements to read
     * them in before doing anything with the collection type.
     */
    public static boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    /**
     * SET
     * <p>
     * hashset can do it in O(1)
     */
    public static boolean useSet(String[] arr, String targetValue) {
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        return set.contains(targetValue);
    }

    /**
     * LOOP
     * <p>
     * using a simple loop method is more efficient than using any collection
     */
    public static boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue))
                return true;
        }
        return false;
    }

    /**
     * Arrays.binarySearch()
     * <p>
     * Use if array is SORTED
     * <p>
     * a sorted list or tree can do it in O(log(n))
     */
    public static boolean useArraysBinarySearch(String[] arr, String targetValue) {
        int a = Arrays.binarySearch(arr, targetValue);
        if (a > 0)
            return true;
        else
            return false;
    }


    /**
     * Main METHOD
     */
    public static void main(String[] args) {

        // with small array
        String[] arr = new String[] { "CD", "BC", "EF", "DE", "AB" };

        // Use a larger array
        int size = 1000;// test 1k, 10k, 100k, 1Million
        int arrInt[] = new int[size];
        Random s = new Random();
        for (int i = 0; i < 1000; i++) {
            arrInt[i] = s.nextInt(); // String.valueOf(s.nextInt());
        }

        // use list
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useList(arr, "A");
        }
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("useList:  " + duration / 1000000);

        // use set
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useSet(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useSet:  " + duration / 1000000);

        // use loop
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useLoop(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useLoop:  " + duration / 1000000);

        // use Arrays.binarySearch()
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            useArraysBinarySearch(arr, "A");
        }
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("useArrayBinary:  " + duration / 1000000);

    }

}
