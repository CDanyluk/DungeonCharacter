package theGUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CharacterController {
	
	@FXML
	Button levelup;
	@FXML
	Button save;
	
	//Top segment: Attributes
	@FXML
	TextField name;
	@FXML
	TextField clas;
	@FXML
	TextField background;
	@FXML
	TextField player;
	@FXML
	TextField race;
	@FXML
	TextField alignment;
	
	//Statistic
	@FXML
	TextField experience;
	
	//Left segment: Statistics
	@FXML
	TextField strength;
	@FXML
	TextField dexterity;
	@FXML
	TextField constitution;
	@FXML
	TextField intelligence;
	@FXML
	TextField wisdom;
	@FXML
	TextField charisma;
	
	//Right segment
	@FXML
	TextField armor;
	@FXML
	TextField initiative;
	@FXML
	TextField speed;
	//HP handler
	@FXML
	TextField currentHP;
	@FXML
	TextField totalHP;
		
	//TextAreas
	@FXML
	TextArea equipment;
	@FXML
	TextArea misc;
	
	
	
	@FXML
	void open() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(CharacterRun.class.getResource("LevelUp.fxml"));
			Pane root = (Pane)loader.load();

			LevelController second = (LevelController)loader.getController();
			
			Stage secondStage = new Stage();
			Scene scene = new Scene(root);
			secondStage.setScene(scene);
			secondStage.show();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

}
