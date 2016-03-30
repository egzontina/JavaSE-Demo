package demo2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

/**
 * classe Utilitaires qui s’occupe de charger les fichiers fxml
 */
public class JfxUtils {

    static public Node loadFxml(String fxml) {
        // Création d’une nouvelle instance de FXMLLoader
    	FXMLLoader loader = new FXMLLoader();
        try {
        	// Chargement du fichier dont le chemin est passé en paramètre
            loader.setLocation(Main.class.getResource(fxml));
            Node root = (Node) loader.load(Main.class.getResource(fxml).openStream());
            return root;
        } catch (IOException e) {
            throw new IllegalStateException("cannot load FXML screen", e);
        }
    }


}
