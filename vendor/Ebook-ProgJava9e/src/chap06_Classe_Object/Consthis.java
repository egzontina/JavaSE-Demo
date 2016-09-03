package chap06_Classe_Object;

class Point3 {
	public Point3(int abs, int ord) {
		x = abs;
		y = ord;
		System.out.println("constructeur deux arguments : " + x + " " + y);
	}

	public Point3() {
		this(0, 0); // appel Point3 (0,0) ; doit etre la premiere instruction
		System.out.println("constructeur sans argument");
	}

	private int x, y;
}

public class Consthis {
	public static void main(String args[]) {
		Point3 a = new Point3(1, 2);
		Point3 b = new Point3();
	}
}
