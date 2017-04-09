package Testing;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import theDatabase.Send;
import Classes.Attributes;
import Classes.Character;

public class SendTest {
	
	Send send;
	Character character;

	@Before
	public void setup() {
		send = new Send();
		character = new Character("Chantal Danyluk");
		character.addAttri(Attributes.ALIGNMENT, "Trys her best");
		character.addAttri(Attributes.BACKGROUND, "Highschool graduate maybe");
		character.addAttri(Attributes.CLASS, "Computer Science major");
		character.addAttri(Attributes.PLAYER, "Poor judgment");
		character.addAttri(Attributes.RACE, "101% human");
		
	}
	
	@Test
	public void test() {
		send.SendChar(character);
		
	}

}
