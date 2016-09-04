package ITwTest.other.ex5;

import java.io.Serializable;

/**
 * il suffit de l'ins�rer dans un ObjectOutputStream pour qu'il soit
 * automatiquement pris en charge par le m�canisme de s�rialisation standard.
 * Inversement, un ObjectInputStream permet tout aussi facilement de le
 * reconstituer en m�moire � partir de sa forme compress�e.
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
