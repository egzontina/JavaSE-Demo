package chap08_Heritage;

class Point1 {
	public Point1(int x, int y) {
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

class Pointcol extends Point1 {
	public Pointcol(int x, int y, byte couleur) {
		super(x, y); // obligatoirement comme première instruction
		this.couleur = couleur;
	}

	public void affiche() {
		super.affiche();
		System.out.println("  et ma couleur est : " + couleur);
	}

	private byte couleur;
}

public class Poly {
	public static void main(String args[]) {
		Point1 p = new Point1(3, 5);
		p.affiche(); // appelle affiche de Point1
		Pointcol pc = new Pointcol(4, 8, (byte) 2);
		p = pc; // p de type Point1, reference un objet de type Pointcol
		p.affiche(); // on appelle affiche de Pointcol
		p = new Point1(5, 7); // p reference a nouveau un objet de type Point1
		p.affiche(); // on appelle affiche de Point1
	}
}
