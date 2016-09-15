import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import commands.DisassembleCmd;

/**
 * @author AMancheva
 * 
 *         Conatins tests for {@link DisassembleCmd}
 *
 */
public class DisassembleCmdTest {

	private DisassembleCmd disCmd = new DisassembleCmd();

	@Test
	public void testGetCommandName() {
		String res = disCmd.getCommandName();
		assertEquals("disassemble", res);
	}

	// @Test
	// public void testExecuteWithValidVin() {
	// assertTrue(disCmd.execute("BG19noq7ca540q2ho"));
	// }

	@Test
	public void testExecuteWithInvalidVin() {
		assertFalse(disCmd.execute("jjj"));
	}
}
