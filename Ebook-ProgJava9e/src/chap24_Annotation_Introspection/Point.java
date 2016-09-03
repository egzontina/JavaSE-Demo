package chap24_Annotation_Introspection;

public class Point {
	public Point() {
		x = 0;
		y = 0;
		compte++;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		compte++;
	}

	void affiche() {
		System.out.println("coordonnees : " + x + " " + y);
	}

	public void deplace(int dx, int dy) {
		x += dx;
		y += dy;
	}

	private void symetrise() {
		x = -x;
		y = -y;
	}

	public static void afficheNbre() {
		System.out.println("il y a " + compte + "points");
	}

	private int x, y;
	public static int compte = 0;
	protected int z;
}
