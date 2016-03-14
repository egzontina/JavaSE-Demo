package tmp;

public class MathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(" = " + Math.sqrt(3.0));
		
		// fonctions de comparaisons
		System.out.println(" le plus grand = " + Math.max(5, 10));
		System.out.println(" le plus petit = " + Math.min(7, 14));
		
		// Les arrondis
		double[] valeur = {-5.7, -5.5, -5.2, -5.0, 5.0, 5.2, 5.5, 5.7 };
		for (int i = 0; i < valeur.length; i++) {
		      System.out.println("round("+valeur[i]+") = "+Math.round(valeur[i]));
		      System.out.println("rint("+valeur[i]+") = "+Math.rint(valeur[i]));
		      System.out.println("floor("+valeur[i]+") = "+Math.floor(valeur[i]));
		    }
		  
	}
	/*
	 * etc ..
	 */

}
