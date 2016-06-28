package chap08_Heritage;

class Point2 {
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void affiche() {
		identifie();
		System.out.println("  Mes coordonnees sont : " + x + " " + y);
	}

	public void identifie() {
		System.out.println("Je suis un point ");
	}

	private int x, y;
}

class Pointcol2 extends Point2 {
	public Pointcol2(int x, int y, byte couleur) {
		super(x, y);
		this.couleur = couleur;
	}

	public void identifie() {
		System.out.println("Je suis un point colore de couleur " + couleur);
	}

	private byte couleur;
}

public class TabHet2 {
	public static void main(String args[]) {
		Point2[] tabPts = new Point2[4];
		tabPts[0] = new Point2(0, 2);
		tabPts[1] = new Pointcol2(1, 5, (byte) 3);
		tabPts[2] = new Pointcol2(2, 8, (byte) 9);
		tabPts[3] = new Point2(1, 2);
		for (int i = 0; i < tabPts.length; i++)
			tabPts[i].affiche();
	}
}
