package chap20_Flux_Fichiers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Annexe_Utils.Clavier;

public class Lecftxt1 {
	public static void main(String args[]) throws IOException {
		String nomfich;
		String ligne;
		int n;
		System.out.print("Donnez le nom du fichier a lister : ");
		nomfich = Clavier.lireString();
		BufferedReader entree = new BufferedReader(new FileReader(nomfich));

		do {
			ligne = entree.readLine();
			if (ligne != null)
				System.out.println(ligne);
		} while (ligne != null);
		entree.close();
		System.out.println("*** fin liste fichier ***");
	}
}
