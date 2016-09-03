package chap08_Heritage;

// classe de base
class Point02 {
	public void initialise(int abs, int ord) {
		x = abs;
		y = ord;
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

// classe derivee de Point02
class Pointcol02 extends Point02 {
	public void colore(byte couleur) {
		this.couleur = couleur;
	}

	public void affichec() {
		affiche();
		System.out.println("  et ma couleur est : " + couleur);
	}

	public void initialisec(int x, int y, byte couleur) {
		initialise(x, y);
		this.couleur = couleur;
	}

	private byte couleur;
}

// classe utilisant Pointcol02
public class TstPcol2 {
	public static void main(String args[]) {
		Pointcol02 pc1 = new Pointcol02();
		pc1.initialise(3, 5);
		pc1.colore((byte) 3);
		pc1.affiche(); // attention, ici affiche
		pc1.affichec(); // et ici affichec

		Pointcol02 pc2 = new Pointcol02();
		pc2.initialisec(5, 8, (byte) 2);
		pc2.affichec();
		pc2.deplace(1, -3);
		pc2.affichec();
	}
}
