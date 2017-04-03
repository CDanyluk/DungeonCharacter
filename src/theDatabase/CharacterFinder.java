package theDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import Classes.Attributes;

public class CharacterFinder {

	private String charName, playerName, charRace, charClass, query;
	private int charID;

	public CharacterFinder(String charName, String playerName, String charRace,
			String charClass) {
		this.charName = charName;
		this.playerName = playerName;
		this.charRace = charRace;
		this.charClass = charClass;
		this.query = buildQuery();
	}

	public CharacterFinder(String charName) throws ClassNotFoundException {
		this.charName = charName;
		getID();
	}

	private void getID() throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Dungeon.db");
			Statement statement = connection.createStatement();

			ResultSet rs = statement.executeQuery("SELECT CharID FROM Attributes WHERE Name = '" + this.charName + "'");
			this.charID = rs.getInt("CharID");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public HashMap<String, Integer> getAttributes() throws ClassNotFoundException, SQLException {
		ResultSet results = getStuff("Attributes");
		HashMap<String, Integer> attributes = new HashMap<>();
		if (!results.equals(null)) {
			for (Attributes a : Attributes.values()) {
				attributes.put(a.toString(), results.getInt(a.toString()));
			}
		}
		return attributes;
	}

	private ResultSet getStuff(String tableName) throws ClassNotFoundException {
		Class.forName("org.sqlite.JDBC");
		Connection connection;
		ResultSet results = null;


		try {
			connection = DriverManager.getConnection("jdbc:sqlite:Dungeon.db");
			Statement statement = connection.createStatement();

			results = statement.executeQuery("SELECT * FROM " + tableName + " WHERE CharID = " + this.charID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return results;
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
			connection = DriverManager.getConnection("jdbc:sqlite:Dungeon.db");
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
