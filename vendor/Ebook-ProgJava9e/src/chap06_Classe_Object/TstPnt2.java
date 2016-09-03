package chap06_Classe_Object;

public class TstPnt2 {
	public static void main(String args[]) {
		Point8 a;
		a = new Point8();
		a.initialise(3, 5);
		a.affiche();
		a.deplace(2, 0);
		a.affiche();
		Point8 b = new Point8();
		b.initialise(6, 8);
		b.affiche();
	}
}

class Point8 {
	public void initialise(int abs, int ord) {
		x = abs;
		y = ord;
	}

	public void deplace(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void affiche() {
		System.out.println("Je suis un point de coordonnees " + x + " " + y);
	}

	private int x; // abscisse
	private int y; // ordonnee
}
