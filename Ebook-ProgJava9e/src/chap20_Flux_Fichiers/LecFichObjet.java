package chap20_Flux_Fichiers;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;


public class LecFichObjet {
	public static void main(String args[]) throws Exception {
		ObjectInputStream entree = new ObjectInputStream(new FileInputStream("points.dat"));
		Point p;
		int num;
		boolean eof = false;
		while (!eof) {
			try {
				num = entree.readInt();
				p = (Point) entree.readObject();
				System.out.print("point numero : " + num + " ; ");
				p.affiche();
			} catch (EOFException e) {
				eof = true;
			}
		}
		entree.close();
	}
}
