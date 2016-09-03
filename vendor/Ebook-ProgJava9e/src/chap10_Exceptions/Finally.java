package chap10_Exceptions;

import Annexe_Utils.Clavier;

class Point5 {
	public Point5(int x, int y) throws ErrConst4 {
		if ((x < 0) || (y < 0))
			throw new ErrConst4();
		this.x = x;
		this.y = y;
	}

	private int x, y;
}

class ErrConst4 extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}

public class Finally {
	public static void main(String args[]) {
		try {
			System.out.println("debut bloc try du main");
			System.out.print("donnez un entier : ");
			int n = Clavier.lireInt();
			Point5 a = new Point5(n, n);
			System.out.println("fin bloc try du main");
		} catch (ErrConst4 e) {
			System.out.println("dans catch (ErrConst4) de main");
		} finally {
			System.out.println("execution du bloc finally");
		}
		System.out.println("apres bloc try main");
	}
}
