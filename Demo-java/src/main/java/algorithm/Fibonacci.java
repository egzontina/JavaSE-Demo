package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * La suite de Fibonacci est une suite d'entier dont la valeur de chaque terme est égale à la somme des valeurs des deux
 * termes précédents. C'est donc une suite récurrente.
 * <p>
 * on commence par 1 et 1 -> 1+1 =2 -> 1+2=3 -> 2+3=5 -> 3+5=8 -> 5+8=13 ...-> 21 -> 34 -> 55
 * <p>
 * on n'étudie pas les nombres de Fibonacci pour des valeurs négatives de n suite observé fréquement dans la nature en
 * botanique, dans des varaition tel quel que les fluctuation de la bourse ou la beauté humaine
 * <p>
 * WAY 1 : fonction récursive Ce n'est cependant pas une façon judicieuse de calculer la suite de Fibonacci, car on
 * calcule de nombreuses fois les mêmes valeurs . Le temps de calcul s'avère exponentiel
 * <p>
 * WAY 2 : moyen bien plus efficace de calculer la suite de Fibonacci consiste à calculer simultanément deux valeurs
 * consécutives de la suite
 * 
 * @author Malick
 */
public class Fibonacci {

    /**
     * Main Method
     */
    public static void main(String[] args) {

        System.out.println("result for 4 and UP :" + fibbWithClosetNumber(4, closest.UP));
        System.out.println("result for 4 and DOWN :" + fibbWithClosetNumber(4, closest.DOWN));
    }

    /**
     * Suite de fibonacci & la valeur la plus proche selon la direction donnée
     */
    public static Integer fibbWithClosetNumber(Integer number, closest en) {
        int fib = 1;
        int termePrec1 = 2;
        int termePrec2 = 1;

        System.out.println("Les " + number + " premiers éléments de la suite de Fibonacci sont : ");

        List<Integer> resultList = new ArrayList<>();
        Integer result = 0;

        for (int i = 1; i <= number; i++) {

            if (i == 2) {
                fib = 2;
            }

            if (i > 2) {
                fib = termePrec1 + termePrec2;
                termePrec2 = termePrec2;
                termePrec1 = fib;
            }

            resultList.add(fib);

        }

        // retourne l'element le plus p^roche
        if (closest.DOWN.equals(en)) {
            for (Integer e : resultList) {
                if (e == number - 1) {
                    result = e;
                }
            }

        } else {
            for (Integer e : resultList) {
                if (e == number + 1) {
                    result = e;
                }
            }
        }

        return result;

    }

    /**x0=0 , X1=1, xn=xn-2+xn-1
     * @param args
     */
    public static void fibonacci1(String[] args) {

        int nbElement;

        int fib = 1;
        int terme_prec1 = 2;
        int terme_prec2 = 1;

        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrez le nombre de Fibonacci a calculer ? : ");
        nbElement = sc.nextInt();
        System.out.println("Les " + nbElement + " premiers éléments de la suite de Fibonacci sont : ");

        for (int i = 1; i <= nbElement; i++) {

            if (i == 2) {
                fib = 2;
            }

            if (i > 2) {
                fib = terme_prec1 + terme_prec2;
                terme_prec2 = terme_prec1;
                terme_prec1 = fib;
            }

            System.out.print(fib + ";");
        }

    }

}

/**
 * Closest ENUM with instance UP and DOWN
 * 
 * @author Malick
 *
 */
enum closest {

    UP,
    
    DOWN;
            
}
