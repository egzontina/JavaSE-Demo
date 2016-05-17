package technichalTest.cpeLyon.ds1.part3;

public class Magicien {

	public void TrouverAgeEtSommeEnPoche(Double resultatAnnonce) {
		Double ageEtSomme = resultatAnnonce + 115;
		String chaineAgeEtSomme = ageEtSomme.toString();
		String age = chaineAgeEtSomme.substring(0,1);
		String somme = chaineAgeEtSomme.substring(2);
		System.out.println("hum... je vois que vous avez "+age+" ans et "+somme+" euros en poche !");
	}
}
