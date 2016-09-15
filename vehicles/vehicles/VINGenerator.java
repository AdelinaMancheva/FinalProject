package vehicles;

import java.math.BigInteger;
import java.security.SecureRandom;

import exceptions.InvalidVINException;
import manufactory.Manufactory;
import validations.CreateInputValidation;

/**
 * @author AMancheva
 *
 */
public class VINGenerator {

	private SecureRandom secureRandom = new SecureRandom();
	private Manufactory manufactory = new Manufactory();

	/**
	 * @return unique string of length fourteen for the VIN
	 */
	public String generateUniqueString() {
		String code = new BigInteger(65, secureRandom).toString(26);

		return code.replaceAll("l", "q");
	}

	/**
	 * @return unique VIN of length seventeen
	 */
	public String generateVIN() {
		StringBuilder builder = new StringBuilder();
		String firstSymbols = manufactory.getCodeVIN();
		builder.append(firstSymbols + generateUniqueString());

		if (builder.toString().length() < CreateInputValidation.VIN_LENGTH) {
			try {
				throw new InvalidVINException();
			} catch (InvalidVINException ex) {
				return builder.append("f").toString();
			}
		}
		return builder.toString();
	}

}
