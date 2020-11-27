package mortage;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MortageMain {

	public static void main(String[] args) {
		ReadFile file = new ReadFile();
		Calculator calculator = new Calculator();
		List<Mortage> mortages = file.readFile(args[0]);
		List<Mortage> calculatedMortages = new ArrayList<Mortage>();
		List<String> mortagesToBePrinted = new ArrayList<String>();
		//remove nulls
		while (mortages.remove(null)) { 
        } 
		for (int i = 0; i < mortages.size(); i++) {
			calculatedMortages.add(calculator.calculate(mortages.get(i)));
			mortagesToBePrinted.add(formatOutput(mortages.get(i)));
        }
		System.out.println("");
		for(int i = 0; i < mortagesToBePrinted.size(); i++) {
            System.out.println("Prospect "+ (i+1) + ": " + mortagesToBePrinted.get(i));
        }
		
	}
	public static String formatOutput(Mortage mortage) {
		//Prospect 1: CustomerName wants to borrow X € for a period of Z years and pay E € each month
		String name = mortage.getName();
		String years = Integer.toString(mortage.getYears());
		String payment = Double.toString(mortage.getPayment());
		DecimalFormat df = new DecimalFormat("#.00");
		df.setRoundingMode(RoundingMode.HALF_UP);
		String loan2 = df.format(mortage.getLoan());
		String output = name + " wants to borrow " + loan2 + " € for a period of " + years + " years and pay " + payment + " € each month";
		return output;
	}

}
