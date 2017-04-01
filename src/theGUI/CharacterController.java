package theGUI;

import javafx.fxml.FXML;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Classes.Character;
import Classes.Attributes;
import Classes.Statistics;

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
	
	//Saving throws
	@FXML
	Label savingstr;
	@FXML
	Button strup;
	@FXML
	Button strdown;
	
	@FXML
	Label savingdex;
	@FXML
	Button dexup;
	@FXML
	Button dexdown;
	
	@FXML
	Label savingcon;
	@FXML
	Button conup;
	@FXML
	Button condown;
	
	@FXML
	Label savingint;
	@FXML
	Button intup;
	@FXML
	Button intdown;
	
	@FXML
	Label savingwis;
	@FXML
	Button wisup;
	@FXML
	Button wisdown;
	
	@FXML
	Label savingchar;
	@FXML
	Button charup;
	@FXML
	Button chardown;
	
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
	ProgressBar HP;
	@FXML
	Button recalculate;
	
//----------------------------------------------------------------
	
	Character character;
	
	@FXML
	void initialize() {
		character = new Character((name.getText()));
	}

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
	
	@FXML
	void setAttri() {
		character.addAttri(Attributes.CLASS, clas.getText());
		character.addAttri(Attributes.BACKGROUND, background.getText());
		character.addAttri(Attributes.PLAYER, player.getText());
		character.addAttri(Attributes.RACE, race.getText());
		character.addAttri(Attributes.ALIGNMENT, alignment.getText());
	}
	
	@FXML
	void setStats() {
		int exp = Integer.parseInt(experience.getText());
		character.addStats(Statistics.EXPERIENCE, exp);

		int str = Integer.parseInt(strength.getText());
		character.addStats(Statistics.STRENGTH, str);

		int dex = Integer.parseInt(dexterity.getText());
		character.addStats(Statistics.DEXTERITY, dex);

		int con = Integer.parseInt(constitution.getText());
		character.addStats(Statistics.CONSTITUTION, con);

		int inte = Integer.parseInt(intelligence.getText());
		character.addStats(Statistics.INTELLIGENCE, inte);

		int wis = Integer.parseInt(wisdom.getText());
		character.addStats(Statistics.WISDOM, wis);

		int ch = Integer.parseInt(charisma.getText());
		character.addStats(Statistics.CHARISMA, ch);
	}
	
	@FXML
	void increaseStr() {
		String original = savingstr.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next < 9) {
			next++;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingstr.setText(original);
	}
	
	@FXML
	void increaseDex() {
		String original = savingdex.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next < 9) {
			next++;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingdex.setText(original);
	}
	
	@FXML
	void increaseCon() {
		String original = savingcon.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next < 9) {
			next++;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingcon.setText(original);
	}
	
	@FXML
	void increaseInt() {
		String original = savingint.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next < 9) {
			next++;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingint.setText(original);
	}
	
	@FXML
	void increaseWis() {
		String original = savingwis.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next < 9) {
			next++;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingwis.setText(original);
	}
	
	@FXML
	void increaseChar() {
		String original = savingchar.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next < 9) {
			next++;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingchar.setText(original);
	}
	
	@FXML
	void decreaseStr() {
		String original = savingstr.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next > 0) {
			next--;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingstr.setText(original);
	}
	
	@FXML
	void decreaseDex() {
		String original = savingdex.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next > 0) {
			next--;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingdex.setText(original);
	}
	
	@FXML
	void decreaseCon() {
		String original = savingcon.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next > 0) {
			next--;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingcon.setText(original);
	}
	
	@FXML
	void decreaseInt() {
		String original = savingint.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next > 0) {
			next--;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingint.setText(original);
	}
	
	@FXML
	void decreaseWis() {
		String original = savingwis.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next > 0) {
			next--;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingwis.setText(original);
	}
	
	@FXML
	void decreaseChar() {
		String original = savingchar.getText();
		char ch = original.charAt(3);
		int next = Integer.parseInt(ch+ "");
		if (next > 0) {
			next--;
			char b = (char)('0' + next);
			original = original.replace(ch, b);
		}
		savingchar.setText(original);
	}
	
	@FXML
	void setHP() {
		double current = Integer.parseInt(currentHP.getText());
		double total = Integer.parseInt(totalHP.getText());
		HP.setProgress(current/total);
	}
	
	
	
	

}
