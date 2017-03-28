package theGUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LevelController {
	
	@FXML
	Button confirm;
	
	@FXML
	void close() {
		confirm.getScene().getWindow().hide();
	}

}
