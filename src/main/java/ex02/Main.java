package ex02;


/**
 * Created by romainn on 11/08/2014.
 */

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
    	// Stage représente la fenêtre principale de notre application
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.setTitle("Malick - JavaFX Demo");
        // chargement de l'interface principale définie par le fxml 
        primaryStage.setScene(new Scene((Parent) JfxUtils.loadFxml("/fxml/ex02/screen.fxml"), 1024, 968));
        primaryStage.show();
    }
}
