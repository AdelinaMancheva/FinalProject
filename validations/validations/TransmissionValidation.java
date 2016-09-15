package validations;

import transmissions.AutomaticTransmission;
import transmissions.ManualTransmission;

/**
 * @author AMancheva
 * 
 *         Contains validations for transmissions
 *
 */
public class TransmissionValidation {

	/**
	 * Checks transmission string for correctness
	 */
	public boolean validateTransmissionString(String transmInfo) {
		if (transmInfo.contains("transmission=")) {
			String[] transmInfoArr = transmInfo.split("transmission=");
			if (transmInfoArr.length > 0) {
				return true;
			}
		}
		System.out.println("Invalid transmission argument.");
		return false;
	}

	public String getTransmType(String transmInfo) {
		String[] info = transmInfo.split("transmission=");
		String[] infoArr = info[1].split("-");
		return infoArr[0];
	}

	public int getTransmGears(String transmInfo) {
		String[] info = transmInfo.split("transmission=");
		String[] infoArr = info[1].split("-");
		int gears = Integer.parseInt(infoArr[1]);
		return gears;
	}

	public boolean validateGearsForManual(int gears) {
		for (int i : ManualTransmission.GEARS_MANUAL) {
			if (i == gears) {
				return true;
			}
		}
		System.out.println("Invalid gears.");
		return false;
	}

	public boolean validateGearsForAutomatic(int gears) {
		for (int i : AutomaticTransmission.GEARS_AUTOMATIC) {
			if (i == gears) {
				return true;
			}
		}
		System.out.println("Invalid gears.");
		return false;
	}

}
