package ex02;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Cette classe définit le cycle de vie de l'application
 * 
 * @author Malick
 *
 */
public class Main extends Application {

	/**
	 * l’application affiche, pour un code boursier donnée, le tableau des cinq
	 * derniers jours de cotation ainsi qu’un graphique représentant l’évolution
	 * de l’action sur la durée choisie.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setWidth(1024);
		primaryStage.setHeight(968);
		primaryStage.setTitle("JavaFX Demo 02");
		
//		Group group = new Group();
//		VBox vbox = new VBox();
//		vbox.getChildren().addAll(new Text("Code Java pur"));
//		group.getChildren().add(vbox);
//		primaryStage.setScene(new Scene(group));

		primaryStage.setScene(new Scene((Parent) JfxUtils.loadFxml("Screen.fxml"), 1024, 968));
		
		primaryStage.show();
	}

}
