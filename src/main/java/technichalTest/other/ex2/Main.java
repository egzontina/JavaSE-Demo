package technichalTest.other.ex2;
/**
 * 
 * @author Malick
 *
 */
public class Main {

	public static void main(String[] args) {

		/**
		 * qu’affichera le code suivant?
		 * ===================================================================== 
		 */
		
		Bidule b = new Bidule(); 
		Machin m = b;
		System.out.println( m.f() + " * " + m.g() + " = " + m.f()* m.g() ); // 2 * 6 = 12
		
		/* La methode g est statique, la version utilis´ee est d´éterminée par le compilateur en
		 * fonction du type de la référence. 
		 * Comme m est une r´ef´erence Machin, m.g() - c’est toujours la m´ethode g de la classe Machin (valeur 6). 
		 * Pour f tout est diff´erent: sa version utilisée est d´eterminée dynamiquement (à l’execution) par la JVM en fonction du type de l’objet. 
		 * Dans le cas de m.f(), m fait r´ef´erence à une instance de Bidul,
		 * c’est donc la version de redéfinie dans la classe Bidul qui est invoquée (valeur 2).
		 * D’ou la r´eponse.
		 */
		
	}

}
