package demo.Fxml;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginFXML extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Parent root;
		FXMLLoader loader = new FXMLLoader();
		try {
			root = loader.load(getClass().getResource("LoginFXMLDocument.fxml"));
		} catch (IOException e) {
			throw new IllegalStateException("cannot load FXML screen", e);
		}

		Scene scene = new Scene(root, 300, 275);

		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}

}
