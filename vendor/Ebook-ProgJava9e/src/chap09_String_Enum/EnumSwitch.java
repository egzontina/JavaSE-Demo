package chap09_String_Enum;

public class EnumSwitch {
	public static void main(String args[]) {
		Jour courant;
		courant = Jour.vendredi;
		switch (courant) {
		case lundi: // attention Jour.lundi serait une erreur
		case mardi:
		case mercredi:
		case jeudi:
			System.out.println("On bosse");
			break;
		case vendredi:
			System.out.println("Bientot le we");
			break;
		case samedi:
		case dimanche:
			System.out.println("c'est le week end");
		}
	}
}
/*
 * Bientot le we
 */
