package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
		
	public void start(Stage primaryStage) throws Exception{
		BorderPane root = new FXMLLoader(getClass().getResource("/view/TelaInicial.fxml")).load();
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
