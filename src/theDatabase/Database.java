package theDatabase;

import java.sql.*;
import java.util.Scanner;

public class Database {
	
	public void command(String s) throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
	    Connection con = DriverManager.getConnection("jdbc:sqlite:testdb");
	    Statement stat = con.createStatement();

	    boolean done = false;

	        String cmd = s;
	        if (cmd.equals("quit")) {
	        	done = true;
	        } else {
	        	stat.execute(cmd);
	        }
	}
}

