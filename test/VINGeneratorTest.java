
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import vehicles.VINGenerator;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link VINGenerator}
 *
 */
public class VINGeneratorTest {

	private VINGenerator vinGenerator = new VINGenerator();

	@Test
	public void testGenerateUniqueString() {
		String res = vinGenerator.generateUniqueString();
		assertEquals("k", res);
	}

	@Test
	public void testGenerateVIN() {
		String res = vinGenerator.generateVIN();
		assertEquals("k", res);
	}

}
