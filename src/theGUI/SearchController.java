package theGUI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import theDatabase.CharacterFinder;
import Classes.Character;

public class SearchController {

	@FXML Button create;
	@FXML TextField createName;
	@FXML Button search;
	@FXML TextField charName;
	@FXML TextField playerName;
	@FXML TextField charRace;
	@FXML TextField charClass;
	@FXML VBox charList;

	/*
	 * Called when the create button is pressed
	 */

	Character character;

	@FXML
	void openBlankCharSheet() {
		if (createName.getText().equals("")) {
			getError("Please enter a name for your character");
		} else {
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(CharacterRun.class.getResource("CharacterSheet.fxml"));
				//BorderPane root = (BorderPane) loader.load();
				ScrollPane root = (ScrollPane) loader.load();

				CharacterController second = (CharacterController)loader.getController();
				second.name.setText(createName.getText());

				Stage secondStage = new Stage();
				Scene scene = new Scene(root);
				secondStage.setScene(scene);
				secondStage.show();
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	/*
	 * Called when search button is pressed
	 */
	@FXML
	void search() throws ClassNotFoundException {
		// gonna need to do database lookups
		// will lookup using all fields which contain text
		// if no fields contain text, display an alert box
		// pull player name, char name, race, and class from each char that fits the search criteria
		// create a label that contains the above info
		// add label to VBox using charList.getChildren.add(newLabel)
		// set label to have a click event which pulls the character sheet of that particular character
		// maybe get a reference to each character sheet before displaying, to access the sheet faster?
		CharacterFinder cf = new CharacterFinder(charName.getText(), playerName.getText(),
				charRace.getText(), charClass.getText());
		ArrayList<String> characterList = cf.getMatchingCharacters();
		displayCharacters(characterList);

	}

	void displayCharacters(ArrayList<String> charList) {
		if (charList.size() == 0) {
			getError("No characters found!");
		} else {
			for (String character : charList) {
				Label label = new Label(character);
				label.setOnMouseClicked(new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						String charName = character.substring(character.indexOf("Character: ") + 11, character.indexOf(" -"));
						openCharacterSheet(charName);
					}
				});
				this.charList.getChildren().add(label);
			}
		}
	}

	void getError (String msg) {
		Alert alert = new Alert(AlertType.ERROR, msg, ButtonType.OK);
		alert.showAndWait();
	}

	@FXML
	void openCharacterSheet(String charName) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(CharacterRun.class.getResource("CharacterSheet.fxml"));
			//BorderPane root = (BorderPane) loader.load();
			ScrollPane root = (ScrollPane) loader.load();

			CharacterController second = (CharacterController)loader.getController();
			characterSheetSetup(second, charName);

			Stage secondStage = new Stage();
			Scene scene = new Scene(root);
			secondStage.setScene(scene);
			secondStage.show();
		} catch (Exception exc) {
			getError("Error loading character sheet.");
			exc.printStackTrace();
		}
	}

	void characterSheetSetup(CharacterController sheet, String charName) throws ClassNotFoundException, SQLException {
		CharacterFinder cf = new CharacterFinder(charName);
		int ATTRIBUTES_COLUMNS = 8;
		int STATS_COLUMNS = 7;
		int SKILLZ_COLUMNS = 19;
		int MISC_COLUMNS = 8;

		HashMap<String, String> attributes = cf.getCharacterInfoFrom("Attributes", ATTRIBUTES_COLUMNS);
		HashMap<String, String> statistics = cf.getCharacterInfoFrom("Statistics", STATS_COLUMNS);
		HashMap<String, String> skills = cf.getCharacterInfoFrom("Skills", SKILLZ_COLUMNS);
		HashMap misc = cf.getCharacterInfoFrom("Misc", MISC_COLUMNS);

		fillTextFields(attributes, statistics, skills, misc, sheet);

//		sheet.calculateCharisModifier();
		sheet.calculateConstitModifier();
		sheet.calculateDexModifier();
		sheet.calculateIntelliModifier();
		sheet.calculateProficiency();
		sheet.calculateStrModifier();
		sheet.calculateWisModifier();
	}

	void fillTextFields(HashMap<String, String> attributes, HashMap<String, String> statistics, HashMap<String, String> skills,
			HashMap misc, CharacterController sheet) {

		// Attributes
		sheet.name.setText(attributes.get("Name").toString());
		sheet.clas.setText(attributes.get("Class").toString());
		sheet.background.setText(attributes.get("Background").toString());
		sheet.player.setText(attributes.get("PlayerName").toString());
		sheet.race.setText(attributes.get("Race").toString());
		sheet.alignment.setText(attributes.get("Alignment").toString());
		sheet.experience.setText(attributes.get("Experience").toString());

		// Statistics
		sheet.level.setText(statistics.get("Level").toString());
		sheet.strength.setText(statistics.get("Strength").toString());
		sheet.dexterity.setText(statistics.get("Dexterity").toString());
		sheet.constitution.setText(statistics.get("Consitution").toString());
		sheet.intelligence.setText(statistics.get("Intelligence").toString());
		sheet.wisdom.setText(statistics.get("Wisdom").toString());
//		sheet.charisma.setText(statistics.get("Charisma").toString());

		// Skills
		sheet.acrobatics.setText("[" + skills.get("Acrobatics") + "] ACROBATICS");
		sheet.animals.setText("[" + skills.get("Animals") + "] ANIMALS");
		sheet.arcana.setText("[" + skills.get("Arcana") + "] ARCANA");
		sheet.athletics.setText("[" + skills.get("Athletics") + "] ATHLETICS");
		sheet.deception.setText("[" + skills.get("Deception") + "] DECEPTION");
		sheet.history.setText("[" + skills.get("History") + "] HISTORY");
		sheet.insight.setText("[" + skills.get("Insight") + "] INSIGHT");
		sheet.intimidation.setText("[" + skills.get("Intimidation") + "] INTIMIDATION");
		sheet.investigation.setText("[" + skills.get("Investigation") + "] INVESTIGATION");
		sheet.medicine.setText("[" + skills.get("Medicine") + "] MEDICINE");
		sheet.nature.setText("[" + skills.get("Nature") + "] NATURE");
		sheet.perception.setText("[" + skills.get("Perception") + "] PERCEPTION");
		sheet.performance.setText("[" + skills.get("Performance") + "] PERFORMANCE");
		sheet.persuasion.setText("[" + skills.get("Persuasion") + "] PERSUASION");
		sheet.religion.setText("[" + skills.get("Religion") + "] RELIGION");
		sheet.sleight.setText("[" + skills.get("SleightOfHand") + "] SLEIGHT OF HAND");
		sheet.stealth.setText("[" + skills.get("Stealth") + "] STEALTH");
		sheet.survival.setText("[" + skills.get("Survival") + "] SURVIVAL");

		// Misc.
		sheet.proficiency.setText(misc.get("ProficiencyBonus").toString());
		sheet.armor.setText(misc.get("ArmorClass").toString());
		sheet.initiative.setText(misc.get("Initiative").toString());
		sheet.speed.setText(misc.get("Speed").toString());
		sheet.currentHP.setText(misc.get("CurrentHP").toString());
		sheet.totalHP.setText(misc.get("TotalHP").toString());
		sheet.equipment.setText(misc.get("WeaponsAndEquipment").toString());
//		sheet.misc.setText(misc.get("Misc").toString());
	}

}
