package chap06_Classe_Object;

class Point5 {
	public Point5() // constructeur 1 (sans argument)
	{
		x = 0;
		y = 0;
	}

	public Point5(int abs) // constructeur 2 (un argument)
	{
		x = y = abs;
	}

	public Point5(int abs, int ord) // constructeur 3 (deux arguments)
	{
		x = abs;
		y = ord;
	}

	public void affiche() {
		System.out.println("Coordonnees : " + x + " " + y);
	}

	private int x, y;
}

public class Surdef2 {
	public static void main(String args[]) {
		Point5 a = new Point5(); // appelle constructeur 1
		a.affiche();
		Point5 b = new Point5(5); // appelle constructeur 2
		b.affiche();
		Point5 c = new Point5(3, 9); // appelle constructeur 3
		c.affiche();
	}
}
