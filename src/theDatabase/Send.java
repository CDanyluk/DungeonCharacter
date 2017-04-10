package theDatabase;

import java.io.BufferedReader;
import Classes.Character;
import Classes.Attributes;
import Classes.Skills;
import Classes.Miscellaneous;
import Classes.Statistics;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Send {
	//Class to send commands to database?
	// SELECT Field1, Field2, ... FieldN FROM TableName
	 public String Get() throws ClassNotFoundException, SQLException, IOException {
	        Class.forName("org.sqlite.JDBC");
	        Connection con = DriverManager.getConnection("jdbc:sqlite:Dungeon.db");
	        Statement stat = con.createStatement();
	       // String cmnd = s;
	         return stat.toString();
	    }

	 public void Send(String s) throws ClassNotFoundException, SQLException, IOException {
		 Class.forName("org.sqlite.JDBC");
	        Connection con = DriverManager.getConnection("jdbc:sqlite:Dungeon.db");
	        Statement stat = con.createStatement();
	        String command = s;
	        System.out.println(command);
	        stat.execute(command);
	        con.close();
	 }
	 
	 public void SendChar(Character chara) {
		 //CREATE TABLE Attributes (CharID INTEGER, Name TEXT, Class TEXT, Race TEXT, Background TEXT, Alignment TEXT, PlayerName TEXT, Experience TEXT)
		 String name = chara.getName();
		 System.out.println(name);
		 int uniqueID = name.hashCode();
		 String clas = chara.getAttri(Attributes.CLASS);
		 String race = chara.getAttri(Attributes.RACE);
		 String background = chara.getAttri(Attributes.BACKGROUND);
		 String alignment = chara.getAttri(Attributes.ALIGNMENT);
		 String playerName = chara.getAttri(Attributes.PLAYER);
		 String experience = chara.getStats(Statistics.EXPERIENCE) + "";
		 
		 String sendAttributes = "INSERT INTO Attributes VALUES (" + uniqueID + ", '" + name + "',  '" + clas + "', '" + race + "', '" + background + "', '" + alignment + "', '" + playerName + "', '" + experience + "')";
		 
		 //CREATE TABLE Statistics (CharID INTEGER, Level INTEGER, Strength INTEGER, Dexterity INTEGER, Consitution INTEGER, Intelligence INTEGER, Wisdom INTEGER, Charisma INTEGER)
		 int Level = chara.getStats(Statistics.LEVEL);
		 int Strength = chara.getStats(Statistics.STRENGTH);
		 int Dexterity = chara.getStats(Statistics.DEXTERITY);
		 int Constitution = chara.getStats(Statistics.CONSTITUTION);
		 int Intelligence = chara.getStats(Statistics.INTELLIGENCE);
		 int Wisdom = chara.getStats(Statistics.WISDOM);
		 int Charisma = chara.getStats(Statistics.CHARISMA);
		 
		 String sendStatistics = "INSERT INTO Statistics VALUES (" + uniqueID + ", " + Level + ", " + Strength+ ", " + Dexterity + ", " + Constitution + ", " + Intelligence + ", " + Wisdom + ", " + Charisma + ")";
		 
		 //CREATE TABLE Skills (CharID INTEGER, Acrobatics INTEGER, Animals INTEGER, Arcana INTEGER, Athletics INTEGER, Deception INTEGER, History INTEGER, Insight INTEGER, Intimidation INTEGER, Investigation INTEGER, Medicine INTEGER, Nature INTEGER, Perception INTEGER, Performance INTEGER, Persuasion INTEGER, Religion INTEGER, SleightOfHand INTEGER, Stealth INTEGER, Survival INTEGER)
		 int Acrobatics = chara.getSkills(Skills.ACROBATS);
		 int Animals = chara.getSkills(Skills.ANIMALS);
		 int Arcana = chara.getSkills(Skills.ARCANA);
		 int Athletics = chara.getSkills(Skills.ATHLETICS);
		 int Deception = chara.getSkills(Skills.DECEPTION);
		 int History = chara.getSkills(Skills.HISTORY);
		 int Insight = chara.getSkills(Skills.INSIGHT);
		 int Intimidation = chara.getSkills(Skills.INTIMIDATION);
		 int Investigation = chara.getSkills(Skills.INVESTIGATION);
		 int Medicine = chara.getSkills(Skills.MEDICINE);
		 int Nature = chara.getSkills(Skills.NATURE);
		 int Perception = chara.getSkills(Skills.PERCEPTION);
		 int Performance = chara.getSkills(Skills.PERFORMANCE);
		 int Persuasion = chara.getSkills(Skills.PERSUASION);
		 int Religion = chara.getSkills(Skills.RELIGION);
		 int SleightOfHand = chara.getSkills(Skills.SLEIGHT);
		 int Stealth = chara.getSkills(Skills.STEALTH);
		 int Survival = chara.getSkills(Skills.SURVIVAL);
		 
		 String sendSkills = "INSERT INTO Skills VALUES (" + uniqueID + ", " + Acrobatics + ", " + Animals + ", " + Arcana + ", " + Athletics + ", " + Deception + ", " + History + ", " + Insight + ", " + Intimidation + ", " + Investigation + ", " + Medicine + ", " + Nature + ", " + Perception + ", " + Performance + ", " + Persuasion + ", " + Religion + ", " + SleightOfHand + ", " + Stealth + ", " + Survival + ")";
		 
		 //CREATE TABLE Misc (CharID INTEGER, ProficiencyBonus INTEGER, ArmorClass INTEGER, Initiative INTEGER, Speed INTEGER, CurrentHP INTEGER, TotalHP INTEGER, WeaponsAndEquipment TEXT, Misc TEXT)
		 String ProficiencyText = chara.getExtra(Miscellaneous.PROFICIENCY);
		 int ProficiencyBonus = Integer.parseInt(ProficiencyText);
		 
		 String ArmorText = chara.getExtra(Miscellaneous.ARMORCLASS);
		 int ArmorClass = Integer.parseInt(ArmorText);
		 
		 String InitiativeText = chara.getExtra(Miscellaneous.INITIATIVE);
		 int Initiative = Integer.parseInt(InitiativeText);
		
		 String SpeedText = chara.getExtra(Miscellaneous.SPEED);
		 int Speed = Integer.parseInt(SpeedText);
		 
		 String CurrHPText = chara.getExtra(Miscellaneous.CURRENTHP);
		 int CurrentHP = Integer.parseInt(CurrHPText);
		 
		 String TotHPText = chara.getExtra(Miscellaneous.TOTALHP);
		 int TotalHP = Integer.parseInt(TotHPText);
		 
		 String WeaponsAndEquipment = chara.getExtra(Miscellaneous.EQUIPMENT);
		 String Misc = chara.getExtra(Miscellaneous.MISC);
		 
		 String sendMisc = "INSERT INTO Misc VALUES (" + uniqueID + ", " + ProficiencyBonus + ", " + ArmorClass + ", " + Initiative + ", " + Speed + ", " + CurrentHP + ", " + TotalHP + ", '" + WeaponsAndEquipment + "', '" + Misc + "')";
		 
		 try {
			Send(sendAttributes);
			Send(sendStatistics);
			Send(sendSkills);
			Send(sendMisc);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println("Could not send character!");
			e.printStackTrace();
		}
	 }

}
