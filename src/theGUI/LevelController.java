package theGUI;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

import javax.swing.GroupLayout.Alignment;

import Classes.Character;
import Classes.Statistics;
import Classes.Miscellaneous;

public class LevelController {
	
	int state = 1;
	@FXML
	Button confirm;
	@FXML
	Label str;
	int startingStr;
	@FXML
	Label dex;
	int startingDex;
	@FXML
	Label intelli;
	int startingIntelli;
	@FXML
	Label wis;
	int startingWis;
	@FXML
	Label charis;
	int startingCharis;
	@FXML
	ImageView rule;
	@FXML
	Label remainingPoints; 
	@FXML
	Label header;
	CharacterController sheet;
	Character character;
	
	@FXML
	void close() {
		sheet.resetStats();
		sheet.updateHP();
		sheet.setHP();
		header.getScene().getWindow().hide();
	}
	
	@FXML
	void confirm() {
		updateStats();
		Pane eventPane = ((Pane) confirm.getParent());
		if (Integer.parseInt(remainingPoints.getText()) == 0) {
			eventPane.getChildren().clear();
			eventPane.getChildren().add(rule);
			setStats();
		}
		
		Random random = new Random();
		int roll = 0;
		
		Label hitDie = new Label();
		hitDie.setText("Hit Die");
		hitDie.setLayoutX(37);
		hitDie.setLayoutY(61);
		hitDie.setFont(Font.font(24));
		
		
		Label ConMod = new Label();
		ConMod.setText("Constitution Modifier");
		ConMod.setLayoutX(37);
		ConMod.setLayoutY(148);
		ConMod.setFont(Font.font(24));
		
		Label MaxHP = new Label();
		MaxHP.setText("Max Hit Points");
		MaxHP.setLayoutX(37);
		MaxHP.setLayoutY(229);
		MaxHP.setFont(Font.font(24));
		
		Label NewHP = new Label();
		NewHP.setText("New Hit Points");
		NewHP.setLayoutX(37);
		NewHP.setLayoutY(353);
		NewHP.setFont(Font.font(28));

		
		Label ConModVal = new Label();
		int mod = this.character.getStats(Statistics.CONSTITUTION);
		final int modifier = (int) (Math.floor(mod/2) - 5);
		ConModVal.setText(Integer.toString(modifier));
		ConModVal.setLayoutX(314);
		ConModVal.setLayoutY(148);
		ConModVal.setPrefWidth(50);
		ConModVal.setFont(Font.font(24));
		ConModVal.setAlignment(Pos.CENTER_RIGHT);
		
		Label MaxHPVal = new Label();
		String hitpoints = (this.character.getExtra(Miscellaneous.TOTALHP));
		int totalhp = Integer.parseInt(hitpoints);
		MaxHPVal.setText(Integer.toString(totalhp));
		MaxHPVal.setLayoutX(314);
		MaxHPVal.setLayoutY(229);
		MaxHPVal.setPrefWidth(50);
		MaxHPVal.setFont(Font.font(24));
		MaxHPVal.setAlignment(Pos.CENTER_RIGHT);
		
		Label NewHPVal = new Label();
		NewHPVal.setText(Integer.toString(totalhp + modifier + roll));
		NewHPVal.setLayoutX(314);
		NewHPVal.setLayoutY(353);
		NewHPVal.setPrefWidth(50);
		NewHPVal.setFont(Font.font(28));
		NewHPVal.setAlignment(Pos.CENTER_RIGHT);
		
		Button roller = new Button();
		Button back = new Button();
		back.setDisable(true);

		roller.setText("Roll Hit Die");
		roller.setPrefSize(87, 51);
		roller.setLayoutX(277);
		roller.setLayoutY(53);
		roller.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int randroll = random.nextInt(10);
				roller.setText(Integer.toString(randroll+1));
				roller.setFont(Font.font(24));
				NewHPVal.setText(Integer.toString(totalhp + modifier + randroll+1));
				roller.setDisable(true);
				back.setDisable(false);
				updateHitpoints(Integer.parseInt(NewHPVal.getText()));
				eventPane.getChildren().add(NewHPVal);
			}
		});
		
		back.setText("Back to Character Sheet");
		back.setLayoutX(120);
		back.setLayoutY(430);
		back.setPrefSize(160, 25);
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				close();
			}
		});
		
		eventPane.getChildren().addAll(roller,hitDie,ConMod,MaxHP,NewHP,ConModVal,MaxHPVal,back);
	}
	
	private void updateStats() {
		int str = Integer.parseInt(this.str.getText());
		int dex = Integer.parseInt(this.dex.getText());
		int wis = Integer.parseInt(this.wis.getText());
		int intelli = Integer.parseInt(this.intelli.getText());
		int charis = Integer.parseInt(this.charis.getText());
		
		this.character.addStats(Statistics.STRENGTH, str);
		this.character.addStats(Statistics.DEXTERITY, dex);
		this.character.addStats(Statistics.WISDOM, wis);
		this.character.addStats(Statistics.INTELLIGENCE, intelli);
		this.character.addStats(Statistics.CHARISMA, charis);
		
	}
	
	void updateHitpoints(int newValue) {
		int totHP = newValue;
		character.addExtra(Miscellaneous.TOTALHP, Integer.toString(totHP));
		character.addExtra(Miscellaneous.CURRENTHP, Integer.toString(totHP));
	}

	void setStats() {
		int strength = Integer.parseInt(str.getText());
		character.addStats(Statistics.STRENGTH, strength);

		int dexterity = Integer.parseInt(dex.getText());
		character.addStats(Statistics.DEXTERITY, dexterity);

		int intelligence = Integer.parseInt(intelli.getText());
		character.addStats(Statistics.INTELLIGENCE, intelligence);

		int wisdom = Integer.parseInt(wis.getText());
		character.addStats(Statistics.WISDOM, wisdom);

		int charisma = Integer.parseInt(charis.getText());
		character.addStats(Statistics.CHARISMA, charisma);
	}

	@FXML
	void strUP() {
		if (Integer.parseInt(remainingPoints.getText()) > 0) {
			int current = Integer.parseInt(str.getText());
			str.setText(Integer.toString(current + 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))-1));
		}
	}
	
	@FXML
	void strDN() {
		int current = Integer.parseInt(str.getText());
		if (Integer.parseInt(remainingPoints.getText()) < 2 && current > startingStr) {
			str.setText(Integer.toString(current - 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))+1));
		}
	}
	@FXML
	void dexUP() {
		int current = Integer.parseInt(dex.getText());
		if (Integer.parseInt(remainingPoints.getText()) > 0) {
			dex.setText(Integer.toString(current + 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))-1));
		}
	}
	
	@FXML
	void dexDN() {
		int current = Integer.parseInt(dex.getText());
		if (Integer.parseInt(remainingPoints.getText()) < 2 && current > startingDex) {
			dex.setText(Integer.toString(current - 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))+1));
		}
	}
	@FXML
	void intUP() {
		int current = Integer.parseInt(intelli.getText());
		if (Integer.parseInt(remainingPoints.getText()) > 0) {
			intelli.setText(Integer.toString(current + 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))-1));
		}
	}
	
	@FXML
	void intDN() {
		int current = Integer.parseInt(intelli.getText());
		if (Integer.parseInt(remainingPoints.getText()) < 2 && current > startingIntelli) {
			intelli.setText(Integer.toString(current - 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))+1));
		}
	}
	@FXML
	void wisUP() {
		int current = Integer.parseInt(wis.getText());
		if (Integer.parseInt(remainingPoints.getText()) > 0) {
			wis.setText(Integer.toString(current + 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))-1));
		}
	}
	
	@FXML
	void wisDN() {
		int current = Integer.parseInt(wis.getText());
		if (Integer.parseInt(remainingPoints.getText()) < 2 && current > startingWis) {
			wis.setText(Integer.toString(current - 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))+1));
		}
	}
	@FXML
	void chaUP() {
		int current = Integer.parseInt(charis.getText());
		if (Integer.parseInt(remainingPoints.getText()) > 0) {
			charis.setText(Integer.toString(current + 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))-1));
		}
	}
	
	@FXML
	void chaDN() {
		int current = Integer.parseInt(charis.getText());
		if (Integer.parseInt(remainingPoints.getText()) < 2 && current > startingCharis) {
			charis.setText(Integer.toString(current - 1));
			remainingPoints.setText(Integer.toString((Integer.parseInt(remainingPoints.getText()))+1));
		}
	}
	
	public void grabController(CharacterController sheet) {
		this.sheet = sheet;
	}
	
	public void grabStats(Character stats) {
		this.character = stats;
		str.setText(Integer.toString(character.getStats(Statistics.STRENGTH)));
		startingStr = character.getStats(Statistics.STRENGTH);
		dex.setText(Integer.toString(character.getStats(Statistics.DEXTERITY)));
		startingDex = character.getStats(Statistics.DEXTERITY);
		intelli.setText(Integer.toString(character.getStats(Statistics.INTELLIGENCE)));
		startingIntelli = character.getStats(Statistics.INTELLIGENCE);
		wis.setText(Integer.toString(character.getStats(Statistics.WISDOM)));
		startingWis = character.getStats(Statistics.WISDOM);
		charis.setText(Integer.toString(character.getStats(Statistics.CHARISMA)));
		startingCharis = character.getStats(Statistics.CHARISMA);
		Pane eventPane = ((Pane) confirm.getParent());
		eventPane.getChildren().remove(rule);
		confirm.setDisable(true);
	}
	@FXML
	void checkPoints() {
		if (Integer.parseInt(remainingPoints.getText()) == 0) {
			confirm.setDisable(false);
		} else {
			confirm.setDisable(true);
		}
		
	}
	
	@FXML
	void initialize() {
		if (Integer.parseInt(remainingPoints.getText()) == 0) {
			confirm.setDisable(false);
		}
	}
}