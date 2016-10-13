package ITwTest.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Main Class
 */
public class Exo_1_to_6 {
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
 * Exo 3 | Référence vs Object
 */
class TestExo3 {
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
 * Exo 4 | Référence vs Object
 */
class TestExo4 {
    public static void main(String[] args) {
        B b1 = new B(); 
        B b2 = new B(2003); 
        B b3 = new B("Bonjour");
        
        System.out.println(b1.x + " et " + b2.x + " et encore " + b3.x ); 
        
        // output :  6 et 2009 et encore 4
        
        /* Le constructeur B() n'appelle pas explicitement this() et super(). 
         * Donc, par convention, le constructeur de la super-classe A est appelé implicitement avant de procéder.  
         * Le constructeur B(2003) appelle le constructeur précédent avec le this(), 
         * ce qui donne b2.x=6. Ensuite on y ajoute 2003, ce qui donne finalement b2.x=2009 
         * Le constructeur B(Bonjour) appelle le constructeur de la super-classe A avec le super(). Ceci donne b3.x=5. 
         * Ensuite on le decr�mente et on a finalement b3.x=4.
         * 
         */
    }
}


class A {
    public int x;
    public A() { x = 5; }
}

class B extends A {

    public B() { x++; }

    public B(int i) {
        this();
        x = x + i;
    }

    public B(String s) {
        super();
        x--;
    }
}


/**
 * Exo 5 |Inhéritance 
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

/**
 * Exo 6 | ArrayList 
 */
class TestExo6 {
    public static void main(String[] args) {
        /*
         * When list declared, I still can add to ArrayList new elements, remove
         * elements and update it. when an array is declared as final, the state
         * of the object stored in the array can be modified
         */
        final List<String> stList = new ArrayList<String>(Arrays.asList("a", "b", "c"));
        System.out.println(stList);

        stList.add("d");

        System.out.println(stList);

        /*
         * what is effect making it's final? 
         * This means that i cannot rebind the
         * variable to point to a different collection instance you can't
         * re-assign its reference.
         */
        final List<Integer> list = new ArrayList<Integer>();
        // list = new ArrayList<Integer>(); 
        // Since `list' is final, this won't compile
        // The final local variable list cannot be assigned. It must be blank
        // and not using a compound assignment

        /*
         * if If i wish, you can prevent insertion, removal etc by using
         * Collections.unmodifiableList()
         * 
         */
        final List<Integer> list2 = Collections.unmodifiableList(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        System.out.println("list2 unmodifiableList :" + list2);
        list2.add(4); // throw exception
        System.out.println("list2 add() : " + list2);

        /*
         * Which advantages/disadvantages we can get by making ArrayList (or
         * other Collection) final?
         */  
    }
}