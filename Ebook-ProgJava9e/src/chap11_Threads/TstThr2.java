package chap11_Threads;
public class TstThr2 {
	public static void main(String args[]) {
		Ecrit2 e1 = new Ecrit2("bonjour ", 10, 5);
		Ecrit2 e2 = new Ecrit2("bonsoir ", 12, 10);
		Ecrit2 e3 = new Ecrit2("\n", 5, 15);
		e1.start();
		e2.start();
		e3.start();
	}
}

class Ecrit2 implements Runnable {
	public Ecrit2(String texte, int nb, long attente) {
		this.texte = texte;
		this.nb = nb;
		this.attente = attente;
	}

	public void start() {
		Thread t = new Thread(this);
		t.start();
	}

	public void run() {
		try {
			for (int i = 0; i < nb; i++) {
				System.out.print(texte);
				Thread.sleep(attente);
			}
		} catch (InterruptedException e) {
		} // impose par sleep
	}

	private String texte;
	private int nb;
	private long attente;
}

/*
 * bonjour bonsoir bonjour bonjour bonsoir bonjour bonjour bonsoir bonjour
 * bonjour bonsoir bonjour bonsoir bonjour bonjour bonsoir bonsoir bonsoir
 * bonsoir bonsoir bonsoir bonsoir
 */
