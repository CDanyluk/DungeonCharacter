package Tests;
 
 import static org.junit.Assert.*;
 import Classes.Statistics;
 import Classes.Attributes;
 import Classes.Miscellaneous;
import Classes.Skills;
 
 import org.junit.Before;
 import org.junit.Test;
 
 import Classes.Character;
 
 public class CharacterTest {
 	
 	Character character;
 	
 	@Before
 	public void setup() {
 		Character character = new Character("Name");
 		this.character = character;
 	}
 	
 	@Test
 	public void testName() {
 		String firstname = character.getName();
 		assertEquals("Name", firstname);
 		
 		character.setName("Chantal Danyluk");
 		String secondname = character.getName();
 		assertEquals("Chantal Danyluk", secondname);  
 		
 	}
 	
 	@Test
 	public void testBasic() {
 		character.addExtra(Miscellaneous.EQUIPMENT, "0");
 		character.addExtra(Miscellaneous.MISC, "0");
 		
 		for (Statistics sta : Statistics.values()) {
 			  assertEquals(character.getStats(sta), 0);
 		}
		for (Miscellaneous mis : Miscellaneous.values()) {
 			  assertEquals(character.getExtra(mis), "0");
		}
 		for (Skills ski : Skills.values()) {
 			  assertEquals(character.getSkills(ski), 0);
 		}	
 		
 	}
 	
 	@Test
 	public void testSkillsGet() {
 		int adder = 0;
 		for (Skills ski : Skills.values()) {
 			adder++;
 			character.setSkills(ski, adder);
 		}
 		
 		int getter = 0;
		for (Skills ski : Skills.values()) {
 			getter++;
 			assertEquals(character.getSkills(ski), getter);
 			
 		}
 		
 	}
 	
 	@Test
 	public void testSkillsIncrease() {
 		for (Skills ski : Skills.values()) {
 		
 			for (int i = 0; i < 99; i++) {
 				character.increaseSkills(ski);
 			}
		}
 		for (Skills ski : Skills.values()) {
 			assertEquals(character.getSkills(ski), 99);
 			
 		}
 		//------------------------------
 		for (Skills ski : Skills.values()) {
 			
 			for (int i = 0; i < 99; i++) {
 				character.decreaseSkills(ski);
 			}
 		}
 		
 		for (Skills ski : Skills.values()) {
 			assertEquals(character.getSkills(ski), 0);
 			
 		}
 	}
 	
 	
 	
 	@Test
 	public void testStats() {
 		int adder = 0;
 		for (Statistics stats : Statistics.values()) {
 			adder++;
 			character.addStats(stats, adder);
 		}
 		
 		int getter = 0;
 		for (Statistics stats : Statistics.values()) {
 			getter++;
 			assertEquals(character.getStats(stats), getter);
 		}
 	}
 	
 	@Test
 	public void testAttributes() {
 		int adder = 0;
 		for (Attributes att : Attributes.values()) {
 			adder++;
 			String temp = adder + "test";
 			character.addAttri(att, temp);
 		}
 		
 		int getter = 0;
 		for (Attributes att : Attributes.values()) {
 			getter++;
 			String tempGet = getter + "test";
 			assertEquals(character.getAttri(att), tempGet);
 		}
 	}
 		
 
 
 }