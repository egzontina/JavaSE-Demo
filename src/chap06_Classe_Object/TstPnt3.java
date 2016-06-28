package chap06_Classe_Object;

public class TstPnt3 {
	public static void main(String args[]) {
		Point9 a;
		a = new Point9(3, 5);
		a.affiche();
		a.deplace(2, 0);
		a.affiche();
		Point9 b = new Point9(6, 8);
		b.affiche();
	}
}

class Point9 {
	public Point9(int abs, int ord) // constructeur
	{
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
