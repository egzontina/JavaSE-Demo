package technichalTest.cpeLyon.ds1.part3;

public class Assistant {

	public static double calculMental(Spectateur spectateur) {
		
		System.out.println("[Assistant]" + " (je lis le papier)");
		int age = spectateur.getAge();
		double argentDePoche = spectateur.getArgentDePoche();

		System.out.println("[Assistant]" + " (je calcule mentalement)");
		double resultat = (((age * 2) + 5) * 50) + argentDePoche - 365;

		System.out.println("[Assistant]" + " (J'annonce :" + resultat + "!)");
		
		return resultat;

	}
}
