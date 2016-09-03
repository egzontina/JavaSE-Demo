package technichalTest.cpeLyon.ds2.part1;

public class Sherif extends Cowboy implements Sherifs {

	private int mechants_coffres;

	public Sherif(String nom) {
		super(nom);
		qualite = "brave";
		mechants_coffres = 0;
	}

	protected void presentationSpecifique() {
		parle("J'ai déjà coffré " + mechants_coffres + " brigands");
	}

	public void coffre(Brigands v) {
		parle("Au nom de la loi, je vous arrête, " + v.quel_est_ton_nom() + " !");
		v.emprisonne(this);
		mechants_coffres++;
	}

	public void recherche(Brigands b) {
		System.out.println(
				"Le shérif " + super.quel_est_ton_nom() + " se mit à placarder une affiche dans toute la ville");
		parle("OYEZ OYEZ BRAVE GENS !! " + b.get_mise_a_prix() + "$ à qui arrêtera " + b.quel_est_ton_nom()
				+ " mort ou vif !!");
	}

	public String quel_est_ton_nom() {
		return "Shérif " + super.quel_est_ton_nom();
	}
}
