package chap10_Exceptions;

class Point7 {
	public Point7(int x, int y) throws ErrConst7 {
		if ((x <= 0) || (y <= 0))
			throw new ErrConst7();
		this.x = x;
		this.y = y;
	}

	public void f() throws ErrConst7, ErrBidon {
		try {
			Point7 p = new Point7(-3, 2);
		} catch (ErrConst7 e) {
			System.out.println("dans catch (ErrConst7) de f");
			throw new ErrBidon(); // on lance une nouvelle exception
		}
	}

	private int x, y;
}

class ErrConst7 extends Exception {
}

class ErrBidon extends Exception {
}

public class Redecl1 {
	public static void main(String args[]) {
		try {
			Point7 a = new Point7(1, 4);
			a.f();
		} catch (ErrConst7 e) {
			System.out.println("dans catch (ErrConst7) de main");
		} catch (ErrBidon e) {
			System.out.println("dans catch (ErrBidon) de main");
		}
		System.out.println("apres bloc try main");
	}
}
