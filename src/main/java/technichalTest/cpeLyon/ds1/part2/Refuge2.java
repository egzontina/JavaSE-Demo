package technichalTest.cpeLyon.ds1.part2;

import java.util.List;

public class Refuge2 {
	
	private List<Animal> listeAnimal;

    private static int nbTotalAmimaux = 0;

	
	// constrcutors 
	
	public Refuge2() {
		
	}
	
	// local method
	
	public int getNombreAnimauxDuRefuge() {
		if(listeAnimal != null && !listeAnimal.isEmpty()) {
			return listeAnimal.size();
		} else {
		return 0;
		}
	}
	
	// getters and setters
	
	public List<Animal> getListeAnimal() {
		return listeAnimal;
	}

	public void setListeAnimal(List<Animal> listeAnimal) {
		this.listeAnimal = listeAnimal;
		nbTotalAmimaux = nbTotalAmimaux + listeAnimal.size();
	}

	public static int getNbTotalAmimaux() {
		return nbTotalAmimaux;
	}

	public static void setNbTotalAmimaux(int nbTotalAmimaux) {
		Refuge2.nbTotalAmimaux = nbTotalAmimaux;
	}
	
}

/*
public void ajouterUnAnimal(Animal nouveauAnimal) {
	this.listeAnimal.add(nouveauAnimal);
	nbTotalAmimaux++;
}
*/
