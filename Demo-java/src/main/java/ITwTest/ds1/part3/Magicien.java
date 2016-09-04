package ITwTest.ds1.part3;

public class Magicien {

	public static void TrouverAgeEtSommeEnPoche(Spectateur spectateur) {
		System.out.println("[Magicien]" + " un petit tour de magie...");

		System.out.println("[Spectateur]" + " (j'�cris le papier)");
		Double resultatAnnonce = Assistant.calculMental(spectateur);
		
		Double ageEtSomme = resultatAnnonce + 115;
		String chaineAgeEtSomme = ageEtSomme.toString();
		
		String age = chaineAgeEtSomme.substring(0,2);
		String somme = chaineAgeEtSomme.substring(2);
		System.out.println("[Magicien] - hum... je vois que vous avez "+age+" ans et "+somme+" euros en poche !");
	
	}
}
