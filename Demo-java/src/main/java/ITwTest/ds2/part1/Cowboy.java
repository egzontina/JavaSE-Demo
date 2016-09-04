package ITwTest.ds2.part1;

public class Cowboy extends Personnage implements Cowboys {

	protected String qualite;

	public Cowboy(String nom) {
		super(nom);
		qualite = "vaillant";
		boissonFavorite = "Whisky";
	}

	protected void presentationSpecifique() {
		parle("Tout le monde dit que je suis " + qualite + ".");
	}

	public void tire(Brigands mechant) {
		System.out
				.println("Le " + qualite + " " + quel_est_ton_nom() + " tire sur " + mechant.quel_est_ton_nom() + ".");
		parle("prend �a, rascal !");
	}

	public void libere(Dames dame) {
		parle("Je vous lib�re " + dame.quel_est_ton_nom() + ".");
		dame.est_liberee(this);
	}
}
