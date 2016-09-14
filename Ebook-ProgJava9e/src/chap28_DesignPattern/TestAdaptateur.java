package chap28_DesignPattern;

interface Pixel {
    void affiche();

    void deplace(int dx, int dy);
}

/**
 * Classe de l'objet à adapter
 */
class PointX {

    private int x, y;

    public PointX(int x, int y) {
	this.x = x;
	this.y = y;
    }

    // affiche es coord du point
    public void montre() {
	System.out.println("Coordonnees = " + x + " " + y);
    }

    // augmente l'abcisse
    public void deltaX(int dx) {
	x += dx;
    }

    // augmente l'ordonée
    public void deltaY(int dy) {
	y += dy;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }
}

/**
 * Adaptateur OBJET : encapsule PointX
 */
class PointXAdapte implements Pixel { // on pourrait aussi extends Pixel si classe Abstraite
    private PointX px;

    public PointXAdapte(PointX px) {
	this.px = px;
    }

    public void affiche() {
	px.montre();
    }

    public void deplace(int dx, int dy) {
	px.deltaX(dx);
	px.deltaY(dy);
    }
}

/**
 * Adaptateur de CLASSE : encapsule dans classe ascendante
 */
class PointXAdapte2 extends PointX implements Pixel {
    public PointXAdapte2(PointX px) {
	super(px.getX(), px.getY());
    }

    public void affiche() {
	super.montre();
    }

    public void deplace(int dx, int dy) {
	deltaX(dx);
	deltaY(dy);
    }
}

/**
 * Main client Class
 * 
 * @author Malick
 */
public class TestAdaptateur {
    public static void main(String args[]) { // code existant utilisant déja des implementations de Pixel .....
	System.out.println("---------- Adaptateur Objet ");
	PointX px = new PointX(2, 5);
	PointXAdapte pxa = new PointXAdapte(px);
	// il peut maintenant utiliser des objets de type PointX, encapsules dans des objets de type PointXAdapte, comme
	// des implementations de Pixel
	pxa.affiche();
	pxa.deplace(2, 1);
	pxa.affiche();

	System.out.println("\n---------- Adaptateur par classe ");
	PointX pa2 = new PointX(3, 5);
	PointXAdapte2 pxa2 = new PointXAdapte2(pa2);
	pxa2.affiche();
	pxa2.deplace(2, 1);
	pxa2.affiche();

    }
}