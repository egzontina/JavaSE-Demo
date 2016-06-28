package chap23_Lambda_Stream;

public class Point {

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int distance_a(Point p) {
		return p.x - x;
	}

	public int distance1(Point p) {
		return p.x - x;
	}

	public int distance2(Point p) {
		return p.y - y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	private int x, y;

}
