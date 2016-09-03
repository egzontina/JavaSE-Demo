package chap08_Heritage;

class A2 {
	void f() {
		System.out.println("appel f de A2");
	}
}

class B2 extends A2 {
	void f() {
		System.out.println("appel f de B2");
	}

	public void test() { 
	//A2 a = super ;
    //a.f() ;
    super.f() ;
    this.f() ;
  }
}

public class Super {
	public static void main(String args[]) {
		B2 b = new B2();
		b.test();
	}
}
