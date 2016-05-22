package technichalTest.cpeLyon.ds2.part1;

public abstract class Personnage implements Personnages {

	private String nom;
	protected String boissonFavorite;

	public Personnage(String nom) {
		this.nom = nom;
		this.presentation();
	}

	public void parle(String parole) {
		System.out.println("(" + quel_est_ton_nom() + ") - " + parole);
	}

	public void boit() {
		parle("Gloups !");
	}

	public final void presentation() {
		parle("Bonjour. Je suis " + quel_est_ton_nom() + " et j'aime le " + que_bois_tu() + ".");
		presentationSpecifique();
	}

	protected abstract void presentationSpecifique();

	public String que_bois_tu() {
		return boissonFavorite;
	}

	public String quel_est_ton_nom() {
		return nom;
	}
}
