import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import validations.ModelValidation;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link ModelValidation}
 *
 */
public class ModelValidationTest {

	private ModelValidation modelValid = new ModelValidation();

	@Test
	public void testValidateModelStringWithValid() {
		assertTrue(modelValid.validateModelString("model=A6"));
	}

	@Test
	public void testValidateModelStringWithInvalid() {
		assertFalse(modelValid.validateModelString("model="));
	}

	@Test
	public void testGetModel() {
		assertEquals("A6", modelValid.getModel("model=A6"));
	}

	@Test
	public void testHasTypeWithType() {
		assertTrue(modelValid.hasType("model=A6-kombi"));
	}

	@Test
	public void testHasTypeWithoutType() {
		assertFalse(modelValid.hasType("model=A6"));
	}

	@Test
	public void testGetType() {
		assertEquals("kombi", modelValid.getType("model=A6-kombi"));
	}

	@Test
	public void testGetTypeWithDefault() {
		assertEquals("sedan", modelValid.getType("model=A6"));
	}
}
