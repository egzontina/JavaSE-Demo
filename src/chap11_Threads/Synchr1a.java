package chap11_Threads;

import Annexe_Utils.Clavier;

public class Synchr1a {
	public static void main(String args[]) {
		Nombres1 nomb = new Nombres1();
		Thread calc = new ThrChange(nomb);
		Thread aff = new ThrAff1(nomb);
		System.out.println("Suite de carres - tapez retour pour arreter");
		calc.start();
		aff.start();
		Clavier.lireString();
		calc.interrupt();
		aff.interrupt();
	}
}

class Nombres1 {
	public /* synchronized */ void calcul() {
		n++;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		carre = n * n;
	}

	public /* synchronized */ void affiche() {
		System.out.println(n + " a pour carre " + carre);
	}

	private int n = 0, carre;
}

class ThrChange extends Thread {
	public ThrChange(Nombres1 nomb) {
		this.nomb = nomb;
	}

	public void run() {
		try {
			while (!interrupted()) {
				nomb.calcul();
				sleep(50);
			}
		} catch (InterruptedException e) {
		}
	}

	private Nombres1 nomb;
}

class ThrAff1 extends Thread {
	public ThrAff1(Nombres1 nomb) {
		this.nomb = nomb;
	}

	public void run() {
		try {
			while (!interrupted()) {
				nomb.affiche();
				sleep(75);
			}
		} catch (InterruptedException e) {
		}
	}

	private Nombres1 nomb;
}

/*

*/
