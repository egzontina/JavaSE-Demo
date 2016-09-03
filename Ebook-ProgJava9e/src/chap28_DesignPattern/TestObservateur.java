package chap28_DesignPattern;
import java.util.*; // pour Observer et Observable

class ObservateurDePoints implements Observer {
	public void update(Observable obj, Object o) // ici o est null
	{
		if (obj instanceof Point1)
			System.out.println(
					"Nouvelle abscisse " + ((Point1) obj).getX() + " dans le point de nom " + ((Point1) obj).getNom());
	}
}

class Point1 extends Observable {
	public Point1(String nom, int x, int y) {
		this.nom = nom;
		this.x = x;
		this.y = y;
	}

	public void deplace(int dx, int dy) {
		x += dx;
		y += dy;
		if (dx != 0)
			setChanged();
		notifyObservers();
	}

	public int getX() {
		return x;
	}

	public String getNom() {
		return nom;
	}

	private int x, y;
	String nom;
}

public class TestObservateur {
	public static void main(String args[]) {
		ObservateurDePoints obs = new ObservateurDePoints();
		Point1 p1 = new Point1("A", 3, 5);
		Point1 p2 = new Point1("B", 2, 2);
		p1.deplace(3, 9); // ici, on n'est pas prevenu
		p1.addObserver(obs); // obs observe maintenant p1
		p1.deplace(2, 8); // ici, on est prevenu pour p1
		p2.deplace(3, 2); // mais pas pour p2
		p2.addObserver(obs); // obs observe maintenant p1 et p2
		p1.deplace(1, 8); // ici, on est prevenu pour p1
		p2.deplace(2, 2); // et pour p2
		p2.deplace(0, 4); // ici, l'abscissse n'a pas change
	}
}