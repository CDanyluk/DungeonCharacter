package Classes;
import java.sql.SQLException;

import Classes.Information;
import theDatabase.Database;

public class Store {
	
	Information info;
	Statistics stats;
	Database data;
	
	public Store() {
		
	}
	
/*	public void CreateDatabase(Character chara) {
		String creation = "CREATE TABLE " +  chara.getName() + 
						 "(" + info.CLASS.message() + "TEXT," + info.RACE.message() + "TEXT)";
		try {
			data.command(creation);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound Error: Store.class");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException Error: Store.class");
			e.printStackTrace();
		}
		
	}*/
	
	public void AddCharacter(Character chara) {
		
	}
	
	public void ReadData() {
		
	}
	
	

}
