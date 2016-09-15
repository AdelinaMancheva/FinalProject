import static org.junit.Assert.assertFalse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import commands.CreateCmd;

public class PersistencyTest {

	CreateCmd createCmd = new CreateCmd();
	BufferedReader br;

	public void setUp() {
		try {
			br = new BufferedReader(new FileReader("vehicle.txt"));
		} catch (FileNotFoundException e) {
		}
	}

	@Test
	public void testWriteInFile() {
		createCmd.execute("car model=A6-kombi engine=P-180hp-euro3 transmission=Automatic-4");
		try {
			assertFalse(br.readLine() == null);
		} catch (IOException e) {
		}

	}
}
