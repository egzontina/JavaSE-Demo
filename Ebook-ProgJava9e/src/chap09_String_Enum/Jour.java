package chap09_String_Enum;

public enum Jour {
	lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche;

	public void affiche() {
		System.out.println(this.toString());
	}
}
