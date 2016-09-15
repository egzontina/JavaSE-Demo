package ITwTest.other;
/**
 * 
 * @author Malick
 *
 */
public class Exo2 {

	public static void main(String[] args) {

		/**
		 * qu�affichera le code suivant?
		 * ===================================================================== 
		 */
		
		Bidule b = new Bidule(); 
		Machin m = b;
		System.out.println( m.f() + " * " + m.g() + " = " + m.f()* m.g() ); // 2 * 6 = 12
		
		/* La methode g est statique, la version utilis�ee est d��termin�e par le compilateur en
		 * fonction du type de la r�f�rence. 
		 * Comme m est une r�ef�erence Machin, m.g() - c�est toujours la m�ethode g de la classe Machin (valeur 6). 
		 * Pour f tout est diff�erent: sa version utilis�e est d�etermin�e dynamiquement (� l�execution) par la JVM en fonction du type de l�objet. 
		 * Dans le cas de m.f(), m fait r�ef�erence � une instance de Bidul,
		 * c�est donc la version de red�finie dans la classe Bidul qui est invoqu�e (valeur 2).
		 * D�ou la r�eponse.
		 */
		
	}

}

class Machin {

    public int f() {
        return (5);
    }

    public static int g() {
        return (6);
    }

}

class Bidule extends Machin {
    
    public int f() {
        return (2);
    }

    public static int g() {
        return (4);
    }

}
