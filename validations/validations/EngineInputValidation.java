package validations;

/**
 * @author AMancheva
 *
 *         Validating engine info input and also getters for engine context
 */
public class EngineInputValidation {

	private EnginePowerValidation engineValid = new EnginePowerValidation();
	private CreateInputValidation createValid = new CreateInputValidation();

	/**
	 * Validates correct input of egine information
	 */
	public boolean validateEngineString(String engineInfo) {
		if (engineInfo.contains("engine=")) {
			String[] info = engineInfo.split("engine=");
			if (info.length > 0) {
				String[] infoArr = info[1].split("-");
				if (infoArr.length > 1) {
					if (hasTurbo(engineInfo) && infoArr.length >= 4) {
						return true;
					} else if (!hasTurbo(engineInfo) && infoArr.length >= 3) {
						return true;
					}
				}
			}
		}
		System.out.println("Invalid engine argument.");
		return false;
	}

	public boolean hasTurbo(String s) {
		if (s.contains("T")) {
			return true;
		}
		return false;
	}

	/**
	 * @return validates all engine parameters at once
	 */
	public boolean validateEngineParameters(String engineType, int kw, boolean t, String euro) {
		if (createValid.validateEngineType(engineType) && createValid.validateEuroStandard(euro)
				&& engineValid.validatePower(kw, t)) {
			return true;
		}
		return false;
	}

	public String getEngineType(String engineInfo) {
		String[] info = engineInfo.split("engine=");
		String[] infoArr = info[1].split("-");
		return infoArr[0];
	}

	public int getPower(String engineInfo) {
		String[] info = engineInfo.split("engine=");
		String[] infoArr = info[1].split("-");
		String[] power = infoArr[1].split("hp");
		int p = Integer.parseInt(power[0]);
		return p;
	}

	public String getEuroStandard(String engineInfo) {
		String[] info = engineInfo.split("engine=");
		String[] infoArr = info[1].split("-");
		String euro;
		if (!hasTurbo(engineInfo)) {
			euro = infoArr[2];
		} else {
			euro = infoArr[3];
		}
		return euro;
	}

}
