package algorithm;

/**
 * Implémentez la méthode closestToZero pour renvoyer l'entier du tableau ints le plus proche de zéro.
 * <p>
 * S'il y a deux entiers tout aussi proches de zéro, considérez l'entier positif comme étant le plus proche de zéro (par
 * exemple si ints contient -5 et 5, retournez 5).
 * <p>
 * Si ints est null ou vide, retournez 0 (zero).
 * <p>
 * Données : les entiers dans ints ont des valeurs allant de -2147483647 à 2147483647.
 */
public class ClosestToZero {

    static int closestToZero(int[] ints) {

        if (ints.length == 0 || ints == null) {
            return 0;
        }

        int T;
        int min = Integer.MAX_VALUE;
        /* Search the temperature of minimum absolute valueReads */
        for (int i = 0; i < ints.length; i++) {
            T = ints[i];
            if (Math.abs(T) < Math.abs(min) || (T == -min && T > 0))
                min = T;
        }

        return min;
    }

}
