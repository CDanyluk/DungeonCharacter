package Classes;

import java.util.EnumMap;
import java.util.HashMap;

public class Character {
	
/*	Encapsulates all character data
	Enums?
	
	Statistics = strength, dexterity, constitution, 
	intelligence, wisdom, charisma, etc.
	
	Information = Class, background, player name,
	race, alignment, and experience
	
	Honestly stats and information feels mutable to me...?
	So all enums are a mess until I figure out what to do
	*/
	
	private String name;
	private EnumMap charInfo;
	private  HashMap stats;
	
	public Character(String name) {
		this.name = name;
	}

}
