package technichalTest.other.ex5;

import java.io.Serializable;

/**
 * il suffit de l'insérer dans un ObjectOutputStream pour qu'il soit
 * automatiquement pris en charge par le mécanisme de sérialisation standard.
 * Inversement, un ObjectInputStream permet tout aussi facilement de le
 * reconstituer en mémoire à partir de sa forme compressée.
 * 
 * @author Malick
 *
 */
public class Pojo implements Serializable {

	private final String msg;

	public Pojo(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public String toString() {
		return "Pojo says : " + msg;
	}
}
