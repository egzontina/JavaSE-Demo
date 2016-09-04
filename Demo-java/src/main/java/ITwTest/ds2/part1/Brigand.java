package ITwTest.ds2.part1;

import java.util.LinkedList;
import java.util.List;

public class Brigand extends Personnage implements Brigands {
	
	private String look;
	private List<Dames> dame_enlevees;
	private boolean en_prison;
	private int mise_a_prix;

	public Brigand(String nom) {
		super(nom);
		dame_enlevees = new LinkedList<Dames>();
		mise_a_prix = 100;
		look = "m�chant";
		boissonFavorite = "Tord Boyaux";
		en_prison = false;
	}

	public void emprisonne(Cowboys c) {
		en_prison = true;
		parle("Damned, je suis fait ! " + c.quel_est_ton_nom() + ", tu m'as eu !");
	}

	public void kidnappe(Dames dame) {
		System.out.println("Oh mon Dieu ! " + quel_est_ton_nom() + " a enlev� " + dame.quel_est_ton_nom() + " !!");
		parle("Ah ah ! " + dame.quel_est_ton_nom() + ", vous �tes mienne d�sormais !");
		dame.est_kidnappee();
		dame_enlevees.add(dame);
		mise_a_prix += 100;
	}

	public int get_mise_a_prix() {
		return mise_a_prix;
	}

	protected void presentationSpecifique() {
		parle("J'ai l'air " + look + " et ma t�te est mise � prix " + mise_a_prix + "$ !!");
	}

	public String quel_est_ton_nom() {
		return "Brigand " + super.quel_est_ton_nom();
	}

	public List<Dames> getDame_enlevees() {
		return dame_enlevees;
	}
}
