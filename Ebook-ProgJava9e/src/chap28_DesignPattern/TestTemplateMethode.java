package chap28_DesignPattern;

abstract class Forme4 {
    public void affiche() {
	afficheNature();
	System.out.println("-- Coordonnees = " + x + " " + y);
	afficheAutresInfos();
    }

    abstract public void afficheNature(); // a redefinir obligatoirement

    public void afficheAutresInfos() {
    } // version par defaut si pas redefinie

    protected int x, y; // pour eviter pb acces dans classes derivees
}

class Point4 extends Forme4 {
    public Point4(int x, int y) {
	this.x = x;
	this.y = y;
    }

    public void afficheNature() {
	System.out.println("Je suis un Point4");
    }
    // ici, on ne redefinit pas afficheAutresInfos
}

class Cercle4 extends Forme4 {
    public Cercle4(int x, int y, double r) {
	this.x = x;
	this.y = y;
	this.r = r;
    }

    private double r;

    public void afficheNature() {
	System.out.println("Je suis un Cercle4");
    }

    public void afficheAutresInfos() {
	System.out.println("-- Rayon = " + r);
    }
}

/**
 * Main client Class
 * 
 * @author Malick
 */
public class TestTemplateMethode {
    public static void main(String args[]) {
	Point4 p = new Point4(2, 5);
	p.affiche();
	Cercle4 c = new Cercle4(3, 8, 4.5);
	c.affiche();
    }
}