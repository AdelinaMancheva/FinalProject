import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commands.UpdateCmd;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link UpdateCmd}
 *
 */
public class UpdateCmdTest {

	UpdateCmd updateCmd = new UpdateCmd();

	@Test
	public void testExecuteWithValidVin() {
		assertTrue(updateCmd.execute("BG13d8gq4dh1qd5kh"));
	}

	@Test
	public void testExecuteWithUnvalidVin() {
		assertFalse(updateCmd.execute("jjj"));
	}
}
