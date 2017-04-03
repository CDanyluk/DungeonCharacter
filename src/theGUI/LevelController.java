package theGUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Classes.Character;
import Classes.Statistics;

public class LevelController {
	
	@FXML
	Button confirm;
	@FXML
	Label str;
	@FXML
	Label dex;
	@FXML
	Label intelli;
	@FXML
	Label wis;
	@FXML
	Label charis;
	@FXML
	Button button;
	@FXML
	Label remainingPoints; 
	
	Character character;
	
	@FXML
	void close() {
		confirm.getScene().getWindow().hide();
	}
	
	@FXML
	void incrementAbility() {
		
	}
	
	@FXML
	void decrementAbility() {
		
	}
	
	
	@FXML
	void initialize(Character ch) {
		this.character = ch;
	}
	@FXML
	void populate() {
		// This is set to run when you click the second button on the level up screen, always throws an error
		int s = character.getStats(Statistics.STRENGTH);
		str.setText(s + "");
		//dex.setText(Integer.toString(character.getStats(Statistics.DEXTERITY)));
		//intelli.setText(Integer.toString(character.getStats(Statistics.INTELLIGENCE)));
		//wis.setText(Integer.toString(character.getStats(Statistics.WISDOM)));
		//charis.setText(Integer.toString(character.getStats(Statistics.CHARISMA)));
		
		System.out.println(character.getStats(Statistics.WISDOM));
	}

	public void grabStats(Character stats) {
		character = stats;
	}
}
