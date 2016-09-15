import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import validations.EngineInputValidation;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link EngineInputValidation}
 *
 */
public class EngineInputValidationTest {

	private EngineInputValidation eiv = new EngineInputValidation();

	@Test
	public void testValidateEngineStringWithValidString() {
		assertTrue(eiv.validateEngineString("engine=P-250hp-T-euro3"));
		assertTrue(eiv.validateEngineString("engine=P-250hp-euro3"));
	}

	@Test
	public void testValidateEngineStringWithInvalidString() {
		assertFalse(eiv.validateEngineString("engine=P-250hp"));
		assertFalse(eiv.validateEngineString("engine=P-250hp-T"));
	}

	@Test
	public void testHasTurbo() {
		assertTrue(eiv.hasTurbo("engine=P-250hp-T"));
		assertFalse(eiv.hasTurbo("engine=P-250hp"));
	}

	@Test
	public void testValidateEngineParametersWithValid() {
		assertTrue(eiv.validateEngineParameters("P", 245, false, "euro3"));
	}

	@Test
	public void testValidateEngineParametersWithInvalid() {
		assertFalse(eiv.validateEngineParameters("hh", 245, false, "euro3"));
	}

	@Test
	public void testGetEngineType() {
		assertEquals("P", eiv.getEngineType("engine=P-250hp-T"));
	}

	@Test
	public void testGetPower() {
		assertEquals(250, eiv.getPower("engine=P-250hp-T-euro3"));
	}

	@Test
	public void testGetEuroStandard() {
		assertEquals("euro3", eiv.getEuroStandard("engine=P-250hp-T-euro3"));
	}

}
