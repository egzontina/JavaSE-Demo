package ITwTest.ds2.part1;

public class Sherif extends Cowboy implements Sherifs {

	private int mechants_coffres;

	public Sherif(String nom) {
		super(nom);
		qualite = "brave";
		mechants_coffres = 0;
	}

	protected void presentationSpecifique() {
		parle("J'ai d�j� coffr� " + mechants_coffres + " brigands");
	}

	public void coffre(Brigands v) {
		parle("Au nom de la loi, je vous arr�te, " + v.quel_est_ton_nom() + " !");
		v.emprisonne(this);
		mechants_coffres++;
	}

	public void recherche(Brigands b) {
		System.out.println(
				"Le sh�rif " + super.quel_est_ton_nom() + " se mit � placarder une affiche dans toute la ville");
		parle("OYEZ OYEZ BRAVE GENS !! " + b.get_mise_a_prix() + "$ � qui arr�tera " + b.quel_est_ton_nom()
				+ " mort ou vif !!");
	}

	public String quel_est_ton_nom() {
		return "Sh�rif " + super.quel_est_ton_nom();
	}
}
