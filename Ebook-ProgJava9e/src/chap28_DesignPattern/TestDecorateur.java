package chap28_DesignPattern;

/**
 * Classe Regroupant les méthodes communes à la classe à décorer et au décorateur
 */
abstract class Affichable {
    abstract void affiche();
}

/**
 * Classe à Décorer
 */
class Point extends Affichable {
    private int x, y;

    public Point(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public void affiche() {
	System.out.println("\n coordonnees = " + x + " " + y);
    }
}

/**
 * abstraite decorator
 */
abstract class Decorator extends Affichable {
    protected Affichable p;
    abstract void affiche();
}

/**
 * Decorator Color
 */
class Coloration extends Decorator {
    private int c;

    Coloration(Affichable p, int c) {
	this.p = p;
	this.c = c;
    }

    public void affiche() {
	p.affiche();
	System.out.println("+++ couleur " + c);
    }
}

/**
 * Decorator Forme
 */
class Forme extends Decorator {
    private Affichable p;
    private char f;

    Forme(Affichable p, char f) {
	this.p = p;
	this.f = f;
    }

    public void affiche() {
	p.affiche();
	System.out.println("+++ forme " + f);
    }
}

/**
 * Main client Class
 * 
 * @author Malick
 */
public class TestDecorateur {
    public static void main(String args[]) {
	Affichable pointColore = new Coloration(new Point(6, 5), 10);
	pointColore.affiche();
	Affichable pointForme = new Forme(new Point(1, 4), '*');
	pointForme.affiche();
	Affichable pointColoreForme = new Forme(pointColore, '+');
	pointColoreForme.affiche();
    }
}