package ITwTest.other.ex4;

public class B extends A {

	public B() {
		x++;
	}

	public B(int i) {
		this();
		x = x + i;
	}

	public B(String s) {
		super();
		x--;
	}

}
