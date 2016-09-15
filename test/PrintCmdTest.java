
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commands.PrintCmd;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link PrintCmd}
 *
 */
public class PrintCmdTest {

	private PrintCmd printCmd = new PrintCmd();

	@Test
	public void testGetCommandName() {
		String name = printCmd.getCommandName();
		assertEquals("print", name);
	}

	@Test
	public void testExecuteVinWithValidVIN() {
		assertTrue(printCmd.execute("vin BG1350gc0jpm2i48d"));
	}

	// @Test
	// public void testExecuteVinWithInvalidVin() {
	// assertFalse(printCmd.execute("vin jj"));
	// }

}
