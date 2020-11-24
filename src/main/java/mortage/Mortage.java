package mortage;

public class Mortage {
	String name;
	Double loan;
	Double interest;
	Integer years;
	Double payment;
	
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLoan() {
		return loan;
	}
	public void setLoan(Double loan) {
		this.loan = loan;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}

}
