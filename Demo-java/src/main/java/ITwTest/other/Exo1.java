package ITwTest.other;

/**
 * Main Class
 */
public class Exo1 {
    public static void main(String[] args) {
    }

}

/**
 * Exo 1
 */
class ClassA {
    public ClassA() {
        System.out.println(" A ");
    }
}

class ClassB extends ClassA {
    public ClassB() {
        System.out.println(" B ");
    }
}

class TestExo1 {
    public static void main(String[] args) {
        ClassA A = new ClassB(); // A B
        System.out.println("\n");
        ClassB B = new ClassB(); // A B
    }
}

/**
 * Exo 2
 */
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

class TestExo2 {
    public static void main(String[] args) {
        
        /** qu'affichera le code suivant ? */
        
        Bidule b = new Bidule(); 
        Machin m = b;
        System.out.println( m.f() + " * " + m.g() + " = " + m.f()* m.g() ); // 2 * 6 = 12
        System.out.println( b.f() + " * " + b.g() + " = " + b.f()* b.g() ); // 2 * 4 = 12
        
        /* La methode g est statique, la version utilis�ee est déterminée par le compilateur en fonction du type de la référence. 
         * Pour f tout est diff�erent: sa version utilis�e est d�etermin�e dynamiquement (� l�execution) par la JVM en fonction du type de l�objet. 
         */
    }
}

/**
 * Exo 3
 */
class TestExo3 {
    public static void main(String[] args) {
        /** quéaffichera léinstruction suivante ??         */
        B1 monB = new B1(2003); // CiaoBonjour 200
        
        /* Réponse : 
         * Léinstruction invoque le constructeur avec un argument entier (2003). 
         * Ce dernier appelle explicitement le constructeur sans arguments (this()) qui imprime éCiaoé,
         * et ensuite le message éBonjour 2003é est imprimé. */
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

/**
 * Exo 4
 */
class TestExo4 {
    public static void main(String[] args) {
        
        /** qu' affichera le code suivant? */
       
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
    }
}

class C {
    public static int i;
    public int j;

    public C() {
        i++;
        j = i;
    }
}

/**
 * Exo 5
 */
class Parent {}

class Child extends Parent {}

class TestExo5 {
    public static void main(String[] args) {
                
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