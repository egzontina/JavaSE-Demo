package chap06_Classe_Object;

class Point7 {
	public Point7(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void affiche() {
		System.out.println("Je suis un point de coordonnees " + x + " " + y);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int x, y;
}

class Cercle {
	public Cercle(int x, int y, float r) {
		c = new Point7(x, y);
		this.r = r;
	}

	public void affiche() {
		System.out.println("Je suis un cercle de rayon " + r);
		System.out.println(" et de centre de coordonnees " + c.getX() + " " + c.getY());
	}

	public void deplace(int dx, int dy) {
		c.setX(c.getX() + dx);
		c.setY(c.getY() + dy);
	}

	private Point7 c; // centre du cercle
	private float r; // rayon du cercle
}

public class TstCerc {
	public static void main(String args[]) {
		Point7 p = new Point7(3, 5);
		p.affiche();
		Cercle c = new Cercle(1, 2, 5.5f);
		c.affiche();
	}
}
