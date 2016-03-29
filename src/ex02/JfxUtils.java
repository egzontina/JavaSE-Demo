package ex02;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 * classe utilitaire charger de s’occupe de charger les fichiers  fxml
 * 
 * @author Malick
 * 
 *
 */
public class JfxUtils {
	 
    public static Node loadFxml(String fxml) {
        // Création d’une nouvelle instance de FXMLLoader. C’est elle qui s’occupera du bindinG
    	FXMLLoader loader = new FXMLLoader();
        try {
        	// Chargement du fichier dont le chemin est passé en paramètre
            loader.setLocation(JfxUtils.class.getResource(fxml));
            Node root = (Node) loader.load(Main.class.getResource(fxml).openStream());
            return root;
        } catch (IOException e) {
            throw new IllegalStateException("cannot load FXML screen", e);
        }
    }
}
