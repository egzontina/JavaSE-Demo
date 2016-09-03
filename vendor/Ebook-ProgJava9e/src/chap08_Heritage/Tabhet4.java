package chap08_Heritage;

interface Affichable4 {
	void affiche();
}

class Entier4 implements Affichable4 {
	public Entier4(int n) {
		valeur = n;
	}

	public void affiche() {
		System.out.println("Je suis un entier de valeur " + valeur);
	}

	private int valeur;
}

class Flottant4 implements Affichable4 {
	public Flottant4(float x) {
		valeur = x;
	}

	public void affiche() {
		System.out.println("Je suis un flottant de valeur " + valeur);
	}

	private float valeur;
}

public class Tabhet4 {
	public static void main(String[] args) {
		Affichable4[] tab;
		tab = new Affichable4[3];
		tab[0] = new Entier4(25);
		tab[1] = new Flottant4(1.25f);
		;
		tab[2] = new Entier4(42);
		int i;
		for (i = 0; i < 3; i++)
			tab[i].affiche();
	}
}
