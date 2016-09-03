package chap11_Threads;

import Annexe_Utils.Clavier;

public class TstThr1 {
	public static void main(String args[]) {
		Ecrit1 e1 = new Ecrit1("bonjour ", 10, 5);
		Ecrit1 e2 = new Ecrit1("bonsoir ", 12, 10);
		Ecrit1 e3 = new Ecrit1("\n", 5, 15);
		e1.start();
		e2.start();
		e3.start();
		Clavier.lireInt();
	}
}

class Ecrit1 extends Thread {
	public Ecrit1(String texte, int nb, long attente) {
		this.texte = texte;
		this.nb = nb;
		this.attente = attente;
	}

	public void run() {
		try {
			for (int i = 0; i < nb; i++) {
				System.out.print(texte);
				sleep(attente);
			}
		} catch (InterruptedException e) {
		} // impose par sleep
	}

	private String texte;
	private int nb;
	private long attente;
}

/*
 * bonjour bonsoir bonjour bonsoir bonjour bonjour bonsoir bonjour bonjour
 * bonsoir bonjour bonjour bonsoir bonjour bonjour bonsoir bonsoir bonsoir
 * bonsoir bonsoir bonsoir bonsoir
 */
