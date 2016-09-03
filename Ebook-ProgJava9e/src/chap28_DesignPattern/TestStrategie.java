package chap28_DesignPattern;
abstract class ModeAffichage {
	public abstract void presente(int x, int y);
}

class AffichageCourt extends ModeAffichage {
	public void presente(int x, int y) {
		System.out.println(x + " " + y);
	}
}

class AffichageLong extends ModeAffichage {
	public void presente(int x, int y) {
		System.out.println("abscisse = " + x + " ordonnee = " + y);
	}
}

class Point3 {
	public Point3(int x, int y, ModeAffichage mode) {
		this.x = x;
		this.y = y;
		this.mode = mode;
	}

	void affiche() {
		mode.presente(x, y);
	}

	private int x, y;
	private ModeAffichage mode; // strategie d'affichage
}

public class TestStrategie {
	public static void main(String args[]) {
		ModeAffichage court = new AffichageCourt();
		Point3 p1 = new Point3(2, 9, court);
		p1.affiche();
		Point3 p2 = new Point3(4, 7, new AffichageLong());
		p2.affiche();
	}
}