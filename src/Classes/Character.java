package Classes;

import java.util.EnumMap;
import java.util.HashMap;

public class Character {

/*	Encapsulates all character data
	Uses EnumMaps

	Statistics = strength, dexterity, constitution,
	intelligence, wisdom, charisma, etc.

	Attributes = Class, background, player name,
	race, alignment, and experience

	Misc = ArmorClass, initiative, speed, currentHP, totalHP,
	weaponsAndEquipment, misc

	Skills = Acrobatics, animals, arcana, athletics, deception, history, insight,
	intimidation, investigation, medicine, nature, perception, performance, persuasion,
	religion, sleight of hand, stealth, survival

	*/

	private String name;
	public  EnumMap<Attributes, String> charAttri;
	public  EnumMap<Statistics, Integer> charStats;
	public EnumMap<Miscellaneous, String> charExtra;
	public EnumMap<Skills, Integer> charSkills;
	public EnumMap<Throws, Integer> charThrows;

	public Character(String name) {
		this.name = name;
		this.charAttri = new EnumMap<>(Attributes.class);
		this.charStats = new EnumMap<>(Statistics.class);
		this.charExtra = new EnumMap<>(Miscellaneous.class);
		this.charSkills = new EnumMap<>(Skills.class);
		this.charThrows = new EnumMap<>(Throws.class);

		for (Attributes att : Attributes.values()) {
			  addAttri(att, "none");
		}
		for (Statistics sta : Statistics.values()) {
			  addStats(sta, 0);
		}
		for (Miscellaneous mis : Miscellaneous.values()) {
			  addExtra(mis, "0");
		}
		for (Skills ski : Skills.values()) {
			  setSkills(ski, 0);
		}
		for (Throws th : Throws.values()) {
			setThrows(th, 0);
		}
		addExtra(Miscellaneous.EQUIPMENT, " ");
		addExtra(Miscellaneous.MISC, " ");

	}
	//whqataa

	public String getName() {return name;}

	public void setName(String n) {
		this.name = n;
	}


	//Use example:
	//		character.addStats(Statistics.STRENGTH, 100);
	public void addStats(Statistics s, int i) {
		charStats.put(s, i);
	}

	//Use example:
	//		character.addAttri(Attributes.CLASS, "berserker");
	public void addAttri(Attributes a, String info) {
		charAttri.put(a, info);
	}

	//Use example:
	//		character.addExtra(Miscellaneous.EQUIPMENT, "My character carries a lot of junk, a gun, knife, & PB&J");
	public void addExtra(Miscellaneous m, String text) {
		charExtra.put(m, text);
	}

	//Use example:
	//		character.addStats(Skills.DECEPTION, 42);
	public void setSkills(Skills skill, int num) {
		charSkills.put(skill,  num);
	}

	//Example use:
	//		clas.setText(character.getAttri(Attributes.CLASS));
	public String getAttri(Attributes attriType) {
		return charAttri.get(attriType);
	}

	//Example use:
	//		strength.setText(character.getStats(Statistics.STRENGTH));
	public int getStats(Statistics statName) {
		return charStats.get(statName);
	}

	//Example use:
	//		equipment.setText(character.getExtra(Miscellanous.EQUIPMENT));
	public String getExtra(Miscellaneous m) {
		return charExtra.get(m);
	}

	//Use example:
		//		deception.setText(character.getSkills(Skills.DECEPTION));
	public int getSkills(Skills s) {
		return charSkills.get(s);
	}

	public void increaseSkills(Skills s) {
		int number = charSkills.get(s);
		number++;
		charSkills.put(s, number);
	}

	public void decreaseSkills(Skills s) {
		int number = charSkills.get(s);
		number--;
		charSkills.put(s, number);
	}

	public void setThrows(Throws th, int num) {
		charThrows.put(th, num);
	}

	//yo delete later
	///whatatata

	public int getThrows(Throws th) {
		return charThrows.get(th);
	}

	public void increaseThrows(Throws th) {
		int number = charThrows.get(th);
		number++;
		charThrows.put(th, number);
	}

	public void decreaseThrows(Throws th) {
		int number = charThrows.get(th);
		number--;
		charThrows.put(th, number);
	}

}
