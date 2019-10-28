package by.epam.saleiko.service;

import java.util.Date;

import by.epam.saleiko.service.exception.ServiceException;

public interface ClientService {
	public void signIn(String login, String password) throws ServiceException;
	public void register(String login, String password, String email, String number) throws ServiceException;
	public void deleteUser(User user) throws ServiceException;
	public void createLoan(int id, int amount, String description, Date date) throws ServiceException;
	public void payLoan(int id) throws ServiceException;
	public void deleteLoan(int id) throws ServiceException;
	public String getLoansAfter(Date date) throws ServiceException;
	public void createPayment(int id, int value, String description, Date date) throws ServiceException;
	public String getPaymentsAfter(Date date) throws ServiceException;
	public void deleteLoan() throws ServiceException;
	public int monthlyExpenses() throws ServiceException;
}
