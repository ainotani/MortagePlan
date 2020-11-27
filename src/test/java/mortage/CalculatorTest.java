package mortage;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
	@Test
    public void calculatorSetsCorrectPayment() {
		Mortage mortage = createMortage("Paavali", 10000.0, 5.0, 2);
		Calculator calc = new Calculator();
		Mortage calculated = calc.calculate(mortage);
		assertEquals("438.71", String. valueOf(calculated.getPayment()));
    }
	@Test
    public void calculatorSetsCorrectPaymentWhenInterestIs0() {
		Mortage mortage = createMortage("Paavali", 1000.0, 0.0, 2);
		Calculator calc = new Calculator();
		Mortage calculated = calc.calculate(mortage);
		assertEquals("41.67", String. valueOf(calculated.getPayment()));
    }
	
	private Mortage createMortage(String name, Double loan, Double interest, Integer years) {
		Mortage mortage = new Mortage();
		mortage.setName(name);
		mortage.setLoan(loan);
		mortage.setInterest(interest);
		mortage.setYears(years);
		return mortage;
	}
	
}
