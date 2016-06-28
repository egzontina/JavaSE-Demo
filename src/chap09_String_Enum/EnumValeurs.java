package chap09_String_Enum;

public class EnumValeurs {
	public static void main(String args[]) {
		System.out.println("Liste des valeurs du type Jour");
		for (Jour j : Jour.values()) {
			System.out.println(j.toString());
		}
	}
}
/*
 * Liste des valeurs du type Jour lundi mardi mercredi jeudi vendredi samedi
 * dimanche
 * 
 */
