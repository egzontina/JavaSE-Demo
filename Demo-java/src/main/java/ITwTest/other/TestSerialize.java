package ITwTest.other;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 
/**
 * La classe ci-dessous montre l'utilisation de l'API java.io pour s�rialiser ou d�-s�rialiser un objet sous la forme d'un tableau de bytes.
 * @author Malick
 *
 * @author Malick
 * 
 * @see http://thecodersbreakfast.net/index.php?post/2011/05/07/Serializing-non-serializable-objects
 *
 */
public class TestSerialize {

	public static void main(String[] args) throws Exception {
		
		Pojo pojo = new Pojo("Hello world"); // The original object
		byte[] pojoBytes = serialize(pojo); // Serialize
		Pojo pojo2 = (Pojo) deserialize(pojoBytes); // Deserialize
		System.out.println(pojo); // Good as new !
	}
	
	public static byte[] serialize(Object o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(baos);
        os.writeObject(o);
        os.flush();
        os.close();
        return baos.toByteArray();
    }
 
    public static Object deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        bais.close();
        return o;
    }
}

/**
 * il suffit de l'insérer dans un ObjectOutputStream pour qu'il soit
 * automatiquement pris en charge par le m�canisme de s�rialisation standard.
 * Inversement, un ObjectInputStream permet tout aussi facilement de le
 * reconstituer en m�moire � partir de sa forme compress�e.
 * 
 * @author Malick
 *
 */
class Pojo implements Serializable {

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
