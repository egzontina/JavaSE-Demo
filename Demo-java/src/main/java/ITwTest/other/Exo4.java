package ITwTest.other;
/**
 * 
 * @author Malick
 *
 */
public class Exo4 {

	public static void main(String[] args) {

		/**
		 * qu�affichera le code suivant?
		 * ===================================================================== 
		 */
		
		B b1 = new B(); 
		B b2 = new B(2003); 
		B b3 = new B("Bonjour");
		System.out.println(b1.x + " et " + b2.x + " et encore " + b3.x ); // > 6 et 2009 et encore 4
		
		/* Le constructeur B() n�appelle explicitement ni this(), ni super(). 
		 * Donc, par convention, le constructeur de la super-classe A est appel�e (implicitement) avant de proc�der. 
		 * Ceci donne b1.x=6. 
		 * Le constructeur B(2003) appelle le constructeur pr�c�dent avec le this(), 
		 * ce qui donne b2.x=6. Ensuite on y ajoute 2003, ce qui donne finalement b2.x=2009 
		 * Le constructeur B(�Bonjour�) appelle le constructeur de la super-classe A avec le super(). Ceci donne b3.x=5. 
		 * Ensuite on le decr�mente et on a finalement b3.x=4.
		 * 
		 */
		
		
		

	}

}


class A {

    public int x;

    public A() {
        x = 5;
    }

}

class B extends A {

    public B() {
        x++;
    }

    public B(int i) {
        this();
        x = x + i;
    }

    public B(String s) {
        super();
        x--;
    }

}
