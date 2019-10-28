package by.epam.saleiko.service;

import java.util.Date;

import by.epam.saleiko.bean.User;
import by.epam.saleiko.service.exception.ServiceException;

public interface ClientService {
	public User signIn(String login, String password) throws ServiceException;
	public void register(String login, String password, String email, String number) throws ServiceException;
	public void deleteUser(String login) throws ServiceException;
	public void createLoan(User user, int amount, String description, Date date) throws ServiceException;
	public void payLoan(User user, int id,int value) throws ServiceException;
	public void deleteLoan(User user, int id) throws ServiceException;
	public String getLoansAfter(User user, Date date) throws ServiceException;
	public void createPayment(User user, int value, String description, Date date) throws ServiceException;
	public String getPaymentsAfter(User user, Date date) throws ServiceException;
	public void deletePayment(User user, int id) throws ServiceException;
	public int monthlyExpenses(User user) throws ServiceException;
	public void save(User user) throws ServiceException;
}
