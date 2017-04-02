package theDatabase;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterFinderTest {

	CharacterFinder cf;

	@Test
	public void queryTest1() {
		cf = new CharacterFinder("Beezlebubba", "Callahan", "Demonlord", "Barbarian");
		String q = "SELECT * FROM Attributes WHERE Name = 'Beezlebubba' AND PlayerName = 'Callahan'" +
				" AND Race = 'Demonlord' AND Class = 'Barbarian'";
		assertEquals(q, cf.getQuery());
	}

	@Test
	public void queryTest2() {
		cf = new CharacterFinder("Beezlebubba", "Callahan", "", "");
		String q = "SELECT * FROM Attributes WHERE Name = 'Beezlebubba' AND PlayerName = 'Callahan'";
		assertEquals(q, cf.getQuery());
	}

	@Test
	public void queryTest3() {
		cf = new CharacterFinder("", "", "Demonlord", "Barbarian");
		String q = "SELECT * FROM Attributes WHERE Race = 'Demonlord' AND Class = 'Barbarian'";
		assertEquals(q, cf.getQuery());
	}

	@Test
	public void queryTest4() {
		cf = new CharacterFinder("", "Callahan", "", "");
		String q = "SELECT * FROM Attributes WHERE PlayerName = 'Callahan'";
		assertEquals(q, cf.getQuery());
	}

}
