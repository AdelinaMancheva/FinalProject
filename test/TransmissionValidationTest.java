
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import validations.TransmissionValidation;

/**
 * @author AMancheva
 * 
 *         Contains tests for {@link TransmissionValidation}
 *
 */
public class TransmissionValidationTest {

	TransmissionValidation transmValid = new TransmissionValidation();

	@Test
	public void testValidateTransmStringWithValid() {
		assertTrue(transmValid.validateTransmissionString("transmission=Manual-4"));
	}

	@Test
	public void testValidateTransmStringWithInalid() {
		assertFalse(transmValid.validateTransmissionString("transmissiom="));
	}

	@Test
	public void testGetTransmType() {
		assertEquals("Manual", transmValid.getTransmType("transmission=Manual-4"));
	}

	@Test
	public void testGetTransmGears() {
		assertEquals(4, transmValid.getTransmGears("transmission=Manual-4"));
	}

	@Test
	public void testValidateGearsForManualWithValid() {
		assertTrue(transmValid.validateGearsForManual(5));
	}

	@Test
	public void testValidateGearsForManualWithInvalid() {
		assertFalse(transmValid.validateGearsForManual(9));
	}

	@Test
	public void testValidateTransmGearsForAutomaticWithValid() {
		assertTrue(transmValid.validateGearsForAutomatic(5));
	}

	@Test
	public void testValidateTransmGearsForAutomaticWithInvalid() {
		assertFalse(transmValid.validateGearsForAutomatic(10));
	}

}
