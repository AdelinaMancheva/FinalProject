package vehicles;

import engines.Engine;
import models.Model;
import transmissions.Transmission;

public class SUV extends Vehicle {
	
	private VINGenerator vinGenerator = new VINGenerator();

	private Model model;
	private Engine engine;
	private Transmission transmission;
	
	public SUV(Model model, Engine engine, Transmission transmission){
		super(model, engine, transmission);
		this.model = model;
		this.engine = engine;
		this.transmission = transmission;
	}
	
	@Override
	public String toString() {
		return "VIN: " + vinGenerator.generateVIN()
				+ model
				+ engine
				+ transmission
				+ "\n";
	}

}
