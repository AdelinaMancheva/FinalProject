package manufactory;

import java.util.HashMap;
import java.util.Map;

public class ManufactoryTables {

	/**
	 * Table with different manufactories in BG (for future extensions)
	 */
	private Map<String, Manufactory> MANUFACTRORY_TABLE_BG = new HashMap<String, Manufactory>() {
		private static final long serialVersionUID = 1L;

		{
			put("manufactory1", new Manufactory(1, "BG"));
		}
	};;

	public Map<String, Manufactory> getManufactoryTableBG() {
		return this.MANUFACTRORY_TABLE_BG;
	}

}
