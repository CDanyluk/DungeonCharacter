<<<<<<< HEAD

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
				writeSkills();
				writeAttributes();
 				writeStatistics();
				writeMisc();
				fileWriter.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	// TODO: Write functions like this one to write Attributes, Miscellaneous, and Statistics
	private void writeSkills() throws IOException {
		fileWriter.write("SKILLS" + String.format("%n"));
		for (Skills s : Skills.values()) {
			fileWriter.write("\t" + s.toString() + ": ");
			fileWriter.write("\t" + character.charSkills.get(s) + ";");
			fileWriter.write(String.format("%n"));
		}
	}
// These will be null while testing; skills are automatically set to 0 in initialize but others are not
	private void writeAttributes() throws IOException {
		fileWriter.write("ATTRIBUTES" + String.format("%n"));
		for (Attributes a : Attributes.values()) {
			fileWriter.write("\t" + a.toString() + ": ");
			fileWriter.write("\t" + character.charAttri.get(a) + "; ");
			fileWriter.write(String.format("%n"));
		}
	}

	private void writeStatistics() throws IOException {
		fileWriter.write("STATISTICS" + String.format("%n"));
		for (Statistics s : Statistics.values()) {
			fileWriter.write("\t" + s.toString() + ": ");
			fileWriter.write("\t" + character.charStats.get(s) + "; ");
			fileWriter.write(String.format("%n"));
		}
	}

	private void writeMisc() throws IOException {
		fileWriter.write("MISCELLANEOUS" + String.format("%n"));
		for (Miscellaneous m : Miscellaneous.values()) {
			fileWriter.write("\t" + m.toString() + ": ");
			fileWriter.write("\t" + character.charExtra.get(m) + "; ");
			fileWriter.write(String.format("%n"));
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
<<<<<<< HEAD

=======
=======
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
				writeSkills();
				writeAttributes();
 				writeStatistics();
				writeMisc();
				fileWriter.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	// TODO: Write functions like this one to write Attributes, Miscellaneous, and Statistics
	private void writeSkills() throws IOException {
		fileWriter.write("SKILLS" + String.format("%n"));
		for (Skills s : Skills.values()) {
			fileWriter.write("\t" + s.toString() + ": ");
			fileWriter.write("\t" + character.charSkills.get(s) + ";");
			fileWriter.write(String.format("%n"));
		}
	}
// These will be null while testing; skills are automatically set to 0 in initialize but others are not
	private void writeAttributes() throws IOException {
		fileWriter.write("ATTRIBUTES" + String.format("%n"));
		for (Attributes a : Attributes.values()) {
			fileWriter.write("\t" + a.toString() + ": ");
			fileWriter.write("\t" + character.charAttri.get(a) + "; ");
		}
	}

	private void writeStatistics() throws IOException {
		fileWriter.write("STATISTICS" + String.format("%n"));
		for (Statistics s : Statistics.values()) {
			fileWriter.write("\t" + s.toString() + ": ");
			fileWriter.write("\t" + character.charStats.get(s) + "; ");
		}
	}

	private void writeMisc() throws IOException {
		fileWriter.write("MISCELLANEOUS" + String.format("%n"));
		for (Miscellaneous m : Miscellaneous.values()) {
			fileWriter.write("\t" + m.toString() + ": ");
			fileWriter.write("\t" + character.charExtra.get(m) + "; ");
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

>>>>>>> origin/master
>>>>>>> parent of 05b3322... random junk
