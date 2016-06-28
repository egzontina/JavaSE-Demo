package chap09_String_Enum;

public class EnumMethodes {
	public static void main(String args[]) {
		System.out.println("Noms des valeurs du type jour et leurs abreviations");
		for (Jour1 j : Jour1.values())
			System.out.println(j + " : " + j.abreviation());
	}
}

enum Jour1 {
	lundi("lu"), mardi("ma"), mercredi("me"), jeudi("je"), vendredi("ve"), samdei("sa"), dimanche("di");
	private Jour1(String a) // constructeur ; en argument, l'abreviation
	{
		abrege = a;
	}

	public String abreviation() {
		return abrege;
	}

	private String abrege;
}
/*
 * Noms des valeurs du type jour et leurs abreviations lundi : lu mardi : ma
 * mercredi : me jeudi : je vendredi : ve samdei : sa dimanche : di
 */
