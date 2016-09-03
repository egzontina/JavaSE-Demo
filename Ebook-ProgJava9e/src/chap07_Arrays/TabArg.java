package chap07_Arrays;

public class TabArg {
	public static void main(String args[]) {
		int t[] = { 1, 3, 5, 7 };
		System.out.print("t avant : ");
		Util2.affiche(t);
		Util2.raz(t);
		System.out.print("\nt apres : ");
		Util2.affiche(t);
	}
}

class Util2 {
	static void raz(int t[]) {
		for (int i = 0; i < t.length; i++) // ici for... each pas appicable
			t[i] = 0;
	}

	static void affiche(int t[]) {
		for (int i = 0; i < t.length; i++) // ou (depuis JDK5.0) :
			System.out.print(t[i] + " "); // for (int v : t) System.out.print (v
											// + " ") ;
	}
}
