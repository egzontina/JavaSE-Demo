package chap20_Flux_Fichiers;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import Annexe_Utils.Clavier;

public class Crsfic1 {
	public static void main(String args[]) throws IOException {
		String nomfich;
		int n;
		System.out.print("donnez le nom du fichier a creer : ");
		nomfich = Clavier.lireString();
		DataOutputStream sortie = new DataOutputStream(new FileOutputStream(nomfich));
		do {
			System.out.print("donnez un entier : ");
			n = Clavier.lireInt();
			if (n != 0) {
				sortie.writeInt(n);
			}
		} while (n != 0);
		sortie.close();
		System.out.println("*** fin creation fichier ***");
	}
}
