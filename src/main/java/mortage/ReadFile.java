package mortage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFile {
	public List<Mortage> readFile(String fileName) {
		List<Mortage> mortages = new ArrayList<Mortage>();
        ClassLoader classLoader = getClass().getClassLoader();
		try {
			File file = new File(classLoader.getResource(fileName).getFile());
			Scanner scanner = new Scanner(new FileInputStream(file), "UTF-8");
			String header = scanner.nextLine();
			int lineNumber = 1;
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				lineNumber++;
				if (!data.equals("")) {
					Mortage mortage = convertData(data, lineNumber);
					mortages.add(mortage);
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (NoSuchElementException ne) {
			System.out.println("File is empty.");
		} catch (NullPointerException nulle) {
			System.out.println("File not found.");
		}
		return mortages;
	}
	
	public Mortage convertData(String data, int lineNumber) {
		Mortage mortage = new Mortage();
		
		try {
			//split string into 4 parts
			String[] splitted = data.split(",");
			String part1 = splitted[0];
			String part2 = splitted[1];
			String part3 = splitted[2];
			String part4 = splitted[3];
			if (part4.contentEquals("0")) {
				System.out.println("On line: "+ lineNumber + " Years can't be 0");
				return null;
			}
			//convert parts into right format
			mortage.setName(part1);
			mortage.setLoan(Double.parseDouble(part2));
			mortage.setInterest(Double.parseDouble(part3));
			mortage.setYears(Integer.parseInt(part4));
		} catch (NumberFormatException e) {
			System.out.println("On line: "+ lineNumber + " Wrong format. NumberFormatException");
			return null;
		} catch (IndexOutOfBoundsException ie) {
			System.out.println("On line: "+ lineNumber + " Wrong format. IndexOutOfBoundsException");
			return null;
		}
		return mortage;
	}
}
