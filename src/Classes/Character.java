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
	private  EnumMap<Attributes, String> charAttri;
	private  EnumMap<Statistics, Integer> charStats;
	
	public Character(String name) {
		this.name = name;
		this.charAttri = new EnumMap<>(Attributes.class);
		this.charStats = new EnumMap<>(Statistics.class);
		
	}
	
	public String getName() {return name;}
	
	public void addStats(Statistics s, int i) {
		charStats.put(s, i);
	}
	
	public void addAttri(Attributes a, String info) {
		charAttri.put(a, info);
	}
	
	public String getAttri(Attributes attriType) {
		return charAttri.get(attriType);
	}
	
	public int getStats(Statistics statName) {
		return charStats.get(statName);
	}

}
