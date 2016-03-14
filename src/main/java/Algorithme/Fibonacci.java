package Algorithme;

import java.util.Scanner;

/**
 * La suite de Fibonacci est une suite d'entier dont la valeur de chaque terme est égale à la somme des valeurs des deux
 * termes précédents. C'est donc une suite récurrente.
 * on commence par 1 et 1 -> 1+1 =2 -> 1+2=3 -> 2+3=5 -> 3+5=8 -> 5+8=13 ...-> 21 -> 34 -> 55
 * 
 * suite observé fréquement dans la nature
 * en botanique, dans des varaition tel quel que les fluctuation de la bourse ou la beauté humaine
 * @author a614412
 *
 */
public class Fibonacci {
	
	public static void main(String[] args) {
		
		/**
		 * x0=0
		 * X1=1
		 * xn=xn-2+xn-1
		 * 
		 */
		
	    int nbElement;
	  
	    int fib = 1;
	    int terme_prec1 = 2;
	    int terme_prec2 = 1;
	    
	    Scanner sc = new Scanner(System.in);
		System.out.println("Entrez le nombre de Fibonacci a calculer ? : ");
		nbElement = sc.nextInt();
		System.out.println("Les "+nbElement+" premiers éléments de la suite de Fibonacci sont : ");
		
		for ( int i= 1 ; i <= nbElement ; i++ ) {
			  
		      if ( i == 2 ) {
		        fib = 2; 
		       }
		  
		      if ( i > 2 ) {
		        fib = terme_prec1 + terme_prec2;
		        terme_prec2 = terme_prec1;
		        terme_prec1 = fib;
		      }
		  
		      System.out.print(fib+";"); 
		  }
		
		
	}

}
