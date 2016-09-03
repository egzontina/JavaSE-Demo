package chap28_DesignPattern;
abstract class Logo2 {
	abstract void affiche();
}

class LogoCercle2 extends Logo2 {
	public void affiche() {
		System.out.println("Logo2 circulaire");
	}
}

class LogoRectangle2 extends Logo2 {
	public void affiche() {
		System.out.println("Logo2 rectangle");
	}
}

abstract class FabriqueLogo {
	public abstract Logo2 getLogo();
}


class FabriqueLogoAlternes extends FabriqueLogo {
	public Logo2 getLogo() {
		if (indic) {
			indic = false;
			return new LogoCercle2();
		} else {
			indic = true;
			return new LogoRectangle2();
		}
	}

	public static boolean indic = false;
}

public class TestFabrique2 {
	public static void main(String args[]) {
		FabriqueLogo fab;
		fab = new FabriqueLogoHasard2();
		System.out.println("--- avec Fabrique au hasard");
		for (int i = 0; i < 4; i++) {
			Logo2 l = fab.getLogo();
			l.affiche();
		}
		fab = new FabriqueLogoAlternes();
		System.out.println("--- avec Fabrique alternee");
		for (int i = 0; i < 4; i++) {
			Logo2 l = fab.getLogo();
			l.affiche();
		}
	}
}