package chap21_Generics;

public class CoupleHerit {
	public static void main(String args[]) {
		Object o1 = null;
		Integer i1 = 5;
		Object o2 = null;
		Integer i2 = 3;
		Couple2<Object> co = new Couple2(o1, o2);
		Couple2<Integer> ci = new Couple2(i1, i2);
		Couple2<?> cq;
		cq = ci;
		//cq.compare(i1);

	}
}

class Couple2<T> {
	private T x, y;

	public Couple2(T premier, T second) {
		x = premier;
		y = second;
	}

	public T getPremier() {
		return x;
	}

	public boolean comparePremier(T tiers) {
		if (x == tiers)
			return true;
		else
			return false;
	}

	public void setPremier(T premier) {
		x = premier;
	}

	public void affiche() {
		System.out.println("premiere valeur : " + x + " - deuxieme valeur : " + y);
	}
}
