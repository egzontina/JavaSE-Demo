package chap06_Classe_Object;

class Point2 {
	public Point2(int abs, int ord) {
		x = abs;
		y = ord;
	}

	public static boolean coincide(Point2 p1, Point2 p2) {
		return ((p1.x == p2.x) && (p1.y == p2.y));
	}

	private int x, y;
}

public class Coincid2 {
	public static void main(String args[]) {
		Point2 a = new Point2(1, 3);
		Point2 b = new Point2(2, 5);
		Point2 c = new Point2(1, 3);
		System.out.println("a et b : " + Point2.coincide(a, b));
		System.out.println("a et c : " + Point2.coincide(a, c));
	}
}
