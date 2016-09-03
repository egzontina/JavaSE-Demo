package chap10_Exceptions;

class Point3 {
	public Point3(int x, int y) throws ErrConst1 {
		if ((x < 0) || (y < 0))
			throw new ErrConst1(x, y);
		this.x = x;
		this.y = y;
	}

	public void affiche() {
		System.out.println("coordonnees : " + x + " " + y);
	}

	private int x, y;
}

class ErrConst1 extends Exception {

	private static final long serialVersionUID = 1L;

	ErrConst1(int abs, int ord) {
		this.abs = abs;
		this.ord = ord;
	}

	public int abs, ord;
}

public class Exinfo1 {
	public static void main(String args[]) {
		try {
			Point3 a = new Point3(1, 4);
			a.affiche();
			a = new Point3(-3, 5);
			a.affiche();
		} catch (ErrConst1 e) {
			System.out.println("Erreur construction Point3");
			System.out.println("  coordonnees souhaitees : " + e.abs + " " + e.ord);
			System.exit(-1);
		}
	}
}
