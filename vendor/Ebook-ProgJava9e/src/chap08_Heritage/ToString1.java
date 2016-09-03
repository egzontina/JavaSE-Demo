package chap08_Heritage;

class Point0 {
	public Point0(int abs, int ord) {
		x = abs;
		y = ord;
	}

	private int x, y;
}

public class ToString1 {
	public static void main(String args[]) {
		Point0 a = new Point0(1, 2);
		Point0 b = new Point0(5, 6);
		System.out.println("a = " + a.toString());
		System.out.println("b = " + b.toString());
	}
}
