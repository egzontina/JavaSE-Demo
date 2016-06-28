package chap22_Collections;

import java.util.HashSet;
import java.util.Iterator;

public class EnsPt1 {
	public static void main(String args[]) {
		Point1 p1 = new Point1(1, 3), p2 = new Point1(2, 2);
		Point1 p3 = new Point1(4, 5), p4 = new Point1(1, 8);
		Point1 p[] = { p1, p2, p1, p3, p4, p3 };
		HashSet<Point1> ens = new HashSet<Point1>();
		// HashSet ens=new HashSet() ; <-- avant JDK5.0
		for (Point1 px : p) // for (int i=0 ; i<p.length ; i++) <-- avant JDK5.0
		{
			System.out.print("le point ");
			px.affiche(); // p[i].affiche() ; <-- avant JDK5.0
			boolean ajoute = ens.add(px);
			// boolean ajoute = ens.add (p[i]) ; <-- avant JDK5.0
			if (ajoute)
				System.out.println(" a ete ajoute");
			else
				System.out.println("est deja present");
			System.out.print("ensemble = ");
			affiche(ens);
		}
	}

	public static void affiche(HashSet<Point1> ens)
	// public static void affiche (HashSet ens) <-- avant JDK5.0
	{
		Iterator<Point1> iter = ens.iterator();
		// Iterator iter = ens.iterator() ; <-- avant JDK5.0
		while (iter.hasNext()) {
			Point1 p = iter.next(); // Point1 p = (Point1)iter.next() ; <--
									// avant
									// JDK5.0
			p.affiche();
		}
		System.out.println();
	}
}

class Point1 {
	Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int hashCode() {
		return x + y;
	}

	public boolean equals(Object pp) {
		Point1 p = (Point1) pp;
		return ((this.x == p.x) & (this.y == p.y));
	}

	public void affiche() {
		System.out.print("[" + x + " " + y + "] ");
	}

	private int x, y;
}
