package theGUI;

import javafx.fxml.FXML;



import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import theDatabase.Read;
import theDatabase.Send;
import Classes.Character;
import Classes.Skills;
import Classes.Export;
import Classes.Miscellaneous;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import Classes.Attributes;
import Classes.Statistics;

public class CharacterController {

	@FXML Button levelup;
	@FXML Button save;
	@FXML Button export;

//Top segment: Attributes --------------------------
	@FXML TextField name;
	@FXML TextField clas;
	@FXML TextField background;
	@FXML TextField player;
	@FXML TextField race;
	@FXML TextField alignment;

	@FXML TextField level;
	@FXML TextField proficiency;

//Statistic ----------------------------------------
	@FXML TextField experience;

//Left segment: Statistics--------------------------
@FXML TextField strength;
@FXML Label strengthMod;
@FXML TextField dexterity;
@FXML Label dexterityMod;
@FXML TextField constitution;
@FXML Label constitutionMod;
@FXML TextField intelligence;
@FXML Label intelligenceMod;
@FXML TextField wisdom;
@FXML Label wisdomMod;
@FXML TextField charisma;
@FXML Label charismaMod;

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
	Export exporter;
	private CharacterController iam;

	@FXML
	void initialize() {
		this.character = new Character(this.name.getText());

		send = new Send();

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
	void advlvl() {
		try {
			int lvl = Integer.parseInt(level.getText());
			int str = Integer.parseInt(strength.getText());
			int dex = Integer.parseInt(dexterity.getText());
			int con = Integer.parseInt(constitution.getText());
			int inte = Integer.parseInt(intelligence.getText());
			int wis = Integer.parseInt(wisdom.getText());
			int ch = Integer.parseInt(charisma.getText());

			save();
			levelUpScreen();
			int currentlvl = Integer.parseInt(level.getText());
			level.setText(Integer.toString(currentlvl + 1));

		} catch (Exception exc) {
			getError("Str, dex, con, int, wis, char, or lvl not a number!");
		}

		save();
		levelUpScreen();
		int currentlvl = Integer.parseInt(level.getText());
		level.setText(Integer.toString(currentlvl + 1));
	}

	void levelUpScreen() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(CharacterController.class.getResource("LevelUp.fxml"));
			Pane root = (Pane)loader.load();

			LevelController second = (LevelController)loader.getController();
			second.grabStats(character);

			second.grabController(iam);

			Stage secondStage = new Stage();
			Scene scene = new Scene(root);
			secondStage.setScene(scene);
			secondStage.show();

		} catch (Exception exc) {
			exc.printStackTrace();
			System.out.println("Level Up screen failed");
		}
	}

	@FXML
	void setAttri() {
		if (clas.getText() != "") {
			character.addAttri(Attributes.CLASS, clas.getText());
		}
		if (background.getText() != "") {
			character.addAttri(Attributes.BACKGROUND, background.getText());
		}
		if (player.getText() != "") {
			character.addAttri(Attributes.PLAYER, player.getText());
		}
		if (race.getText() != "") {
			character.addAttri(Attributes.RACE, race.getText());
		}
		if (alignment.getText() != "") {
			character.addAttri(Attributes.ALIGNMENT, alignment.getText());
		}
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

			int lvl = Integer.parseInt(level.getText());
			character.addStats(Statistics.LEVEL, lvl);

		} catch (Exception exc) {
			getError("Str, dex, con, int, wis, char, or exp not a number!");
		}
	}

	@FXML
	void setMisc() {
		//ArmorClass INTEGER, Initiative INTEGER, Speed INTEGER, CurrentHP INTEGER, TotalHP INTEGER,
		//WeaponsAndEquipment TEXT, Misc TEXT

			String ac = armor.getText();
			String ini = initiative.getText();
			String sped = speed.getText();
			String curhp = currentHP.getText();
			String tothp = totalHP.getText();
			String prof = proficiency.getText();
			System.out.println("Hitpoints found to be "+curhp+" out of "+tothp);

			String eq = equipment.getText();
			character.addExtra(Miscellaneous.EQUIPMENT, eq);

			String mis = misc.getText();
			character.addExtra(Miscellaneous.MISC, mis);

		try {
			Integer.parseInt(ac);
			Integer.parseInt(ini);
			Integer.parseInt(sped);
			Integer.parseInt(curhp);
			Integer.parseInt(tothp);
			Integer.parseInt(prof);

			character.addExtra(Miscellaneous.ARMORCLASS, ac);
			character.addExtra(Miscellaneous.INITIATIVE, ini);
			character.addExtra(Miscellaneous.SPEED,  sped);
			character.addExtra(Miscellaneous.CURRENTHP, curhp);
			character.addExtra(Miscellaneous.TOTALHP, tothp);
			character.addExtra(Miscellaneous.PROFICIENCY, prof);

		} catch (Exception e) {
			getError("Armorclass. initiative, speed, or hp must be positive number!");
		}


	}

	@FXML
	void resetStats() {
			int str = character.getStats(Statistics.STRENGTH);
			strength.setText(str+ "");

			int dex = character.getStats(Statistics.DEXTERITY);
			dexterity.setText(dex+ "");

			int con = character.getStats(Statistics.CONSTITUTION);
			constitution.setText(con+ "");

			int inte = character.getStats(Statistics.INTELLIGENCE);
			intelligence.setText(inte + "");

			int wis = character.getStats(Statistics.WISDOM);
			wisdom.setText(wis + "");

			int ch = character.getStats(Statistics.CHARISMA);
			charisma.setText(ch + "");

//			int fullhp = character.getExtra(Miscellaneous.TOTALHP);

	}

	@FXML
	void exportFile() {
		exporter = new Export(character);
		try {
			exporter.main(export.getScene().getWindow());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void calculateStrModifier() {
		try {
			int ability = Integer.parseInt(strength.getText());
			int modifier = (int) Math.floor((ability / 2) - 5);
			strengthMod.setText("(" + modifier + ")");
		} catch (Exception e) {
			strength.setText("");
			getError("Strength must be a positive number!");
		}
	}

	@FXML
	void calculateDexModifier() {
		int ability = Integer.parseInt(dexterity.getText());
		int modifier = (int) Math.floor((ability / 2) - 5);
		dexterityMod.setText("(" + modifier + ")");
	}
	@FXML
	void calculateConstitModifier() {
		int ability = Integer.parseInt(constitution.getText());
		int modifier = (int) Math.floor((ability / 2) - 5);
		constitutionMod.setText("(" + modifier + ")");
	}
	@FXML
	void calculateIntelliModifier() {
		int ability = Integer.parseInt(intelligence.getText());
		int modifier = (int) Math.floor((ability / 2) - 5);
		intelligenceMod.setText("(" + modifier + ")");
	}
	@FXML
	void calculateWisModifier() {
		int ability = Integer.parseInt(wisdom.getText());
		int modifier = (int) Math.floor((ability / 2) - 5);
		wisdomMod.setText("(" + modifier + ")");
	}
	@FXML
	void calculateCharisModifier() {
		int ability = Integer.parseInt(charisma.getText());
		int modifier = (int) Math.floor((ability / 2) - 5);
		charismaMod.setText("(" + modifier + ")");
	}

	@FXML
	void calculateProficiency() {
		int lvl = Integer.parseInt(level.getText());
		if (0 <= lvl && lvl <= 4) {
			proficiency.setText(Integer.toString(2));
		}
		if (5 <= lvl && lvl <= 8) {
			proficiency.setText(Integer.toString(3));
		}
		if (9 <= lvl && lvl <= 12) {
			proficiency.setText(Integer.toString(4));
		}
		if (13 <= lvl && lvl <= 16) {
			proficiency.setText(Integer.toString(5));
		}
		if (17 <= lvl && lvl <= 20) {
			proficiency.setText(Integer.toString(6));
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

	void updateHP () {
		try {
		int curHP = Integer.parseInt(character.getExtra(Miscellaneous.CURRENTHP));
		int totHP = Integer.parseInt(character.getExtra(Miscellaneous.TOTALHP));
		currentHP.setText(Integer.toString(curHP));
		totalHP.setText(Integer.toString(totHP));
		} catch (Exception exc) {
			getError("Please enter a value for both current and total HP. ");
		}
	}

	@FXML
	void save() {
		setAttri();
		setStats();
		setMisc();


		send.SendChar(character);
	}

	@FXML
	void decreaseAcrobatics() {
		character.decreaseSkills(Skills.ACROBATS);
		int change = character.getSkills(Skills.ACROBATS);
		if (change >= 0) {
			acrobatics.setText("[ +" + change + " ]  ACROBATICS");
		}else {
			acrobatics.setText("[ " + change + " ]  ACROBATICS");
		}

	}
	@FXML
	void increaseAcrobatics() {
		character.increaseSkills(Skills.ACROBATS);
		int change = character.getSkills(Skills.ACROBATS);
		if (change >= 0) {
			acrobatics.setText("[ +" + change + " ]  ACROBATICS");
		}else {
			acrobatics.setText("[ " + change + " ]  ACROBATICS");
		}

	}

	@FXML
	void decreaseAnimals() {
		character.decreaseSkills(Skills.ANIMALS);
		int change = character.getSkills(Skills.ANIMALS);
		if (change >= 0) {
			animals.setText("[ +" + change + " ]  ANIMALS");
		}else {
			animals.setText("[ " + change + " ]  ANIMALS");
		}

	}
	@FXML
	void increaseAnimals() {
		character.increaseSkills(Skills.ANIMALS);
		int change = character.getSkills(Skills.ANIMALS);
		if (change >= 0) {
			animals.setText("[ +" + change + " ]  ANIMALS");
		}else {
			animals.setText("[ " + change + " ]  ANIMALS");
		}

	}

	@FXML
	void decreaseArcana() {
		character.decreaseSkills(Skills.ARCANA);
		int change = character.getSkills(Skills.ARCANA);
		if (change >= 0) {
			arcana.setText("[ +" + change + " ]  ARCANA");
		}else {
			arcana.setText("[ " + change + " ]  ARCANA");
		}

	}
	@FXML
	void increaseArcana() {
		character.increaseSkills(Skills.ARCANA);
		int change = character.getSkills(Skills.ARCANA);
		if (change >= 0) {
			arcana.setText("[ +" + change + " ]  ARCANA");
		}else {
			arcana.setText("[ " + change + " ]  ARCANA");
		}

	}

	@FXML
	void decreaseAthletics() {
		character.decreaseSkills(Skills.ATHLETICS);
		int change = character.getSkills(Skills.ATHLETICS);
		if (change >= 0) {
			athletics.setText("[ +" + change + " ]  ATHLETICS");
		}else {
			athletics.setText("[ " + change + " ]  ATHLETICS");
		}

	}
	@FXML
	void increaseAthletics() {
		character.increaseSkills(Skills.ATHLETICS);
		int change = character.getSkills(Skills.ATHLETICS);
		if (change >= 0) {
			athletics.setText("[ +" + change + " ]  ATHLETICS");
		}else {
			athletics.setText("[ " + change + " ]  ATHLETICS");
		}

	}

	@FXML
	void decreaseDeception() {
		character.decreaseSkills(Skills.DECEPTION);
		int change = character.getSkills(Skills.DECEPTION);
		if (change >= 0) {
			deception.setText("[ +" + change + " ]  DECEPTION");
		}else {
			deception.setText("[ " + change + " ]  DECEPTION");
		}

	}
	@FXML
	void increaseDeception() {
		character.increaseSkills(Skills.DECEPTION);
		int change = character.getSkills(Skills.DECEPTION);
		if (change >= 0) {
			deception.setText("[ +" + change + " ]  DECEPTION");
		}else {
			deception.setText("[ " + change + " ]  DECEPTION");
		}

	}

	@FXML
	void decreaseHistory() {
		character.decreaseSkills(Skills.HISTORY);
		int change = character.getSkills(Skills.HISTORY);
		if (change >= 0) {
			history.setText("[ +" + change + " ]  HISTORY");
		}else {
			history.setText("[ " + change + " ]  HISTORY");
		}

	}
	@FXML
	void increaseHistory() {
		character.increaseSkills(Skills.HISTORY);
		int change = character.getSkills(Skills.HISTORY);
		if (change >= 0) {
			history.setText("[ +" + change + " ]  HISTORY");
		}else {
			history.setText("[ " + change + " ]  HISTORY");
		}

	}

	@FXML
	void decreaseInsight() {
		character.decreaseSkills(Skills.INSIGHT);
		int change = character.getSkills(Skills.INSIGHT);
		if (change >= 0) {
			insight.setText("[ +" + change + " ]  INSIGHT");
		}else {
			insight.setText("[ " + change + " ]  INSIGHT");
		}

	}
	@FXML
	void increaseInsight() {
		character.increaseSkills(Skills.INSIGHT);
		int change = character.getSkills(Skills.INSIGHT);
		if (change >= 0) {
			insight.setText("[ +" + change + " ]  INSIGHT");
		}else {
			insight.setText("[ " + change + " ]  INSIGHT");
		}

	}

	@FXML
	void decreaseIntimidation() {
		character.decreaseSkills(Skills.INTIMIDATION);
		int change = character.getSkills(Skills.INTIMIDATION);
		if (change >= 0) {
			intimidation.setText("[ +" + change + " ]  INTIMIDATION");
		}else {
			intimidation.setText("[ " + change + " ]  INTIMIDATION");
		}

	}
	@FXML
	void increaseIntimidation() {
		character.increaseSkills(Skills.INTIMIDATION);
		int change = character.getSkills(Skills.INTIMIDATION);
		if (change >= 0) {
			intimidation.setText("[ +" + change + " ]  INTIMIDATION");
		}else {
			intimidation.setText("[ " + change + " ]  INTIMIDATION");
		}

	}

	@FXML
	void decreaseInvestigation() {
		character.decreaseSkills(Skills.INVESTIGATION);
		int change = character.getSkills(Skills.INVESTIGATION);
		if (change >= 0) {
			investigation.setText("[ +" + change + " ]  INVESTIGATION");
		}else {
			investigation.setText("[ " + change + " ]  INVESTIGATION");
		}

	}
	@FXML
	void increaseInvestigation() {
		character.increaseSkills(Skills.INVESTIGATION);
		int change = character.getSkills(Skills.INVESTIGATION);
		if (change >= 0) {
			investigation.setText("[ +" + change + " ]  INVESTIGATION");
		}else {
			investigation.setText("[ " + change + " ]  INVESTIGATION");
		}

	}

	@FXML
	void decreaseMedicine() {
		character.decreaseSkills(Skills.MEDICINE);
		int change = character.getSkills(Skills.MEDICINE);
		if (change >= 0) {
			medicine.setText("[ +" + change + " ]  MEDICINE");
		}else {
			medicine.setText("[ " + change + " ]  MEDICINE");
		}

	}
	@FXML
	void increaseMedicine() {
		character.increaseSkills(Skills.MEDICINE);
		int change = character.getSkills(Skills.MEDICINE);
		if (change >= 0) {
			medicine.setText("[ +" + change + " ]  MEDICINE");
		}else {
			medicine.setText("[ " + change + " ]  MEDICINE");
		}

	}

	@FXML
	void decreaseNature() {
		character.decreaseSkills(Skills.NATURE);
		int change = character.getSkills(Skills.NATURE);
		if (change >= 0) {
			nature.setText("[ +" + change + " ]  NATURE");
		}else {
			nature.setText("[ " + change + " ]  NATURE");
		}

	}
	@FXML
	void increaseNature() {
		character.increaseSkills(Skills.NATURE);
		int change = character.getSkills(Skills.NATURE);
		if (change >= 0) {
			nature.setText("[ +" + change + " ]  NATURE");
		}else {
			nature.setText("[ " + change + " ]  NATURE");
		}

	}

	@FXML
	void decreasePerception() {
		character.decreaseSkills(Skills.PERCEPTION);
		int change = character.getSkills(Skills.PERCEPTION);
		if (change >= 0) {
			perception.setText("[ +" + change + " ]  PERCEPTION");
		}else {
			perception.setText("[ " + change + " ]  PERCEPTION");
		}

	}
	@FXML
	void increasePerception() {
		character.increaseSkills(Skills.PERCEPTION);
		int change = character.getSkills(Skills.PERCEPTION);
		if (change >= 0) {
			perception.setText("[ +" + change + " ]  PERCEPTION");
		}else {
			perception.setText("[ " + change + " ]  PERCEPTION");
		}

	}

	@FXML
	void decreasePerformance() {
		character.decreaseSkills(Skills.PERFORMANCE);
		int change = character.getSkills(Skills.PERFORMANCE);
		if (change >= 0) {
			performance.setText("[ +" + change + " ]  PERFORMANCE");
		}else {
			performance.setText("[ " + change + " ]  PERFORMANCE");
		}

	}
	@FXML
	void increasePerformance() {
		character.increaseSkills(Skills.PERFORMANCE);
		int change = character.getSkills(Skills.PERFORMANCE);
		if (change >= 0) {
			performance.setText("[ +" + change + " ]  PERFORMANCE");
		}else {
			performance.setText("[ " + change + " ]  PERFORMANCE");
		}

	}

	@FXML
	void decreasePersuasion() {
		character.decreaseSkills(Skills.PERSUASION);
		int change = character.getSkills(Skills.PERSUASION);
		if (change >= 0) {
			persuasion.setText("[ +" + change + " ]  PERSUASION");
		}else {
			persuasion.setText("[ " + change + " ]  PERSUASION");
		}

	}
	@FXML
	void increasePersuasion() {
		character.increaseSkills(Skills.PERSUASION);
		int change = character.getSkills(Skills.PERSUASION);
		if (change >= 0) {
			persuasion.setText("[ +" + change + " ]  PERSUASION");
		}else {
			persuasion.setText("[ " + change + " ]  PERSUASION");
		}

	}


	@FXML
	void decreaseReligion() {
		character.decreaseSkills(Skills.RELIGION);
		int change = character.getSkills(Skills.RELIGION);
		if (change >= 0) {
			religion.setText("[ +" + change + " ]  RELIGION");
		}else {
			religion.setText("[ " + change + " ]  RELIGION");
		}

	}
	@FXML
	void increaseReligion() {
		character.increaseSkills(Skills.RELIGION);
		int change = character.getSkills(Skills.RELIGION);
		if (change >= 0) {
			religion.setText("[ +" + change + " ]  RELIGION");
		}else {
			religion.setText("[ " + change + " ]  RELIGION");
		}

	}

	@FXML
	void decreaseSleight() {
		character.decreaseSkills(Skills.SLEIGHT);
		int change = character.getSkills(Skills.SLEIGHT);
		if (change >= 0) {
			sleight.setText("[ +" + change + " ]  SLEIGHT");
		}else {
			sleight.setText("[ " + change + " ]  SLEIGHT");
		}

	}
	@FXML
	void increaseSleight() {
		character.increaseSkills(Skills.SLEIGHT);
		int change = character.getSkills(Skills.SLEIGHT);
		if (change >= 0) {
			sleight.setText("[ +" + change + " ]  SLEIGHT");
		}else {
			sleight.setText("[ " + change + " ]  SLEIGHT");
		}

	}

	@FXML
	void decreaseStealth() {
		character.decreaseSkills(Skills.STEALTH);
		int change = character.getSkills(Skills.STEALTH);
		if (change >= 0) {
			stealth.setText("[ +" + change + " ]  STEALTH");
		}else {
			stealth.setText("[ " + change + " ]  STEALTH");
		}

	}
	@FXML
	void increaseStealth() {
		character.increaseSkills(Skills.STEALTH);
		int change = character.getSkills(Skills.STEALTH);
		if (change >= 0) {
			stealth.setText("[ +" + change + " ]  STEALTH");
		}else {
			stealth.setText("[ " + change + " ]  STEALTH");
		}

	}

	@FXML
	void decreaseSurvival() {
		character.decreaseSkills(Skills.SURVIVAL);
		int change = character.getSkills(Skills.SURVIVAL);
		if (change >= 0) {
			survival.setText("[ +" + change + " ]  SURVIVAL");
		}else {
			survival.setText("[ " + change + " ]  SURVIVAL");
		}

	}
	@FXML
	void increaseSurvival() {
		character.increaseSkills(Skills.SURVIVAL);
		int change = character.getSkills(Skills.SURVIVAL);
		if (change >= 0) {
			survival.setText("[ +" + change + " ]  SURVIVAL");
		}else {
			survival.setText("[ " + change + " ]  SURVIVAL");
		}

	}


	//----WIP-----

	void getError (String msg) {
		Alert alert = new Alert(AlertType.ERROR, msg, ButtonType.OK);
		alert.showAndWait();
	}

	public void testMethod() {
		System.out.println("Wuppee, it worked");

	}

	public void whoami(CharacterController second) {
		iam = second;

	}



}
