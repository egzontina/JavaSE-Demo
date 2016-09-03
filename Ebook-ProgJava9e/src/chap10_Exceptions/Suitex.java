package chap10_Exceptions;

class Point8 {
	public Point8(int x, int y) throws ErrConst8 {
		if ((x <= 0) || (y <= 0))
			throw new ErrConst8();
		this.x = x;
		this.y = y;
	}

	public void deplace(int dx, int dy) throws ErrDepl8 {
		if (((x + dx) < 0) || ((y + dy) < 0))
			throw new ErrDepl8();
		x += dx;
		y += dy;
	}

	public void affiche() {
		System.out.println("coordonnees : " + x + " " + y);
	}

	private int x, y;
}

class ErrConst8 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

class ErrDepl8 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

public class Suitex {
	public static void main(String args[]) {
		try {
			Point8 a = new Point8(1, 4);
			a.affiche();
			a.deplace(-3, 5);
			a = new Point8(-3, 5);
			a.affiche();
		} catch (ErrConst8 e) {
			System.out.println("Erreur construction ");
			System.exit(-1);
		} catch (ErrDepl8 e) {
			System.out.println("Erreur deplacement ");
			System.exit(-1);
		}
	}
}
