package chap08_Heritage;

class PointXY	 {
	public PointXY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void affiche() {
		System.out.println("Je suis en " + x + " " + y);
	}

	private int x, y;
}

class Pointcol0 extends PointXY {
	public Pointcol0(int x, int y, byte couleur) {
		super(x, y); // obligatoirement comme première instruction
		this.couleur = couleur;
	}

	public void affiche() {
		super.affiche();
		System.out.println("  et ma couleur est : " + couleur);
	}

	private byte couleur;
}

public class TabHeter {
	public static void main(String args[]) {
		PointXY[] tabPts = new PointXY[4];
		tabPts[0] = new PointXY(0, 2);
		tabPts[1] = new Pointcol0(1, 5, (byte) 3);
		tabPts[2] = new Pointcol0(2, 8, (byte) 9);
		tabPts[3] = new PointXY(1, 2);
		for (int i = 0; i < tabPts.length; i++)
			tabPts[i].affiche();
	}
}
