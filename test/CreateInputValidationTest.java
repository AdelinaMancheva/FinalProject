
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import validations.CreateInputValidation;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link CreateInputValidation}
 *
 */
public class CreateInputValidationTest {

	CreateInputValidation createValid = new CreateInputValidation();

	@Test
	public void testValidateCarModelWithValidModel() {
		assertTrue(createValid.validateCarModel("A6"));
	}

	@Test
	public void testValidateCarModelWithInvalidModel() {
		assertFalse(createValid.validateCarModel("A"));
	}

	@Test
	public void testValidateCarTypeWithValidType() {
		assertTrue(createValid.validateCarType("hatchback"));
	}

	@Test
	public void testValidateCarTypeWithInvalidType() {
		assertFalse(createValid.validateCarType("hh"));
	}

	@Test
	public void testValidateEuroEmissionStandardWithValid() {
		assertTrue(createValid.validateEuroStandard("euro3"));
	}

	@Test
	public void testValidateEuroEmissionStandardWithInvalid() {
		assertFalse(createValid.validateEuroStandard("euro9"));
	}

	@Test
	public void testValidateEngineTypeWithValid() {
		assertTrue(createValid.validateEngineType("P"));
	}

	@Test
	public void testValidateEngineTypeWithInvalid() {
		assertFalse(createValid.validateEngineType("hh"));
	}

	@Test
	public void testValidateTransmTypeWithValid() {
		assertTrue(createValid.validateTransmType("Manual"));
	}

	@Test
	public void testValidateTransmTypeWithInvalid() {
		assertFalse(createValid.validateTransmType("M"));
	}

	@Test
	public void testValidateSuvModelWithValid() {
		assertTrue(createValid.validateSUVModel("Q1"));
	}

	@Test
	public void testValidateSuvModelWithInvalid() {
		assertFalse(createValid.validateSUVModel("jj"));
	}

	@Test
	public void testValidateVinWithValidVin() {
		String validVin = "BG1b83df8aqhb6qeb";
		assertTrue(createValid.validateVinByLength(validVin));
	}

	@Test
	public void testValidateVinWithInvalidVin() {
		String invalidVin = "hhh";
		assertFalse(createValid.validateVinByLength(invalidVin));
	}

}
