package ITwTest;

import java.util.concurrent.atomic.AtomicInteger;

public class QuizInfoTem {
    public static void main(String[] args) {
    }
}

/**
 * Q4 | Exception | try-catch-finally
 */
class TestClass4 {
    public static void main(String[] args) {
        try {
            return;
        } finally {
            System.out.println("Finally");
        }
    }
}

/**
 * Q5 | total number of instance  of the classe
 */

class A1 {
    private static AtomicInteger COUNTER = new AtomicInteger(0);

    A1() {
        COUNTER.incrementAndGet();
    }

    public static int getNbInstance() {
        return COUNTER.intValue();
    }
}

class ClassTest5 {
    public static void main(String[] args) {
        A1 x, u, v;
        x = new A1();
        A1 y = x;
        A1 z = new A1();

        System.out.println("nombe d'instance de A1 = " + A1.getNbInstance()); 
        
        // output : nombre d'instane de A1 : 2
    }
}

/**
 * Q5 | total number of instance  of the classe
 */
class Point {

    private static AtomicInteger COUNTER = new AtomicInteger();

    private static Point centerPoint = new Point();

    private int my_x = 0;
    private int my_y = 0;

    public Point() {
        COUNTER.incrementAndGet();
        // System.out.println("point defaut = " + getNbInstance());
    }

    public Point(int x, int y) {
        COUNTER.incrementAndGet();
        // System.out.println("point "+x+" "+y+" = " + getNbInstance());

        my_x = x;
        my_y = y;
        centerPoint = new Point();
    }

    public static int getNbInstance() {
        return COUNTER.intValue();
    }
    
    public static void main(String[] args) {
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);
        System.out.println("nombe d'instance de la classe Point = " + Point.getNbInstance()); 
        
        // output :  nombe d'instance de la classe Point = 5
    }
}

/**
 * Q6 | constructeur 
 */

class B1 {
    public B1(){
        System.out.println("Ciao");
    }

    public B1(int i) {
        this(); 
        System.out.println("Bonjour " + i);
    }
}

class ClassTest6 {
    public static void main(String[] args) {
        B1 b = new B1(2007); // ouput : CiaoBonjour 2007
        
        /*
         * Léinstruction invoque le constructeur avec un argument entier (2003). 
         * Ce dernier appelle explicitement le constructeur sans arguments (this()) qui imprime éCiaoé,
         * et ensuite le message éBonjour 2003é est imprimé. 
         * */
    }
}



/**
 * Q7 | L'héritage : les Méthodes
 */
class ClasseA {
    public void affiche() {
        System.out.println("je sus un objet de classe A");
    }
}

class ClasseB extends ClasseA {
    public void affiche() {
        System.out.println("je suis un objet de classe B");
    }
}

class ClasseB2 extends ClasseA {
    // pas de rédéfinition de la méthode affiche
}

class ClasseC extends ClasseB2 {
    public void affiche() {
        super.affiche();
        System.out.println("je suis un objet de classe C");
    }
}

class ClassTest7 {
    public static void main(String[] args) {
        ClasseB b = new ClasseB();
        b.affiche();
        // output :
        // je suis un objet de classe B

        ClasseB2 b2 = new ClasseC();
        b2.affiche();
        // ouput :
        // je suis un objet de classe A
        // je suis un objet de classe C

    }
}

/**
 * Q10
 */
class A {
}

class B extends A {
}

class ClassTest10 {
    public static void main(String[] args) {
        B obj = new B();
        System.out.println(obj instanceof A);// true
        System.out.println(obj instanceof B); // true
        System.out.println(obj instanceof Object);// true
    }
}

/**
 * Q11
 */
class ClassTest11 {
    public static void main(String[] args) {
        int i;
        for (i = 0; i < 10; i++) {
            if (i % 5 == 4) { // 4 % 5 == 4
                i *= 3; // i = 12
                i--; // i = 11
            }
            System.out.println("i=" + i); // 11
            // i++ is run when return to for, make i egal to 12
        }
        System.out.println();
        System.out.println("i=" + i); // 12
    }
}

/**
 * Q14
 */
// create an anonymous inner class from within class Baar ?
//
class Boo {
    Boo(String s) {
    }

    Boo() {
    }
}

class Bar extends Boo {
    Bar(String s) {
        super();
    }

    Bar() {
    }

    void zoo() {
        // :: INSERE ODE HERE
        Boo f = new Bar() {
        };
    }
}

/**
 * Q15
 */
class ClassTest15 {
    public static void main(String[] args) {
        try {
            int t = 1 / 0;
        } catch (NullPointerException e) {
            System.out.println("NullPointer Exception, ");
            return;

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception, ");
            return;
        } finally {
            System.out.println("Finally Clause");
        }

        // output : Arithmetic Exception, Finally Clause
    }
}

/**
 * Q16
 */
class ClassTest16 {
    public static void main(String[] args) {
        final Thread secondThread = new Thread() {
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("2 ");
                }
            }
        };

        final Thread firstThread = new Thread() {
            public void run() {
                secondThread.start();
                try {
                    secondThread.join();
                } catch (InterruptedException e) {
                }
                for (int i = 0; i < 3; i++) {
                    System.out.println("1 ");
                }
            }
        };

        firstThread.start();
    }

    // ouput : 2 2 2 1 1 1
}

/**
 * Q17
 */
class TestThread {

    private long v1 = 0;
    private long v2 = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public long getV1() {
        synchronized (lock1) {
            return v1;
        }

    }

    public long getV2() {
        synchronized (lock2) {
            return v2;
        }
    }

    public void inclV1V2() {
        synchronized (lock1) {
            synchronized (lock2) {
                v1++;
                v2++;
            }
        }
    }

    public void multiV1V2(int mult) {
        synchronized (lock2) {
            synchronized (lock1) {
                v1 *= mult;
                v2 *= mult;
            }
        }
    }

    // @formatter:off
 
    /* selectionner une réponse
     - la variable v1 peut être modifié pardeux thread en même temps
     - il manque des catchs sur les exceptions de type InterruptedException
     - Cette classe peut provoquer un blocage "dead lockk" 
     - les variables v1 et v2 ne peuvent être lue ne même temps par deux threads   
     */

    // @formatter:on
}

class ClassTest17 {

    public static void main(String[] args) {

    }
}