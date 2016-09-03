package chap08_Heritage;

abstract class Affichable3 {
	abstract public void affiche();
}

class Entier3 extends Affichable3 {
	public Entier3(int n) {
		valeur = n;
	}

	public void affiche() {
		System.out.println("Je suis un entier de valeur " + valeur);
	}

	private int valeur;
}

class Flottant3 extends Affichable3 {
	public Flottant3(float x) {
		valeur = x;
	}

	public void affiche() {
		System.out.println("Je suis un flottant de valeur " + valeur);
	}

	private float valeur;
}

public class Tabhet3 {
	public static void main(String[] args) {
		Affichable3[] tab;
		tab = new Affichable3[3];
		tab[0] = new Entier3(25);
		tab[1] = new Flottant3(1.25f);
		;
		tab[2] = new Entier3(42);
		int i;
		for (i = 0; i < 3; i++)
			tab[i].affiche();
	}
}
