
package Classes;

import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import theGUI.CharacterController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class Export {

	Character character;
	StringBuilder charStringToExport;
	FileWriter fileWriter;
	public File destination;


	// Takes in the character for exporting purposes
	public Export(Character chara) {
		this.character = chara;
//		this.fileWriter= null;
		charToString();
	}
	// Turn the character into a string. only necessary for testing
	private String charToString() {
		charStringToExport = new StringBuilder();
		charStringToExport.append("SKILLS" + String.format("%n"));
		for (Skills s : Skills.values()) {
			charStringToExport.append("\t" + s.toString()+ ": ");
			charStringToExport.append(character.charSkills.get(s) + ";" + String.format("%n"));
		}
		System.out.println(charStringToExport.toString());
		return charStringToExport.toString();
	}

	//This is the function that is called in the character controller
	public void main(Window window) throws IOException {
		chooseDestination(window);
		try {
			if (destination != null) {
				fileWriter = new FileWriter(destination);
				fileWriter.write(character.getName() + String.format("%n"));
				writeSkills(fileWriter);
				writeAttributes(fileWriter);
 				writeStatistics(fileWriter);
				writeMisc(fileWriter);
				fileWriter.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	// TODO: Write functions like this one to write Attributes, Miscellaneous, and Statistics
	public void writeSkills(FileWriter fw) throws IOException {
		fw.write("SKILLS" + String.format("%n"));
		for (Skills s : Skills.values()) {
			fw.write("\t" + s.toString() + ": ");
			fw.write("\t" + character.charSkills.get(s) + ";");
			fw.write(String.format("%n"));
		}
	}
// These will be null while testing; skills are automatically set to 0 in initialize but others are not
	public void writeAttributes(FileWriter fw) throws IOException {
		fw.write("ATTRIBUTES" + String.format("%n"));
		for (Attributes a : Attributes.values()) {
			fw.write("\t" + a.toString() + ": ");
			fw.write("\t" + character.charAttri.get(a) + "; ");
			fw.write(String.format("%n"));
		}
	}

	public void writeStatistics(FileWriter fw) throws IOException {
		fw.write("STATISTICS" + String.format("%n"));
		for (Statistics s : Statistics.values()) {
			fw.write("\t" + s.toString() + ": ");
			fw.write("\t" + character.charStats.get(s) + "; ");
			fw.write(String.format("%n"));
		}
	}

	public void writeMisc(FileWriter fw) throws IOException {
		fw.write("MISCELLANEOUS" + String.format("%n"));
		for (Miscellaneous m : Miscellaneous.values()) {
			fw.write("\t" + m.toString() + ": ");
			fw.write("\t" + character.charExtra.get(m) + "; ");
			fw.write(String.format("%n"));
		}
	}

	public void chooseDestination(Window window) {
		FileChooser fileChooser = new FileChooser();

		//Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
		fileChooser.getExtensionFilters().add(extFilter);

		//Show save file dialog
		destination = fileChooser.showSaveDialog(window);
	}

}
