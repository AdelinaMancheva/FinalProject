import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import commands.CreateCmd;

/**
 * @author AMancheva
 * 
 *         Contains test for {@link CreateCmd}
 *
 */
public class CreateCmdTest {

	CreateCmd createCmd = new CreateCmd();

	@Test
	public void testGetCommandName() {
		assertEquals("create", createCmd.getCommandName());
	}

	@Test
	public void testExecuteWithInvalidPowerWithTurbo() {
		assertFalse(createCmd.execute("car model=A5 engine=P-74hp-T-euro4 transmission=Automatic-4"));
	}

	@Test
	public void testExecuteWithValidStringWithoutTurbo() {
		assertTrue(createCmd.execute("car model=A5-kombi engine=P-180hp-euro4 transmission=Automatic-4"));
	}

	@Test
	public void testExecuteWithInvalidEngineType() {
		assertFalse(createCmd.execute("car model=A5 engine=J-180hp-euro3 transmission=Automatic-4"));
	}

	@Test
	public void testExecuteWithInvalidModel() {
		assertFalse(createCmd.execute("car model=A engine=250hp-euro3 transmission=Automatic-4"));
	}

	@Test
	public void testExecuteWithInvalidType() {
		assertFalse(createCmd.execute("car model=A-type engine=250hp-euro3 transmission=Automatic-4"));
	}

	@Test
	public void testExecuteWithInvalidTransmission() {
		assertFalse(createCmd.execute("car model=A-type engine=250hp-euro3 transmission=Autoatic-4"));
		assertFalse(createCmd.execute("car model=A-type engine=250hp-euro3 transmission=Automatic-9"));
	}

	@Test
	public void testWithInvalidStrings() {
		assertFalse(createCmd.execute("car"));
		assertFalse(createCmd.execute("car model-A6"));
		assertFalse(createCmd.execute("car model=A6 enginr"));
		assertFalse(createCmd.execute("car model=A6 engine=P"));
		assertFalse(createCmd.execute("car model=A6 engine=P-180"));
		assertFalse(createCmd.execute("car model=A6 engine=P-180hp-euro3"));
		assertFalse(createCmd.execute("car model=A6 engine=P-180hp-euro3 transmission"));
		assertFalse(createCmd.execute("car model=A6 engine=P-180hp-euro3 transmission="));
		assertFalse(createCmd.execute("car model=A6 engine=P-180hp-euro3 transmission=Automatic-9"));
		assertFalse(createCmd.execute("car model=A6 engine=P-180hp-euro3 transmission=Automatic-9"));
	}

	@Test
	public void testExecuteWithValidStrings() {
		assertTrue(createCmd.execute("car model=A6-kombi engine=P-180hp-euro3 transmission=Automatic-4"));
		assertTrue(createCmd.execute("car model=A5-kombi engine=E-180hp-euro4 transmission=Automatic-6"));
	}

	/* Testing private methods */

	// @Test
	// public void testCreateModelWithInvalidModel() {
	// model = createCmd.createModelWithType("jjj", "sedan");
	// assertNull(model);
	// }
	//
	// @Test
	// public void testCreateModelWithValidModel() {
	// model = createCmd.createModelWithType("A6", "sedan");
	// assertNotNull(model);
	// }
	//
	// @Test
	// public void testCreateModelWithInvalidType() {
	// model = createCmd.createModelWithType("A6", "jjjjjj");
	// assertNull(model);
	// }
	//
	// @Test
	// public void testCreatePetrolEngine() {
	// engine = createCmd.createEngine("P", 180, true, "euro3");
	// assertNotNull(engine);
	// }
	//
	// @Test
	// public void testCreateDieselEngineWithInvalidPower() {
	// engine = createCmd.createEngine("D", 55, true, "euro3");
	// assertNull(engine);
	// }
	//
	// @Test
	// public void testCreateDieselEngineWithValidPower() {
	// engine = createCmd.createEngine("D", 180, true, "euro3");
	// assertNotNull(engine);
	// }
	//
	// @Test
	// public void testCreateElectricEngine() {
	// engine = createCmd.createEngine("E", 180, true, "euro3");
	// assertNotNull(engine);
	// }
	//
	// @Test
	// public void testCreateEngineWithInvalidEuroStandard() {
	// engine = createCmd.createEngine("P", 180, true, "euro6");
	// assertNull(engine);
	// }
	//
	// @Test
	// public void testCreateInvalidEngine() {
	// engine = createCmd.createEngine("KKKKKK", 55, true, "euro3");
	// assertNull(engine);
	// }
	//
	// @Test
	// public void testCreateEngineWithInvalidPower() {
	// engine = createCmd.createEngine("P", 55, true, "euro3");
	// assertNull(engine);
	// }
	//
	// @Test
	// public void testCreateSUVWithValidModel() {
	// vehicle = createCmd.createSUV(new Model("Q1"), new PetrolEngine());
	// assertNotNull(vehicle);
	// }

}
