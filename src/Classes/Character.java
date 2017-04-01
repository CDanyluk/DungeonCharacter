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
	
	//Attributes attri;
	//Statistics stats;
	private String name;
	private HashMap charAttri;
	private  HashMap charStats;
	
	public Character(String name) {
		this.name = name;
		this.charAttri = new HashMap();
		this.charStats = new HashMap();
		
	}
	
	public String getName() {return name;}
	
	public void addStats(String statName, int i) {
		if (charStats.get(statName) != null) {
			charStats.remove(statName);
		}
		charStats.put(statName, i);
	}
	
	public void addAttri(String attriType, String info) {
		if (charAttri.get(attriType) != null) {
			charAttri.remove(attriType);
		}
		charAttri.put(attriType, info);
	}
	
	public String getAttri(String attriType) {
		return (String) charAttri.get(attriType);
	}
	
	public String getStats(String statName) {
		return (String) charStats.get(statName);
	}

}
