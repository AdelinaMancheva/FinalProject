package commands;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import engines.DieselEngine;
import engines.ElectricEngine;
import engines.Engine;
import engines.PetrolEngine;
import models.Model;
import persistency.Persistency;
import transmissions.AutomaticTransmission;
import transmissions.ManualTransmission;
import transmissions.Transmission;
import validations.CommandValidation;
import validations.CreateInputValidation;
import validations.EngineInputValidation;
import validations.EnginePowerValidation;
import validations.ModelValidation;
import validations.TransmissionValidation;
import vehicles.Car;
import vehicles.SUV;
import vehicles.Vehicle;

/**
 * @author AMancheva
 * 
 *         Creates object and writes it in file. 
 *         Expected input: create car model=A6 engine=P|D|E-180hp{-T}-euro4 transmission=Manual|Automatic-4
 *         Optional: T
 */
public class CreateCmd implements BaseCommand {

	private static final String COMMAND_NAME = "create";

	private final Lock mutex = new ReentrantLock(true);
	private Persistency persist = new Persistency();

	EnginePowerValidation enginePowerValid = new EnginePowerValidation();
	EngineInputValidation engineInputValid = new EngineInputValidation();
	CreateInputValidation crateValid = new CreateInputValidation();
	ModelValidation modelValid = new ModelValidation();
	TransmissionValidation transmValid = new TransmissionValidation();
	CommandValidation cmdValid = new CommandValidation();

	public CreateCmd() {
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

	/**
	 * @return object of type Model, if validations passed
	 */
	private Model createModel(String vehicle, String model, String type) {
		if (vehicle.equals("car")) {
			if (crateValid.validateCarModel(model) && crateValid.validateCarType(type)) {
				return new Model(model, type);
			}
		} else if (vehicle.endsWith("suv")) {
			if (crateValid.validateSUVModel(model)) {
				return new Model(model);
			}
		}
		return null;
	}

	/**
	 * @return object of type Engine, if validations passed
	 */
	private Engine createEngine(String engineType, int hp, boolean t, String euro) {
		int kw = enginePowerValid.convertHorsePowerToKw(hp);
		if (engineInputValid.validateEngineParameters(engineType, kw, t, euro)) {
			if (engineType.equals("P")) {
				return new PetrolEngine(kw, t, euro);
			} else if (engineType.equals("D") && enginePowerValid.validatePowerForDiesel(hp, t)) {
				return new DieselEngine(kw, t, euro);
			} else if (engineType.equals("E")) {
				return new ElectricEngine(kw);
			}
		}
		return null;
	}

	/**
	 * @return object of type Transmission, if validations passed
	 */
	private Transmission createTransmission(String type, int gears) {
		if (crateValid.validateTransmType(type)) {
			if (type.equals("Automatic") && transmValid.validateGearsForAutomatic(gears)) {
				return new AutomaticTransmission(gears);

			} else if (type.equals("Manual") && transmValid.validateGearsForManual(gears)) {
				return new ManualTransmission(gears);
			}
		}
		return null;
	}

	private Vehicle createCar(Model model, Engine engine, Transmission transm) {
		return new Car(model, engine, transm);
	}

	private Vehicle createSUV(Model model, Engine engine, Transmission transm) {
		return new SUV(model, engine, transm);
	}

	/**
	 * @param v - type of vehicle e.g car, suv
	 * @return Vehicle
	 */
	private Vehicle createVehicle(String v, Model m, Engine e, Transmission t) {
		if (v.equals("car") && m != null && e != null) {
			return createCar(m, e, t);

		} else if (v.equals("suv") && m != null && e != null) {
			return createSUV(m, e, t);
		}
		return null;
	}

	@Override
	public boolean execute(String args) {

		Model m = null;
		Engine e = null;
		Vehicle v = null;
		Transmission t = null;

		String[] splittedArgs = args.split(" ");
		if (!cmdValid.validateCreateByLength(splittedArgs)) {
			return false;
		}
		String vehicle = splittedArgs[0];
		String modelInfo = splittedArgs[1];
		String engineInfo = splittedArgs[2];
		String transmInfo = splittedArgs[3];

		if (modelValid.validateModelString(modelInfo)) {
			m = createModel(vehicle, 
					modelValid.getModel(modelInfo), 
					modelValid.getType(modelInfo));
		}

		if (engineInputValid.validateEngineString(engineInfo)) {
			e = createEngine(
					engineInputValid.getEngineType(engineInfo), 
					engineInputValid.getPower(engineInfo),
					engineInputValid.hasTurbo(engineInfo), 
					engineInputValid.getEuroStandard(engineInfo));
		}

		if (transmValid.validateTransmissionString(transmInfo)) {
			t = createTransmission(
					transmValid.getTransmType(transmInfo), 
					transmValid.getTransmGears(transmInfo));
		}

		v = createVehicle(vehicle, m, e, t);

		if (m != null && e != null && v != null && t != null) {

			mutex.lock();
			persist.writeToFile(v);
			mutex.unlock();
			return true;

		} else {
			return false;
		}
	}

}
