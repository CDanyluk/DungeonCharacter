package theGUI;

import javafx.fxml.FXML;



import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import theDatabase.Send;
import Classes.Character;
import Classes.Skills;

import java.sql.Connection;
import java.sql.DriverManager;

import Classes.Attributes;
import Classes.Statistics;

public class CharacterController {

	@FXML Button levelup;
	@FXML Button save;

//Top segment: Attributes --------------------------
	@FXML TextField name;
	@FXML TextField clas;
	@FXML TextField background;
	@FXML TextField player;
	@FXML TextField race;
	@FXML TextField alignment;

//Statistic ----------------------------------------
	@FXML TextField experience;

//Left segment: Statistics--------------------------
	@FXML TextField strength;
	@FXML TextField dexterity;
	@FXML TextField constitution;
	@FXML TextField intelligence;
	@FXML TextField wisdom;
	@FXML TextField charisma;

//Saving throws ------------------------------------
	@FXML Label savingstr;
	@FXML Button strup;
	@FXML Button strdown;

	@FXML Label savingdex;
	@FXML Button dexup;
	@FXML Button dexdown;

	@FXML Label savingcon;
	@FXML Button conup;
	@FXML Button condown;

	@FXML Label savingint;
	@FXML Button intup;
	@FXML Button intdown;

	@FXML Label savingwis;
	@FXML Button wisup;
	@FXML Button wisdown;

	@FXML Label savingchar;
	@FXML Button charup;
	@FXML Button chardown;

//Right segment ------------------------------------
	@FXML TextField armor;
	@FXML TextField initiative;
	@FXML TextField speed;
	//HP handler
	@FXML TextField currentHP;
	@FXML TextField totalHP;

	@FXML TextArea equipment;
	@FXML TextArea misc;

	@FXML ProgressBar HP;
	@FXML Button recalculate;

//Skills -------------------------------------------
	@FXML Label acrobatics;
	@FXML Button acrobaticsup;
	@FXML Button acrobaticsdown;

	@FXML Label animals;
	@FXML Button animalsup;
	@FXML Button animalsdown;

	@FXML Label arcana;
	@FXML Button arcanaup;
	@FXML Button arcanadown;

	@FXML Label athletics;
	@FXML Button athleticsup;
	@FXML Button athleticsdown;

	@FXML Label deception;
	@FXML Button deceptionup;
	@FXML Button deceptiondown;

	@FXML Label history;
	@FXML Button historyup;
	@FXML Button historydown;

	@FXML Label insight;
	@FXML Button insightup;
	@FXML Button insightdown;

	@FXML Label intimidation;
	@FXML Button intimidationup;
	@FXML Button intimidationdown;

	@FXML Label investigation;
	@FXML Button investigationup;
	@FXML Button investigationdown;

	@FXML Label medicine;
	@FXML Button medicineup;
	@FXML Button medicinedown;

	@FXML Label nature;
	@FXML Button natureup;
	@FXML Button naturedown;

	@FXML Label perception;
	@FXML Button perceptionup;
	@FXML Button perceptiondown;

	@FXML Label performance;
	@FXML Button performanceup;
	@FXML Button performancedown;

	@FXML Label persuasion;
	@FXML Button persuasionup;
	@FXML Button persuasiondown;

	@FXML Label religion;
	@FXML Button religionup;
	@FXML Button religiondown;

	@FXML Label sleight;
	@FXML Button sleightup;
	@FXML Button sleightdown;

	@FXML Label stealth;
	@FXML Button stealthup;
	@FXML Button stealthdown;

	@FXML Label survival;
	@FXML Button survivalup;
	@FXML Button survivaldown;
//----------------------------------------------------------------

	Character character;
	Send send;
	

	@FXML
	void initialize() {
		character = new Character((name.getText()));
		send = new Send();
		try {
			send.Send("INSERT INTO Statistics VALUES (214, 0, 0, 0, 0, 0, 0, 0)");
		} catch (Exception e) {
			System.out.println("Could not set character stats");
		}
		character.setSkills(Skills.ACROBATS, 0);
		character.setSkills(Skills.ANIMALS, 0);
		character.setSkills(Skills.ARCANA, 0);
		character.setSkills(Skills.ATHLETICS, 0);
		character.setSkills(Skills.DECEPTION, 0);
		character.setSkills(Skills.HISTORY, 0);
		character.setSkills(Skills.INSIGHT, 0);
		character.setSkills(Skills.INTIMIDATION, 0);
		character.setSkills(Skills.INVESTIGATION, 0);
		character.setSkills(Skills.MEDICINE, 0);
		character.setSkills(Skills.NATURE, 0);
		character.setSkills(Skills.PERCEPTION, 0);
		character.setSkills(Skills.PERFORMANCE, 0);
		character.setSkills(Skills.PERSUASION, 0);
		character.setSkills(Skills.RELIGION, 0);
		character.setSkills(Skills.SLEIGHT, 0);
		character.setSkills(Skills.STEALTH, 0);
		character.setSkills(Skills.SURVIVAL, 0);
	}

	@FXML
	void open() {
		try {
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
			openLevel();
		} catch (Exception exc) {
			getError("Str, dex, con, int, wis, char, or exp not a number!");
		}
	}
	
