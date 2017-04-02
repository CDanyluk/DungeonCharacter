package theGUI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import theDatabase.Build;
import theDatabase.Get;

public class CharacterRun extends Application {

	private Build build;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			build = new Build();
			build.main();
			VBox root = (VBox)FXMLLoader.load(getClass().getResource("SearchAndCreate.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public static void main(String[] args) {launch(args);}
}