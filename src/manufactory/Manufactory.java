package manufactory;

/**
 * @author AMancheva
 *
 */
public class Manufactory {

	private int numberOfManufactory;
	private String country;

	public Manufactory() {
		this.numberOfManufactory = 1;
		this.country = "BG";
	}

	public Manufactory(int numberOfManufactory, String country) {
		this.numberOfManufactory = numberOfManufactory;
		this.country = country;
	}

	/**
	 * @return the first three symbols of VIN (country and number of
	 *         manufactory)
	 */
	public String getCodeVIN() {
		return new String(country + numberOfManufactory);
	}

}
