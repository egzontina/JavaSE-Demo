package chap08_Heritage;

class Point03 {
	public Point03(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void deplace(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void affiche() {
		System.out.println("Je suis en " + x + " " + y);
	}

	protected int x, y;
}

class Pointcol03 extends Point03 {
	public Pointcol03(int x, int y, byte couleur) {
		super(x, y); // obligatoirement comme première instruction
		this.couleur = couleur;
	}

	public void affichec() {
		affiche();
		System.out.println("  et ma couleur est : " + couleur);
	}

	private byte couleur;
}

public class TstPcol3 {
	public static void main(String args[]) {
		Pointcol03 pc1 = new Pointcol03(3, 5, (byte) 3);
		pc1.affiche(); // attention, ici affiche
		pc1.affichec(); // et ici affichec

		Pointcol03 pc2 = new Pointcol03(5, 8, (byte) 2);
		pc2.affichec();
		pc2.deplace(1, -3);
		pc2.affichec();
	}
}
