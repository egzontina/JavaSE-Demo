package chap06_Classe_Object;

class Obj2 {
	public Obj2() {
		System.out.print("++ creation objet Obj2 ; ");
		nb++;
		System.out.println("il y en a maintenant " + nb);
	}

	public static long nbObj() {
		return nb;
	}

	private static long nb = 0;
}

public class TstObj2 {
	public static void main(String args[]) {
		Obj2 a;
		System.out.println("Main 1 : nb objets = " + Obj2.nbObj());
		a = new Obj2();
		System.out.println("Main 2 : nb objets = " + Obj2.nbObj());
		Obj2 b;
		System.out.println("Main 3 : nb objets = " + Obj2.nbObj());
		b = new Obj2();
		Obj2 c = new Obj2();
		System.out.println("Main 4 : nb objets = " + Obj2.nbObj());
	}
}
