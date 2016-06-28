package chap22_Collections;

import java.util.HashSet;
import java.util.Iterator;

public class EnsPt2 {
	public static void main(String args[]) {
		Point2 p1 = new Point2(1, 3), p2 = new Point2(2, 2);
		Point2 p3 = new Point2(4, 5), p4 = new Point2(1, 8);
		Point2 p[] = { p1, p2, p1, p3, p4, p3 };
		HashSet<Point2> ens = new HashSet<Point2>();
		// HashSet ens=new HashSet() ; <-- avant JDK5.0
		for (Point2 px : p) // for (int i=0 ; i<p.length ; i++) <--
		{
			System.out.print("le point ");
			px.affiche(); // p[i].affiche() ;
			boolean ajoute = ens.add(px); // boolean ajoute = ens.add (p[i]) ;
			if (ajoute)
				System.out.println(" a ete ajoute");
			else
				System.out.println("est deja present");
			System.out.print("ensemble = ");
			affiche(ens);
		}
	}

	public static void affiche(HashSet<Point2> ens)
	// public static void affiche (HashSet ens) <-- avant JDK5.0
	{
		Iterator<Point2> iter = ens.iterator(); // Iterator iter =
												// ens.iterator()
												// ; <--
		while (iter.hasNext()) {
			Point2 p = iter.next(); // Point2 p = (Point2)iter.next() ; <--
			p.affiche();
		}
		System.out.println();
	}
}

class Point2 implements Comparable // ne pas oublier implements ....
{
	Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Object pp) {
		Point2 p = (Point2) pp; // egalite si coordonnees egales
		if (this.x < p.x)
			return -1;
		else if (this.x > p.x)
			return 1;
		else if (this.y < p.y)
			return -1;
		else if (this.y > p.y)
			return 1;
		else
			return 0;
	}

	public void affiche() {
		System.out.print("[" + x + " " + y + "] ");
	}

	private int x, y;
}
