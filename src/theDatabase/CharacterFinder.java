package theDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

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

			ResultSet rs = statement.executeQuery("SELECT CharID FROM Attributes WHERE Name = '" +
													this.charName + "'");
			this.charID = rs.getInt("CharID");
			rs.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public HashMap<String, String> getCharacterInfoFrom(String tableName, int numColumns) throws ClassNotFoundException,
	SQLException {
		Class.forName("org.sqlite.JDBC");
		Connection connection;
		connection = DriverManager.getConnection("jdbc:sqlite:Dungeon.db");

		Optional<ResultSet> optionalRS = getFromDB(tableName, connection);
		HashMap<String, String> characterInfo = new HashMap<>();

		if (optionalRS.isPresent()) {
			ResultSet results = optionalRS.get();
			if (results.next()) {
				for (int c = 1; c <= numColumns; c++) {
					ResultSetMetaData soMetaBro = results.getMetaData();
					String columnName = soMetaBro.getColumnLabel(c);
					characterInfo.put(columnName, results.getString(c));
				}
			}
		}
		connection.close();
		return characterInfo;
	}

	private Optional<ResultSet> getFromDB(String tableName, Connection connection) throws ClassNotFoundException {

		try {
			Statement statement = connection.createStatement();

			Optional<ResultSet> toReturn = Optional.of(statement.executeQuery("SELECT * FROM " + tableName + " WHERE CharID = " + this.charID));
			return toReturn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Optional.empty();
	}

	// For testing purposes
	public String getQuery() {
		return this.query;
	}

	public ArrayList<String> getMatchingCharacters() throws ClassNotFoundException {
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
			connection.close();
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
