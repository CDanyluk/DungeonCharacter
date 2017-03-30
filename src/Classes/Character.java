package Classes;

import java.util.EnumMap;
import java.util.HashMap;

public class Character {
	
/*	Encapsulates all character data
	Uses Enums
	
	Statistics = strength, dexterity, constitution, 
	intelligence, wisdom, charisma, etc.
	
	Information = Class, background, player name,
	race, alignment, and experience

	*/
	
	Information info;
	Statistics stats;
	private String name;
	private HashMap charInfo;
	private  HashMap charStats;
	
	public Character(String name) {
		this.name = name;
		this.charInfo = new HashMap();
		this.charStats = new HashMap();
		
	}
	
	public String getName() {return name;}
	
	public void addStats(String statName, int i) {
		if (charStats.get(statName) != null) {
			charStats.remove(statName);
		}
		charStats.put(statName, i);
	}
	
	public void addCharInfo(String informationType, String info) {
		if (charInfo.get(informationType) != null) {
			charInfo.remove(informationType);
		}
		charInfo.put(informationType, info);
	}
	

}
