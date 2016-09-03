package chap08_Heritage;

// classe de base
class Point01 {
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

// classe derivee de Point01
class Pointcol1 extends Point01 {
	public void colore(byte couleur) {
		this.couleur = couleur;
	}

	private byte couleur;
}

// classe utilisant Pointcol1
public class TstPcol1 {
	public static void main(String args[]) {
		Pointcol1 pc = new Pointcol1();
		pc.affiche();
		pc.initialise(3, 5);
		pc.colore((byte) 3);
		pc.affiche();
		pc.deplace(2, -1);
		pc.affiche();
		Point01 p = new Point01();
		p.initialise(6, 9);
		p.affiche();
	}
}
