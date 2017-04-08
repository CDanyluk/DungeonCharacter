package theGUI;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import theDatabase.Build;
import theDatabase.Send;

public class CharacterRun extends Application {

	private Build build;
	private Send send;
	
	@Override
	public void start(Stage primaryStage) {
			
			//preBuild();
			
			VBox root;
			try {
				root = (VBox)FXMLLoader.load(getClass().getResource("SearchAndCreate.fxml"));
				Scene scene = new Scene(root);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				System.out.println("Could not open window!");
				e.printStackTrace();
			}
		
	}
	
	public void preBuild() {
		try {
			build = new Build();
			send = new Send();
			build.main();
			//MOCK CHARACTER CREATION
			send.Send("INSERT INTO Statistics VALUES (214, 1, 14, 10, 16, 9, 8, 10)");
			send.Send("INSERT INTO Attributes VALUES (214, 'Ovi Noir', 'Barbarian', 'Tiefling', 'Outlander', 'Chaotic Good', 'Chantal Danyluk', '0')");
			send.Send("INSERT INTO Skills VALUES (214, 1, 2, -1, 2, -1, -1, 0, 1, 0, -1, 0, -1, 0, 0, -1, 0, 1, 2)");
			send.Send("INSERT INTO Misc VALUES (214, 2, 5, 2, 30, 15, 15, 'Mace', '10 gp')");
				
			send.Send("INSERT INTO Statistics VALUES (000, 0, 0, 0, 0, 30, 30, 30)");
			send.Send("INSERT INTO Attributes VALUES (000, 'The Wise Wizard', 'Wizard', 'Elf', 'Noble', 'Neutral Evil', 'Joe Standard', '0')");
			send.Send("INSERT INTO Skills VALUES (000, -1, -2, 3, -2, 3, 3, 0, -1, 1, 3, 0, 3, 0, 0, 3, 0, -1, -2)");
			send.Send("INSERT INTO Misc VALUES (000, 0, 7, 2, 75, 2, 3, 'Staff of Healing, Robe of Defense', '100 pp')");
				
			send.Send("INSERT INTO Statistics VALUES (368, 1, 8, 9, 25, 12, 15, 13)");
			send.Send("INSERT INTO Attributes VALUES (368, 'Thros Stronghammer', 'Cleric', 'Half-Orc', 'Monk', 'Lawful Neutral', 'Callahan Hirrel', '123')");
			send.Send("INSERT INTO Skills VALUES (368, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2)");
			send.Send("INSERT INTO Misc VALUES (368, 2, 3, 3, 35, 14, 18, 'Holy Water, Sword of Necromancy', '75 gp')");
		} catch (Exception e) {
			System.out.println("Could not insert!");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {launch(args);}
}