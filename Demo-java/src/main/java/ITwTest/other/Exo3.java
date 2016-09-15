package ITwTest.other;

public class Exo3 {

	public static void main(String[] args) {

		/** 
		 * Combien déinstances de la classe A1 créee le code suivant ?
		 * =====================================================================  
		 */
		
		/*
		A1 x, u, v;
		
		x = new A1();
		A1 y = x;
		A1 z = new A1();
		*/
		/* Réponse :
		 * Il y a deux instances de A1 crees par les deux new, la premiére
		 * est référencée par x et y, la deuxiéme par z.
		 */
		
		
		/** 
		 * quéaffichera léinstruction suivante ??
		 * =====================================================================  
		 */
		B1 monB = new B1(2003); // CiaoBonjour 200
		
		/* Réponse : 
		 * Léinstruction invoque le constructeur avec un argument entier (2003). 
		 * Ce dernier appelle explicitement le constructeur sans arguments (this()) qui imprime éCiaoé,
		 * et ensuite le message éBonjour 2003é est imprimé. */
		
		
		/**
		 * quéaffichera le code suivant?
		 * =====================================================================  
		 */
		 C x = new C(); 
		 C y = new C(); 
		 C z = x;
		 System.out.println(z.i + " et " + z.j); // --> 2 et 1
		/*
		 * On remarque déabord, que i est une variable (statique) de classe commune é toutes les instances, 
		 * tandis que chaque objet de la classe a son propre j. 
		 * Donc, aprés la premiére affectation on a i=1, x.j=1; 
		 * aprés la deuxiéme : i=2, y.j=2 (x.j a resté inchangé et égal é 1); 
		 * la troisi`eme néappelle pas le constructeur mais fait z référencer le méme objet que x. 
		 * Déou z.i est la valeur globale de i, c-`a-d 2, et z.j=x.j=1.
		 */
				
		/**
		 * Etant donnée que la classe Grande éetend la classe Petite, trouvez une ligne correcte parmi les suivantes ? 
		 * =====================================================================  
		 */
		
		/*
		Child x = new Child(); 
		Parent y = x; 
		Child z =(Child)y;
		*/
		/**
		 * Tout va bien. 
		 * On crée un objet de classe Child référencé par x.
		 * Ensuite on fait une variable y (de type Parent) référencer par le méme objet
		 * céest un upcasting explicite qui est toujours possible. 
		 * A1 la fin on fait encore une référence z (cette fois` Child) sur ce
		 * méeme objet. Ce dernier downcasting est possible parce que léobjet
		 * est en fait une instance de la classe Grande.
		 */
		
		/*
		Parent y = new Parent(); 
		Child x= (Child)y; 
		Petite z=x;
		*/
		/** 
		 * La deuxi`eme affectation Child x= (Child)y; essaye de transformer un objet
		 * (réeféerencée par y) de la classe Parent vers un objet de sa sous-classe Child. 
		 * Un tel downcasting est impossible. 
		*/
		/*
		Child x= new Child(); 
		Parent y = x; 
		Child z=y;
		*/
		/**
		 * Type mismatch: cannot convert from Parent to Child
		 * presque comme dans le cas préecéedent, mais la derni`ere affectation 
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


class Parent {

}

class Child extends Parent {

}



class C {

    public static int i;
    public int j;

    public C() {
        i++;
        j = i;
    }

}

class B1 {

    public B1(){
        System.out.println("Ciao");
    }

    public B1(int i) {
        this(); 
        System.out.println("Bonjour " + i);
    }
}

class A1 {

}