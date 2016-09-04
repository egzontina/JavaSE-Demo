package ITwTest.ds2.part1;

public class Barman extends Personnage implements Barmans {

	private String bar;

	/** CORRECTION Q3 : modification la r�f�rence au constructeur m�re  */
	public Barman(String nom, String bar) {
		super(nom, "vin"); // appelle le constructeur de la classe m�re  
		this.bar = bar;
		// boissonFavorite = "Vin";
		presentationSpecifique();

	}

	public Barman(String nom) {
		this(nom, "Chez " + nom);
	}

	public void sert(Personnages h) {
		parle("Tiens " + h.quel_est_ton_nom() + ". Voil� un bon verre de " + h.que_bois_tu() + ".");
		h.boit();
	}

	protected void presentationSpecifique() {
		parle("Je suis barman au bar [" + this.bar + "].");
	}

	public void parle(String parole) {
		System.out.println("(" + quel_est_ton_nom() + ") - " + parole + " Mon gars.");
	}

	public String quel_est_ton_nom() {
		return "Barman " + super.quel_est_ton_nom();
	}
	
	
}
