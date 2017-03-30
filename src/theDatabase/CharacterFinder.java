package theDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CharacterFinder {

	private String charName, playerName, charRace, charClass;

	public CharacterFinder(String charName, String playerName, String charRace,
			String charClass) {
		this.charName = charName;
		this.playerName = playerName;
		this.charRace = charRace;
		this.charClass = charClass;
	}

	public void find() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection;
		String query = buildQuery();

		try {
			// TODO change this to make sure it uses the appropriate filename
			connection = DriverManager.getConnection("jdbc:sqlite:name.db");
			Statement statement = connection.createStatement();

			ResultSet results = statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
