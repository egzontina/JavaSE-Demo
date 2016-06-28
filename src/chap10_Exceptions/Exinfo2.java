package chap10_Exceptions;

class Point4 {
	public Point4(int x, int y) throws ErrConst3 {
		if ((x < 0) || (y < 0))
			throw new ErrConst3("Erreur construction avec coordonnees " + x + " " + y);
		this.x = x;
		this.y = y;
	}

	public void affiche() {
		System.out.println("coordonnees : " + x + " " + y);
	}

	private int x, y;
}

class ErrConst3 extends Exception {

	private static final long serialVersionUID = 1L;

	ErrConst3(String mes) {
		super(mes);
	}
}

public class Exinfo2 {
	public static void main(String args[]) {
		try {
			Point4 a = new Point4(1, 4);
			a.affiche();
			a = new Point4(-3, 5);
			a.affiche();
		} catch (ErrConst3 e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
}
