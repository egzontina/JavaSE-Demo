package chap06_Classe_Object;

import Annexe_Utils.Clavier;

class Util1 {
	public static long fac(long n) {
		if (n > 1)
			return (fac(n - 1) * n);
		else
			return 1;
	}
}

public class TstFac {
	public static void main(String[] args) {
		int n;
		System.out.print("donnez un entier positif : ");
		n = Clavier.lireInt();
		System.out.println("Voici sa factorielle : " + Util1.fac(n));
	}
}
