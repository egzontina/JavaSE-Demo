package chap28_DesignPattern;

abstract class Logo {
	abstract void affiche();
}

class LogoCercle extends Logo {
	public void affiche() {
		System.out.println("Logo circulaire");
	}
}

class LogoRectangle extends Logo {
	public void affiche() {
		System.out.println("Logo rectangle");
	}
}

/**
 * Interface/classeAbstraite commune des Fabriques
 */
abstract class FabriqueLogo {
	public abstract Logo getLogo();
}

/**
 * Fabrique de Logo choisis au Hasard
 *
 */
class FabriqueLogoHasard extends FabriqueLogo {
	public Logo getLogo() {
		double x = Math.random();
		return (x < 0.5) ? new LogoCercle() : new LogoRectangle(); 
	}
}
/**
 * Fabrique de Logos choisis de façon Aternée
 */
class FabriqueLogoAlternes extends FabriqueLogo {
	public Logo getLogo() {
		if (indic) {
			indic = false;
			return new LogoCercle();
		} else {
			indic = true;
			return new LogoRectangle();
		}
	}

	public static boolean indic = false;
}

/**
 * Main client Class
 * 
 * @author Malick
 *
 */
public class TestFactoryMethod {
	public static void main(String args[]) {
		
		FabriqueLogo fab;
		fab = new FabriqueLogoHasard();
		System.out.println("--- avec Fabrique au hasard");
		for (int i = 0; i < 4; i++) {
			Logo l = fab.getLogo();
			l.affiche();
		}
		
		fab = new FabriqueLogoAlternes();
		System.out.println("\n --- avec Fabrique alternee");
		for (int i = 0; i < 4; i++) {
			Logo l = fab.getLogo();
			l.affiche();
		}
		
	}
}