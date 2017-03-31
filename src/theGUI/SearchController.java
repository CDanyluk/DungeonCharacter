package theGUI;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import theDatabase.CharacterFinder;

public class SearchController {

	@FXML Button create;
	@FXML Button search;
	@FXML TextField charName;
	@FXML TextField playerName;
	@FXML TextField charRace;
	@FXML TextField charClass;
	@FXML VBox charList;

	/*
	 * Called when the create button is pressed
	 */
	@FXML
	void openBlankCharSheet() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(CharacterRun.class.getResource("CharacterSheet.fxml"));
			BorderPane root = (BorderPane) loader.load();

			CharacterController second = (CharacterController)loader.getController();

			Stage secondStage = new Stage();
			Scene scene = new Scene(root);
			secondStage.setScene(scene);
			secondStage.show();
		} catch (Exception exc) {
			exc.printStackTrace();
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
		ArrayList<String> characterList = cf.searchDatabase();
		displayCharacters(characterList);

	}

	void displayCharacters(ArrayList<String> charList) {
		if (charList.size() == 0) {
			getError("No characters found!");
		} else {
			for (String character : charList) {
				Label label = new Label(character);
				// TODO
				// label.onMouseClickedProperty() = openCharacterSheet();
				this.charList.getChildren().add(label);
			}
		}
	}

	void getError (String msg) {
		Alert alert = new Alert(AlertType.ERROR, msg, ButtonType.OK);
		alert.showAndWait();
	}

//	@FXML
//	void openCharacterSheet() {
//
//	}

}
