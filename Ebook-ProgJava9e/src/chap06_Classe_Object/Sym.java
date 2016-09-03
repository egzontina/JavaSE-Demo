package chap06_Classe_Object;

class Point6 {
	public Point6(int abs, int ord) {
		x = abs;
		y = ord;
	}

	public Point6 symetrique() {
		Point6 res;
		res = new Point6(y, x);
		return res;
	}

	public void affiche() {
		System.out.println("Coordonnees : " + x + " " + y);
	}

	private int x, y;
}

public class Sym {
	public static void main(String args[]) {
		Point6 a = new Point6(1, 2);
		a.affiche();
		Point6 b = a.symetrique();
		b.affiche();
	}
}
