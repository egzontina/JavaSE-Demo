package ITwTest.eurogiciel;

import java.util.ArrayList;
import java.util.List;

public class exo3 {

	/**
	 * Suite de fibonnaci d'un nombre,
	 * La suite de Fibonacci est une suite d'entiers dans laquelle chaque terme est la somme des deux termes qui le précèdent.
	 * Elle commence généralement par les termes 0 et 1 (parfois 1 et 1) et ses premiers termes sont : 0, 1, 1, 2, 3, 5, 8, 13, 21, etc.
	 *  on n'étudie pas les nombres de Fibonacci pour des valeurs négatives de n
	 * @param args
	 * 
	 * WAY 1 : fonction récursive 
	 * Ce n'est cependant pas une façon judicieuse de calculer la suite de Fibonacci, car on calcule de nombreuses fois les mêmes valeurs . Le temps de calcul s'avère exponentiel 
	 * WAY 2 : 
	 * moyen bien plus efficace de calculer la suite de Fibonacci consiste à calculer simultanément deux valeurs consécutives de la suite
	 */
	public static void main(String[] args) {

		System.out.println("result for 4 and UP :" + fibb(4, closest.UP));
		System.out.println("result for 4 and DOWN :" + fibb(4, closest.DOWN));
	}
	
	public static Integer fibb(Integer number, closest en) {
	    int fib = 1;
	    int termePrec1 = 2;
	    int termePrec2 = 1;

		System.out.println("Les "+number+" premiers éléments de la suite de Fibonacci sont : ");
		
		List<Integer> resultList= new ArrayList<>();
		Integer result = 0;
		
		
		for ( int i= 1 ; i <= number ; i++ ) {
			  
		      if ( i == 2 ) {
		        fib = 2; 
		       }
		  
		      if ( i > 2 ) {
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
					result= e;
				}
			}
			
		}
		else {
			for (Integer e : resultList) {
				if (e == number + 1) {
					result= e;
				}
			}
		}
		
		return result;
		
		
	}

}
