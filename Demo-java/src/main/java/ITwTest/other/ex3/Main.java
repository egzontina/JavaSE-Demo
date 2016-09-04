package ITwTest.other.ex3;

public class Main {

	public static void main(String[] args) {

		/** 
		 * Combien d�instances de la classe A cr�ee le code suivant ?
		 * =====================================================================  
		 */
		
		/*
		A x, u, v;
		
		x = new A();
		A y = x;
		A z = new A();
		*/
		/* R�ponse :
		 * Il y a deux instances de A crees par les deux new, la premi�re
		 * est r�f�renc�e par x et y, la deuxi�me par z.
		 */
		
		
		/** 
		 * qu�affichera l�instruction suivante ??
		 * =====================================================================  
		 */
		B monB = new B(2003); // CiaoBonjour 200
		
		/* R�ponse : 
		 * L�instruction invoque le constructeur avec un argument entier (2003). 
		 * Ce dernier appelle explicitement le constructeur sans arguments (this()) qui imprime �Ciao�,
		 * et ensuite le message �Bonjour 2003� est imprim�. */
		
		
		/**
		 * qu�affichera le code suivant?
		 * =====================================================================  
		 */
		 C x = new C(); 
		 C y = new C(); 
		 C z = x;
		 System.out.println(z.i + " et " + z.j); // --> 2 et 1
		/*
		 * On remarque d�abord, que i est une variable (statique) de classe commune � toutes les instances, 
		 * tandis que chaque objet de la classe a son propre j. 
		 * Donc, apr�s la premi�re affectation on a i=1, x.j=1; 
		 * apr�s la deuxi�me : i=2, y.j=2 (x.j a rest� inchang� et �gal � 1); 
		 * la troisi`eme n�appelle pas le constructeur mais fait z r�f�rencer le m�me objet que x. 
		 * D�ou z.i est la valeur globale de i, c-`a-d 2, et z.j=x.j=1.
		 */
				
		/**
		 * Etant donn�e que la classe Grande �etend la classe Petite, trouvez une ligne correcte parmi les suivantes ? 
		 * =====================================================================  
		 */
		
		/*
		Child x = new Child(); 
		Parent y = x; 
		Child z =(Child)y;
		*/
		/**
		 * Tout va bien. 
		 * On cr�e un objet de classe Child r�f�renc� par x.
		 * Ensuite on fait une variable y (de type Parent) r�f�rencer par le m�me objet
		 * c�est un upcasting explicite qui est toujours possible. 
		 * A la fin on fait encore une r�f�rence z (cette fois` Child) sur ce
		 * m�eme objet. Ce dernier downcasting est possible parce que l�objet
		 * est en fait une instance de la classe Grande.
		 */
		
		/*
		Parent y = new Parent(); 
		Child x= (Child)y; 
		Petite z=x;
		*/
		/** 
		 * La deuxi`eme affectation Child x= (Child)y; essaye de transformer un objet
		 * (r�ef�erenc�e par y) de la classe Parent vers un objet de sa sous-classe Child. 
		 * Un tel downcasting est impossible. 
		*/
		/*
		Child x= new Child(); 
		Parent y = x; 
		Child z=y;
		*/
		/**
		 * Type mismatch: cannot convert from Parent to Child
		 * presque comme dans le cas pr�ec�edent, mais la derni`ere affectation 
		 * Child z=y; est un downcasting implicite, ce qui est interdit.
		 */
		/*
		Parent y =new Parent(); 
		Child x= (Child)y; 
		Parent z=(Parent)x; 
		*/
		/**
		 * Cannot cast parent to child
		 * est un downcasting impossible, comme dans le premier
		 */
	}

}
