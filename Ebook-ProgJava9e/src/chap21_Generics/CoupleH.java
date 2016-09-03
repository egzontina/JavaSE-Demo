package chap21_Generics;

public class CoupleH {
	public static void main(String args[]) {
		Integer oi1 = 3; // équivalent à : Integer oi1 = new Integer (3) ;
		Integer oi2 = 5; // équivalent à : Integer oi2 = new Integer (5) ;
		Couple<Integer> ci = new Couple<Integer>(oi1, oi2);
		ci.affiche();
		Couple<Double> cd = new Couple<Double>(2.0, 12.0);
		// on peut fournir des arguments de type double qui seront
		// convertis automatiquement en Double
		cd.affiche();
		Double p = cd.getPremier();
		System.out.println("premier element du couple cd = " + p);

		System.out.println(cd instanceof Couple);
		System.out.println(cd instanceof Couple<?>);
		System.out.println(cd instanceof Couple<?>);
	}
}

/*
 * premiere valeur : 3 - deuxieme valeur : 5 premiere valeur : 2.0 - deuxieme
 * valeur : 12.0 premier element du couple cd = 2.0
 */
