package theDatabase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Get {
	//Class to send commands to database?
	// SELECT Field1, Field2, ... FieldN FROM TableName
	 public String Get() throws ClassNotFoundException, SQLException, IOException {
	        Class.forName("org.sqlite.JDBC");
	        Connection con = DriverManager.getConnection("jdbc:sqlite:Dungeon");
	        Statement stat = con.createStatement();
	       // String cmnd = s;
	         return stat.toString();
	    }
	 
	 public void Send(String s) throws ClassNotFoundException, SQLException, IOException {
		 Class.forName("org.sqlite.JDBC");
	        Connection con = DriverManager.getConnection("jdbc:sqlite:Dungeon");
	        Statement stat = con.createStatement();
	        BufferedReader commands = new BufferedReader(new FileReader("resources/DnDdbcreation.txt"));
	        String command;
	        while ((command = commands.readLine()) != null) {
	            System.out.println(command);
	            stat.execute(command);
	        }
	 }

}
