package technichalTest.cpeLyon.ds2.part1;

public class Barman extends Personnage implements Barmans {

	private String bar;

	public Barman(String nom, String bar) {
		super(nom);
		this.bar = bar;
		boissonFavorite = "Vin";
	}

	public Barman(String nom) {
		this(nom, "Chez " + nom);
	}

	public void sert(Personnages h) {
		parle("Tiens " + h.quel_est_ton_nom() + ". Voilà un bon verre de " + h.que_bois_tu() + ".");
		h.boit();
	}

	protected void presentationSpecifique() {
		parle("Je suis barman au bar " + bar + ".");
	}

	public void parle(String parole) {
		System.out.println("(" + quel_est_ton_nom() + ") - " + parole + " Mon gars.");
	}

	public String quel_est_ton_nom() {
		return "Barman " + super.quel_est_ton_nom();
	}
}
