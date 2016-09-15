package persistency;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import vehicles.Vehicle;

public class Persistency {

	/**
	 * Writes Vehicle in file without deleting the previous content
	 */
	public void writeToFile(Vehicle vehicle) {
		try {
			File file = new File("vehicles.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(vehicle.toString());
			bw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}