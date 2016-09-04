package DesignPattern.TemplateMethod.example1;

public class Template1 extends TemplateClass {

	@Override
	protected int etape1() {
		return 2;
	}

	@Override
	protected int etape2() {
		return 5;
	}

}
