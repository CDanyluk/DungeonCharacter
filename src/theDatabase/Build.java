package theDatabase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;


public class Build {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
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

