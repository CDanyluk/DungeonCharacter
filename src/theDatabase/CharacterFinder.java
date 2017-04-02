package theDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CharacterFinder {

	private String charName, playerName, charRace, charClass, query;

	public CharacterFinder(String charName, String playerName, String charRace,
			String charClass) {
		this.charName = charName;
		this.playerName = playerName;
		this.charRace = charRace;
		this.charClass = charClass;
		this.query = buildQuery();
	}

	// For testing purposes
	public String getQuery() {
		return this.query;
	}

	public ArrayList<String> searchDatabase() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection;

		ArrayList<String> characterList = new ArrayList<>();

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:dungeon.db");
			Statement statement = connection.createStatement();

			ResultSet results = statement.executeQuery(this.query);

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

		if (!charName.equals("")) {
			numAttributes++;
			toReturn += "Name = '" + charName + "'";
		}
		if (!playerName.equals("")) {
			numAttributes++;
			if (numAttributes >= 2) {toReturn += " AND ";}
			toReturn += "PlayerName = '" + playerName + "'";
		}
		if (!charRace.equals("")) {
			numAttributes++;
			if (numAttributes >= 2) {toReturn += " AND ";}
			toReturn += "Race = '" + charRace + "'";
		}
		if (!charClass.equals("")) {
			numAttributes++;
			if (numAttributes >= 2) {toReturn += " AND ";}
			toReturn += "Class = '" + charClass + "'";
		}

		return toReturn;
	}
}
