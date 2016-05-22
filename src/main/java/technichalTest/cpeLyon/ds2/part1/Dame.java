package technichalTest.cpeLyon.ds2.part1;

public class Dame extends Personnage implements Dames {

	private boolean enlevee;

	public Dame(String nom) {
		super(nom);
		boissonFavorite = "thé";
	}

	public void est_kidnappee() {
		enlevee = true;
		parle("AAAHHH !");

	}

	public void est_liberee(Cowboys g) {
		enlevee = false;
		parle("Oh mon héros ! " + g.quel_est_ton_nom() + ", je vous aime !");
	}

	public String quel_est_ton_nom() {
		return "Miss " + super.quel_est_ton_nom();
	}

	protected void presentationSpecifique() {
	}
}
