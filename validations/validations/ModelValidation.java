package validations;

import models.Model;

/**
 * @author AMancheva
 * 
 *         Contains methods for model validation
 *
 */
public class ModelValidation {

	/**
	 * Checks model string for correctness
	 */
	public boolean validateModelString(String modelInfo) {
		if (modelInfo.contains("model=")) {
			String[] modelInfoArr = modelInfo.split("model=");
			if (modelInfoArr.length > 0) {
				return true;
			}
		}
		System.out.println("Invalid model argument.");
		return false;
	}

	public String getModel(String modelInfo) {
		String[] modelType = modelInfo.split("model=");
		String[] modelTypeArr = modelType[1].split("-");
		return modelTypeArr[0];
	}

	public boolean hasType(String modelInfo) {
		String[] modelType = modelInfo.split("model=");
		String[] modelTypeArr = modelType[1].split("-");
		if (modelTypeArr.length > 1) {
			return true;
		}
		return false;
	}

	public String getType(String modelInfo) {
		String[] modelType = modelInfo.split("model=");
		String[] modelTypeArr = modelType[1].split("-");
		if (hasType(modelInfo)) {
			return modelTypeArr[1];
		}
		return Model.TYPE_DEFAULT;
	}

}
