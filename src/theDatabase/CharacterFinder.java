package theDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CharacterFinder {

	private String charName, playerName, charRace, charClass;

	public CharacterFinder(String charName, String playerName, String charRace,
			String charClass) {
		this.charName = charName;
		this.playerName = playerName;
		this.charRace = charRace;
		this.charClass = charClass;
	}

	public ArrayList<String> searchDatabase() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection;
		String query = buildQuery();
		ArrayList<String> characterList = new ArrayList<>();

		try {
			// TODO change this to make sure it uses the appropriate filename
			connection = DriverManager.getConnection("jdbc:sqlite:name.db");
			Statement statement = connection.createStatement();

			ResultSet results = statement.executeQuery(query);

			while (results.next()) {
				 characterList.add(buildCharacterString(results));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return characterList;
	}

	private String buildCharacterString(ResultSet rs) throws SQLException {
		String charName = rs.getString("Name");
		String playerName = rs.getString("PlayerName");
		String race = rs.getString("Race");
		String charClass = rs.getString("Class");

		return ("Player: " + playerName + ", Character: " + charName + " - " +
				race + " - " + charClass + ".");
	}

	private String buildQuery() {
		String toReturn = "SELECT * FROM Attributes WHERE ";
		int numAttributes = 0;

		if (!charName.equals(null)) {
			numAttributes++;
			toReturn += "Name = '" + charName + "'";
		}
		if (!playerName.equals(null)) {
			numAttributes++;
			if (numAttributes >= 2) {toReturn += " AND ";}
			toReturn += "PlayerName = '" + playerName + "'";
		}
		if (!charRace.equals(null)) {
			numAttributes++;
			if (numAttributes >= 2) {toReturn += " AND ";}
			toReturn += "Race = '" + charRace + "'";
		}
		if (!charClass.equals(null)) {
			numAttributes++;
			if (numAttributes >= 2) {toReturn += " AND ";}
			toReturn += "Class = '" + charClass + "'";
		}

		return toReturn;
	}
}
