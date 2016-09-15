import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import validations.EnginePowerValidation;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link EnginePowerValidation}
 *
 */
public class EnginePowerValidationTest {

	private EnginePowerValidation epv = new EnginePowerValidation();

	@Test
	public void testAddTurbo() {
		assertEquals(97, epv.addTurbo(75));
	}

	@Test
	public void testValidatePowerWithInvalid() {
		assertFalse(epv.validatePower(75, false));
	}

	@Test
	public void testValidatePowerWithValid() {
		assertTrue(epv.validatePower(74, false));
	}

	@Test
	public void testValidatePowerForDieselWithValid() {
		assertTrue(epv.validatePowerForDiesel(253, false));
	}

	@Test
	public void testValidatePowerForDieselWithInvalid() {
		assertFalse(epv.validatePowerForDiesel(610, false));
	}

	@Test
	public void testConvertLitersToCmCubic() {
		assertEquals(6000, epv.convertLitersToCmCubic(6));
	}

	@Test
	public void testConvertFromHorsePowerToKw() {
		int res = epv.convertHorsePowerToKw(250);
		assertEquals(186, res);
	}

	@Test
	public void testValidateKwWithValid() {
		assertTrue(epv.validateKW(74));
	}

	@Test
	public void testValidateKwWithInvalid() {
		assertFalse(epv.validateKW(75));
	}

}
