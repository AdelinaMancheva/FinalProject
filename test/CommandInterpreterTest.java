import static org.junit.Assert.*;

import org.junit.Test;

import commands.CommandInterpreter;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link CommandInterpreter}
 *
 */
public class CommandInterpreterTest {

	CommandInterpreter cmdInterpr = new CommandInterpreter();

	@Test
	public void testHasCommandWithValidCommand() {
		assertTrue(cmdInterpr.hasCommand("create"));
	}

	@Test
	public void testHasCommandWithInalidCommand() {
		assertFalse(cmdInterpr.hasCommand("ccc"));
	}

}
