package by.epam.saleiko.service;

import java.util.ArrayList;
import java.util.Date;

import by.epam.saleiko.bean.Loan;
import by.epam.saleiko.bean.Payment;
import by.epam.saleiko.bean.User;
import by.epam.saleiko.dao.DAOFactory;
import by.epam.saleiko.dao.NoteDAO;
import by.epam.saleiko.dao.exception.DAOException;
import by.epam.saleiko.dao.util.IdGenerator;
import by.epam.saleiko.service.exception.ServiceException;
import by.epam.saleiko.service.util.StringCheck;

public class ClientServiceImpl implements ClientService {
	NoteDAO noteDAO;
	ClientServiceImpl(){
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		noteDAO = daoObjectFactory.getNoteDAO();	
	}
	
	@Override
	public User signIn(String login, String password) throws ServiceException {
		try {
			return noteDAO.signIn(login, password);
		} catch (DAOException e) {
			throw new ServiceException();
		}
	}

	@Override
	public void register(String login, String password, String email, String number) throws ServiceException {
		if (StringCheck.hasForbiddenCharacters(login, password, email, number)) {
			throw new ServiceException();
		}else {
			try {
				noteDAO.register(login, password, email, number);
			} catch (Exception e) {
				throw new ServiceException();
			}
		}
	}

	@Override
	public void createLoan(User user, int amount, String description, Date date) throws ServiceException {
		try {
			if (StringCheck.hasForbiddenCharacters(description)) {
				throw new ServiceException();
			}
			ArrayList<Loan> loans = user.getLoans();
			loans.add( new Loan(amount, IdGenerator.nextId(), description , date));
			user.setLoans(loans);
		} catch (Exception e) {
			throw new ServiceException();
		}
	}
	
	@Override
	public void deleteLoan(User user, int id) throws ServiceException {
		ArrayList<Loan> loans = user.getLoans();
		for(Loan loan : loans) {
			if (loan.getId() == id) { loans.remove(loan);
			}
		}
		user.setLoans(loans);
	}
	
	@Override
	public String getPaymentsAfter(User user, Date date) throws ServiceException {
		String result = "";
		ArrayList<Payment> payments = user.getPayments();
		for(Payment payment : payments) {
			if (payment.getDate().compareTo(date) > 0) { result += payment.getValue() + "\n" + payment.getDescription();
			}
		}
		return result;
	}

	@Override
	public void deletePayment(User user, int id) throws ServiceException {
		ArrayList<Payment> payments = user.getPayments();
		for(Payment payment : payments) {
			if (payment.getId() == id) { payments.remove(payment);
			}
		}
		user.setPayments(payments);
		
	}

	@Override
	public String getLoansAfter(User user, Date date) throws ServiceException {
		String result = "";
		ArrayList<Loan> loans = user.getLoans();
		for(Loan loan : loans) {
			if (loan.getDate().compareTo(date) > 0) { result += loan.getAmount() + "\n" + loan.getDescription();
			}
		}
		return result;
	}

	@Override
	public void deleteUser(String login) throws ServiceException {
		try {
			noteDAO.deleteUser(login);
		} catch (Exception e) {
			throw new ServiceException();
		}
	}

	@Override
	public int monthlyExpenses(User user) throws ServiceException {
		int sum = 0;
		for (Payment payment : user.getPayments()) {
			sum += payment.getValue();
		}
		return sum;
	}

	@Override
	public void save(User user) throws ServiceException {
		try {
			noteDAO.updateInfo(user);
		} catch (Exception e) {
			throw new ServiceException();
		}
	}

	@Override
	public void payLoan(User user, int id, int value) throws ServiceException {
		ArrayList<Loan> loans = user.getLoans();
		for(Loan loan : user.getLoans()) {
			if (loan.getId() == id) {
				int newAmount = loan.getAmount() - value;
				createPayment(user, value, loan.getDescription(), loan.getDate());
				if (newAmount <= 0) {
					deleteLoan(user, id);
				} else {
					loan.setAmount(newAmount);
				}
			}
		}
		user.setLoans(loans);
	}

	@Override
	public void createPayment(User user, int value, String description, Date date) throws ServiceException {
		try {
			if (StringCheck.hasForbiddenCharacters(description)) {
				throw new ServiceException();
			}
			ArrayList<Payment> payments = user.getPayments();
			payments.add( new Payment(value, IdGenerator.nextId(), description , date));
			user.setPayments(payments);
		} catch (Exception e) {
			throw new ServiceException();
		}
	}
}
