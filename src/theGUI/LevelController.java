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

	public void grabStats(Character stats) {
		str.setText(Integer.toString(stats.getStats(Statistics.STRENGTH)));
		dex.setText(Integer.toString(stats.getStats(Statistics.DEXTERITY)));
		intelli.setText(Integer.toString(stats.getStats(Statistics.INTELLIGENCE)));
		wis.setText(Integer.toString(stats.getStats(Statistics.WISDOM)));
		charis.setText(Integer.toString(stats.getStats(Statistics.CHARISMA)));
		
	}
}
