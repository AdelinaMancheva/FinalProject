package validations;

import enums.CarModelsEnum;
import enums.CarTypeEnum;
import enums.EngineTypeEnum;
import enums.EuroTypeEnum;
import enums.SUVModelsEnum;
import enums.TransmTypesEnum;

/**
 * @author AMancheva
 * 
 *         Methods for checking types validation
 *
 */
public class CreateInputValidation {

	public static final int VIN_LENGTH = 17;

	public boolean validateCarModel(String model) {
		for (CarModelsEnum m : CarModelsEnum.values()) {
			if (m.name().equals(model)) {
				return true;
			}
		}
		System.out.println("Invalid model.");
		return false;
	}

	public boolean validateCarType(String type) {
		for (CarTypeEnum t : CarTypeEnum.values()) {
			if (t.name().equals(type)) {
				return true;
			}
		}
		System.out.println("Invalid car type.");
		return false;
	}

	public boolean validateEuroStandard(String euro) {
		for (EuroTypeEnum e : EuroTypeEnum.values()) {
			if (e.name().equals(euro)) {
				return true;
			}
		}
		System.out.println("Invalid euro emission standard.");
		return false;
	}

	public boolean validateEngineType(String type) {
		for (EngineTypeEnum t : EngineTypeEnum.values()) {
			if (t.name().equals(type)) {
				return true;
			}
		}
		System.out.println("Invalid engine type.");
		return false;
	}

	public boolean validateTransmType(String type) {
		for (TransmTypesEnum t : TransmTypesEnum.values()) {
			if (t.name().equals(type)) {
				return true;
			}
		}
		System.out.println("Invalid transmission type.");
		return false;
	}

	public boolean validateSUVModel(String type) {
		for (SUVModelsEnum t : SUVModelsEnum.values()) {
			if (t.name().equals(type)) {
				return true;
			}
		}
		System.out.println("Invalid SUV type.");
		return false;
	}

	public boolean validateVinByLength(String vin) {
		if (vin.length() == VIN_LENGTH) {
			return true;
		}
		return false;
	}

}
