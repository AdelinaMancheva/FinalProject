package vehicles;
import engines.Engine;
import models.Model;
import transmissions.Transmission;

public abstract class Vehicle {
	
	private Engine engine;
	private Model model;
	private Transmission transmission;
	
	public Vehicle(Model model, Engine engine, Transmission transmission){
		this.model = model;
		this.engine = engine;
		this.transmission = transmission;
	}
	
}
