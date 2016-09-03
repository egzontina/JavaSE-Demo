package chap09_String_Enum;

public class EnumMethode {
	public static void main(String args[]) {
		System.out.println("Noms des valeurs du type jour");
		for (Jour j : Jour.values())
			j.affiche();
	}
}

/*
 * Noms des valeurs du type jour lundi mardi mercredi jeudi vendredi samedi
 * dimanche
 */
