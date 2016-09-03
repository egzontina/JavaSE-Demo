package TemplateMethod.example1;

public abstract class TemplateClass {

	public double templateMethod() {

		double somme = 0;

		int a = etape1();

		for (int i = 0; i < a; i++) {
			somme += etape2();
		}
		return somme;
	}

	
	protected abstract int etape1();

	protected abstract int etape2();

}