	void openLevel() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(CharacterRun.class.getResource("LevelUp.fxml"));
			Pane root = (Pane)loader.load();

			LevelController second = (LevelController)loader.getController();
			second.initialize(character);

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
		try {
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

		} catch (Exception exc) {
			getError("Str, dex, con, int, wis, char, or exp not a number!");
		}
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
		String currHP = currentHP.getText();
		String totHP = totalHP.getText();
		try {
			double current = Integer.parseInt(currentHP.getText());
			double total = Integer.parseInt(totalHP.getText());
			HP.setProgress(current/total);
		} catch (Exception exc) {
			getError("HP not number!");
		}
	}

	@FXML
	void save() {
		setAttri();
		setStats();
	}

	@FXML
	void decreaseAcrobatics() {
		character.decreaseSkills(Skills.ACROBATS);
		int change = character.getSkills(Skills.ACROBATS);
		if (change >= 0) {
			acrobatics.setText("[ +" + change + " ]  ACROBATICS");
		}else {
			acrobatics.setText("[ -" + change + " ]  ACROBATICS");
		}
	}
	@FXML
	void increaseAcrobatics() {
		character.increaseSkills(Skills.ACROBATS);
		int change = character.getSkills(Skills.ACROBATS);
		if (change >= 0) {
			acrobatics.setText("[ +" + change + " ]  ACROBATICS");
		}else {
			acrobatics.setText("[ -" + change + " ]  ACROBATICS");
		}
	}

	@FXML
	void decreaseAnimals() {
		character.decreaseSkills(Skills.ANIMALS);
		int change = character.getSkills(Skills.ANIMALS);
		if (change >= 0) {
			acrobatics.setText("[ +" + change + " ]  ANIMALS");
		}else {
			acrobatics.setText("[ -" + change + " ]  ANIMALS");
		}
	}

	@FXML
	void increaseAnimals() {
		character.increaseSkills(Skills.ANIMALS);
		int change = character.getSkills(Skills.ANIMALS);
		if (change >= 0) {
			animals.setText("[ +" + change + " ]  ANIMALS");
		}else {
			animals.setText("[ -" + change + " ]  ANIMALS");
		}
	}
	
	@FXML
	void decreaseArcana() {
		character.decreaseSkills(Skills.ARCANA);
		int change = character.getSkills(Skills.ARCANA);
		if (change >= 0) {
			arcana.setText("[ +" + change + " ]  ARCANA");
		}else {
			arcana.setText("[ -" + change + " ]  ARCANA");
		}
	}
	@FXML
	void increaseArcana() {
		character.increaseSkills(Skills.ARCANA);
		int change = character.getSkills(Skills.ARCANA);
		if (change >= 0) {
			arcana.setText("[ +" + change + " ]  ARCANA");
		}else {
			arcana.setText("[ -" + change + " ]  ARCANA");
		}
	}
	
	@FXML
	void decreaseAthletics() {
		character.decreaseSkills(Skills.ATHLETICS);
		int change = character.getSkills(Skills.ATHLETICS);
		if (change >= 0) {
			athletics.setText("[ +" + change + " ]  ATHLETICS");
		}else {
			athletics.setText("[ -" + change + " ]  ATHLETICS");
		}
	}
	@FXML
	void increaseAthletics() {
		character.increaseSkills(Skills.ATHLETICS);
		int change = character.getSkills(Skills.ATHLETICS);
		if (change >= 0) {
			athletics.setText("[ +" + change + " ]  ATHLETICS");
		}else {
			athletics.setText("[ -" + change + " ]  ATHLETICS");
		}
	}
	
	@FXML
	void decreaseDeception() {
		character.decreaseSkills(Skills.DECEPTION);
		int change = character.getSkills(Skills.DECEPTION);
		if (change >= 0) {
			deception.setText("[ +" + change + " ]  DECEPTION");
		}else {
			deception.setText("[ -" + change + " ]  DECEPTION");
		}
	}
	@FXML
	void increaseDeception() {
		character.increaseSkills(Skills.DECEPTION);
		int change = character.getSkills(Skills.DECEPTION);
		if (change >= 0) {
			deception.setText("[ +" + change + " ]  DECEPTION");
		}else {
			deception.setText("[ -" + change + " ]  DECEPTION");
		}
	}
	
	@FXML
	void decreaseHistory() {
		character.decreaseSkills(Skills.HISTORY);
		int change = character.getSkills(Skills.HISTORY);
		if (change >= 0) {
			history.setText("[ +" + change + " ]  HISTORY");
		}else {
			history.setText("[ -" + change + " ]  HISTORY");
		}
	}
	@FXML
	void increaseHistory() {
		character.increaseSkills(Skills.HISTORY);
		int change = character.getSkills(Skills.HISTORY);
		if (change >= 0) {
			history.setText("[ +" + change + " ]  HISTORY");
		}else {
			history.setText("[ -" + change + " ]  HISTORY");
		}
	}
	
	
	

	//----WIP-----

	void getError (String msg) {
		Alert alert = new Alert(AlertType.ERROR, msg, ButtonType.OK);
		alert.showAndWait();
	}



}
