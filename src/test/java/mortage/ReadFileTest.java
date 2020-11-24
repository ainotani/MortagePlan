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
		Mortage mortage = file.convertData("a,8,5,6");
		assertEquals("a", mortage.getName());
    }
}
