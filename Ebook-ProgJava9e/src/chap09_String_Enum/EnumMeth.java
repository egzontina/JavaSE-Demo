package chap09_String_Enum;

public class EnumMeth {
	public static void main(String args[]) {
		System.out.println("Noms des valeurs du type jour");
		for (Jour j : Jour.values()) {
			// System.out.println(j + " : " + j.affiche());
		}
	}
}
