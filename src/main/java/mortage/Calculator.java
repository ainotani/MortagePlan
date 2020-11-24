package mortage;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calculator {
	
	public Mortage calculate(Mortage mortage) {
		//laske mortage.getloan
		Double loan = mortage.getLoan();
		Double interest = mortage.getInterest() / 100 /12;
		Integer years = mortage.getYears();
		
		//E = U[b(1 + b)^p]/[(1 + b)^p - 1]
		//Payment = loan[interest(1 + interest)^(years*12)]/[(1 + interest)^(years*12) - 1]

		Double step1 = 1 + interest;
		int i = 0;
		Double step2 = (double) 1;
		Integer numPayments = years * 12;
		while (i < numPayments) {
			step2 = step2 * step1;
		  i++;
		}
		Double step3 = interest * step2;
		Double step4 = step2 - 1;
		Double step5 = step3 / step4;
		Double payment = step5 * loan;
		
		DecimalFormat df = new DecimalFormat("#.00");
		df.setRoundingMode(RoundingMode.UP);
		Double pmt = Double.parseDouble(df.format(payment));
		
		mortage.setPayment(pmt);
		
		return mortage;
	}

}
