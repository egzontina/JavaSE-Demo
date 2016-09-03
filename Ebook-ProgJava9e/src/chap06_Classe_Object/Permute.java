package chap06_Classe_Object;

class Point4 {
	public Point4(int abs, int ord) {
		x = abs;
		y = ord;
	}

	public void permute(Point4 a) // methode d'echange les coordonnees
									// du point courant avec celles de a
	{
		Point4 c = new Point4(0, 0);
		c.x = a.x;
		c.y = a.y; // copie de a dans c
		a.x = x;
		a.y = y; // copie du point courant dans a
		x = c.x;
		y = c.y; // copie de c dans le point courant
	}

	public void affiche() {
		System.out.println("Coordonnees : " + x + " " + y);
	}

	private int x, y;
}

public class Permute {
	public static void main(String args[]) {
		Point4 a = new Point4(1, 2);
		Point4 b = new Point4(5, 6);
		a.affiche();
		b.affiche();
		a.permute(b);
		a.affiche();
		b.affiche();
	}
}
