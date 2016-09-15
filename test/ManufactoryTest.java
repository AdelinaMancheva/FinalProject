
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import manufactory.Manufactory;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link Manufactory}
 *
 */
public class ManufactoryTest {

	Manufactory manufactory = manufactory = new Manufactory(1, "GB");

	@Test
	public void testGetCodeVin() {
		assertEquals("GB1", manufactory.getCodeVIN());
	}

}
