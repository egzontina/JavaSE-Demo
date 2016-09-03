package chap20_Flux_Fichiers;

import java.io.Serializable;

public class Point implements Serializable {

	private int x, y;

	Point(int abs, int ord) {
		x = abs;
		y = ord;
	}

	public void affiche() {
		System.out.println("Coordonnees = " + x + " " + y);
	}

}
