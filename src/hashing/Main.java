package hashing;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

	private Stage primaryStage;
	private Pane mainLayout;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Secure Message Digest Generator");
		showMainView();
	}

	private void showMainView() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("GUI.fxml"));
		try {
			mainLayout = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}