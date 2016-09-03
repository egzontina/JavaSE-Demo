package chap20_Flux_Fichiers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class CrFichObjet {
	public static void main(String args[]) throws IOException {
		ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream("points.dat"));
		Point p;
		for (int i = 0; i < 5; i++) {
			p = new Point(i, 2 * i);
			sortie.writeInt(i); // envoi de l’entier i sur le flux sortie
			sortie.writeObject(p); // envoi de l’objet p sur le flux sortie
		}
	}
}
