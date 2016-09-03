package chap10_Exceptions;

class Point2 {
	public Point2(int x, int y) throws ErrConst2 {
		if ((x < 0) || (y < 0))
			throw new ErrConst2();
		this.x = x;
		this.y = y;
	}

	public void deplace(int dx, int dy) throws ErrDepl {
		if (((x + dx) < 0) || ((y + dy) < 0))
			throw new ErrDepl();
		x += dx;
		y += dy;
	}

	public void affiche() {
		System.out.println("coordonnees : " + x + " " + y);
	}

	private int x, y;
}

class ErrConst2 extends Exception {

	private static final long serialVersionUID = 1L;
}

class ErrDepl extends Exception {

	private static final long serialVersionUID = 1L;
}

public class Except2 {
	public static void main(String args[]) {
		try {
			Point2 a = new Point2(1, 4);
			a.affiche();
			a.deplace(-3, 5);
			a = new Point2(-3, 5);
			a.affiche();
		} catch (ErrConst2 e) {
			System.out.println("Erreur construction ");
			System.exit(-1);
		} catch (ErrDepl e) {
			System.out.println("Erreur deplacement ");
			System.exit(-1);
		}
	}
}
