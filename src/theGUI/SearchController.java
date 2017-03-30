package theGUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SearchController {

	@FXML Button create;
	@FXML Button search;
	@FXML TextField charName;
	@FXML TextField playerName;
	@FXML TextField charClass;
	@FXML TextField charRace;
	@FXML VBox charList;

	/*
	 * Called when the create button is pressed
	 */
	@FXML
	void openCharSheet() {
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
	void search() {
		// gonna need to do database lookups
		// will lookup using all fields which contain text
		// if no fields contain text, display an alert box
		// pull player name, char name, race, and class from each char that fits the search criteria
		// create a label that contains the above info
		// add label to VBox using charList.getChildren.add(newLabel)
		// set label to have a click event which pulls the character sheet of that particular character
		// maybe get a reference to each character sheet before displaying, to access the sheet faster?

	}

}
