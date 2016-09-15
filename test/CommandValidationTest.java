
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import validations.CommandValidation;

/**
 * @author AMancheva
 * 
 * Contains tests for {@link CommandValidation}
 *
 */
public class CommandValidationTest {

	CommandValidation commandValid = new CommandValidation();

	@Test
	public void testValidateCreateWithValidLength() {
		String[] args = { "car", "model=A6", "engine=P-180hp-euro3", "transmission=Maual-4" };
		assertTrue(commandValid.validateCreateByLength(args));
	}

	@Test
	public void testValidateCreateWithInvalidLength() {
		String[] args = { "car", "m" };
		assertFalse(commandValid.validateCreateByLength(args));
	}

	@Test
	public void testValidatePrintAllWithValidLength() {
		String[] args = { "all" };
		assertTrue(commandValid.validatePrintByLength(args));
	}

	@Test
	public void testValidatePrintVINWithValidLength() {
		String[] args = { "vin", "BG1.." };
		assertTrue(commandValid.validatePrintByLength(args));
	}

	@Test
	public void testValidateUpdateWithValidLength() {
		String[] args = { "BG1.." };
		assertTrue(commandValid.validateUpdateByLength(args));
	}

}
