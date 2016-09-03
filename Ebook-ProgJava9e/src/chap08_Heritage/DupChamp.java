package chap08_Heritage;

class A1 {
	public int n = 4;
}

class B1 extends A1 {
	public float n = 4.5f;
}

public class DupChamp {
	public static void main(String[] args) {
		A1 a = new A1();
		B1 b = new B1();
		System.out.println("a.n = " + a.n);
		System.out.println("b.n = " + b.n);
	}
}
