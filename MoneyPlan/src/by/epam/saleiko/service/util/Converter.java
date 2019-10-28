package by.epam.saleiko.service.util;

import java.util.Date;
import java.util.ArrayList;

import by.epam.saleiko.bean.Loan;
import by.epam.saleiko.bean.Payment;
import by.epam.saleiko.service.exception.ServiceException;

public class Converter {
	public static ArrayList<Loan> toLoans(String input) throws ServiceException{
		String[] loanParts = input.split("/");
		ArrayList<Loan> result = new ArrayList<Loan>();
		for(int i = 0; i < loanParts.length; i += 4) {
			int id = Integer.parseInt(loanParts[i]);
			int amount = Integer.parseInt(loanParts[i+1]);
			String description = loanParts[i+2];
			Date date =  new Date(Integer.parseInt(loanParts[i+3]));
			result.add(new Loan(id, amount, description, date));
		}
		return result;
	}
	public static ArrayList<Payment> toPayments(String input) throws ServiceException{
		String[] paymentParts = input.split("/");
		ArrayList<Payment> result = new ArrayList<Payment>();
		for(int i = 0; i < paymentParts.length; i += 4) {
			int id = Integer.parseInt(paymentParts[i]);
			int amount = Integer.parseInt(paymentParts[i+1]);
			String description = paymentParts[i+2];
			Date date =  new Date(Integer.parseInt(paymentParts[i+3]));
			result.add(new Payment(id, amount, description, date));
		}	
		return result;
	}
}
