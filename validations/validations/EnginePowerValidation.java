package validations;

import java.util.HashMap;
import java.util.Map;

import engines.DieselEngine;

/**
 * @author AMancheva
 * 
 *         Validations about the power of the engine
 *
 */
public class EnginePowerValidation {

	/**
	 * Map that contains allowed displacement key: kw value: cm^3
	 */
	private static Map<Integer, Integer> DISPLACEMENTS_MAP = new HashMap<Integer, Integer>() {
		private static final long serialVersionUID = 1L;
		{
			put(74, 1000);
			put(134, 2000);
			put(245, 3000);
			put(253, 4000);
			put(331, 5000);
			put(510, 6000);
			put(736, 8000);
		}
	};;

	/**
	 * @param kw
	 * @return kw = kw + 30% from kw
	 */
	public int addTurbo(int kw) {
		double percentage = kw * 0.3;
		kw += percentage;
		return kw;
	}

	public boolean validatePower(int kw, boolean t) {
		if (t) {
			kw = addTurbo(kw);
			if (validateKW(kw)) {
				return true;
			}
		} else if (validateKW(kw)) {
			return true;
		}
		System.out.println("Invalid power.");
		return false;
	}

	public boolean validatePowerForDiesel(int kw, boolean t) {
		if (t) {
			kw = addTurbo(kw);
			if (validateKW(kw) && kw > DieselEngine.KW_LOWER_LIMIT && kw < DieselEngine.KW_UPPER_LIMIT) {
				return true;
			}
		} else if (validateKW(kw) && kw > DieselEngine.KW_LOWER_LIMIT && kw < DieselEngine.KW_UPPER_LIMIT) {
			return true;
		}
		System.out.println("Invalid power for diesel.");
		return false;
	}

	public int convertHorsePowerToKw(int hp) {
		Double kwDouble = 0.745699872 * hp;
		Integer kw = kwDouble.intValue();

		return kw;
	}

	public int convertLitersToCmCubic(int liters) {
		Double cmCubicDouble = liters / 0.0010000;
		Integer cmCubic = cmCubicDouble.intValue();

		return cmCubic;
	}

	/**
	 * @param kw
	 *            Checks if kw is in DISPLACEMENTS_MAP
	 */
	public boolean validateKW(int kw) {
		if (DISPLACEMENTS_MAP.containsKey(kw)) {
			return true;
		}
		return false;
	}

}
