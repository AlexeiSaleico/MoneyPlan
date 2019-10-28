package by.epam.saleiko.bean;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String number;
	private ArrayList<Loan> loans = new ArrayList<Loan>();
	private ArrayList<Payment> payments = new ArrayList<Payment>();
	
	
	public User(String name, String email, String number, ArrayList<Loan> loans, ArrayList<Payment> payments){
		this.name = name;
		this.email = email;
		this.number = number;
		this.setLoans(loans);
		this.setPayments(payments);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	public ArrayList<Loan> getLoans() {
		return loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		this.loans = loans;
	}

	public ArrayList<Payment> getPayments() {
		return payments;
	}

	public void setPayments(ArrayList<Payment> payments) {
		this.payments = payments;
	}
	
	@Override
	public String toString() {
		String loanStr = "";
		for (Loan loan : loans) {
			loanStr += loan.toString() + "/";
		}
		String paymentStr = "";
		for (Payment payment : payments) {
			paymentStr += payment.toString() + "/";
		}
		return name + "#" + email + "#" + number + "#" + loanStr + "#" + paymentStr;
	}
}
