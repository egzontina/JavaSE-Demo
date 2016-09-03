package chap28_DesignPattern;

public class FabriqueLogoHasard2 extends FabriqueLogo {
	public Logo2 getLogo() {
		double x = Math.random();
		if (x < 0.5)
			return new LogoCercle2();
		else
			return new LogoRectangle2();
	}
}
