package chap10_Exceptions;

class Point6 {
	public Point6(int x, int y) throws ErrConst6 {
		if ((x <= 0) || (y <= 0))
			throw new ErrConst6();
		this.x = x;
		this.y = y;
	}

	public void f() throws ErrConst6 {
		try {
			Point6 p = new Point6(-3, 2);
		} catch (ErrConst6 e) {
			System.out.println("dans catch (ErrConst6) de f");
			throw e; // on repasse l'exception à un niveau superieur
		}
	}

	private int x, y;
}

class ErrConst6 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

public class Redecl {
	public static void main(String args[]) {
		try {
			Point6 a = new Point6(1, 4);
			a.f();
		} catch (ErrConst6 e) {
			System.out.println("dans catch (ErrConst6) de main");
		}
		System.out.println("apres bloc try main");
	}
}
