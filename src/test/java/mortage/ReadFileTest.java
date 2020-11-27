package mortage;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ReadFileTest {
	@Test
    public void fileNotFoundReturnsEmptyList() {
		ReadFile file = new ReadFile();
		List<Mortage> mortages = file.readFile("prospects2.txt");
		assertEquals(0, mortages.size());
    }
	@Test
	public void convert() {
		ReadFile file = new ReadFile();
		Mortage mortage = file.convertData("a,8,5,6", 0);
		assertEquals("a", mortage.getName());
		assertEquals("8.0", String. valueOf(mortage.getLoan()));
		assertEquals("5.0", String. valueOf(mortage.getInterest()));
		assertEquals("6", String. valueOf(mortage.getYears()));
    }
	@Test
	public void returnNull() {
		ReadFile file = new ReadFile();
		Mortage mortage = file.convertData("...", 1);
		assertEquals(null, mortage);
    }
	
	@Test
	public void returnWrongFormatinfo() {
		ReadFile file = new ReadFile();
		Mortage mortage = file.convertData("a,a,a,a", 1);
		assertEquals(null, mortage);
    }

	@Test
    public void returnNullWhenYearsAre0() {
		ReadFile file = new ReadFile();
		Mortage mortage = file.convertData("a,10,4,0", 1);
		assertEquals(null, mortage);
    }
}
