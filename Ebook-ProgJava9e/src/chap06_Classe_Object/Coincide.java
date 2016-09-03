package chap06_Classe_Object;

class Point1 {
	public Point1(int abs, int ord) {
		x = abs;
		y = ord;
	}

	public boolean coincide(Point1 pt) {
		return ((pt.x == x) && (pt.y == y));
	}

	private int x, y;
}

public class Coincide {
	public static void main(String args[]) {
		Point1 a = new Point1(1, 3);
		Point1 b = new Point1(2, 5);
		Point1 c = new Point1(1, 3);
		System.out.println("a et b : " + a.coincide(b) + " " + b.coincide(a));
		System.out.println("a et c : " + a.coincide(c) + " " + c.coincide(a));
	}
}
