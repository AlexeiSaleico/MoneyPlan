package by.epam.saleiko.service;

import java.util.Date;

import by.epam.saleiko.bean.User;
import by.epam.saleiko.dao.DAOFactory;
import by.epam.saleiko.dao.NoteDAO;
import by.epam.saleiko.service.exception.ServiceException;
import by.epam.saleiko.service.util.StringCheck;

public class ClientServiceImpl implements ClientService {
	User user;
	NoteDAO noteDAO;
	ClientServiceImpl(){
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		NoteDAO noteDAO = daoObjectFactory.getNoteDAO();
	}
	
	@Override
	public void signIn(String login, String password, email, number) throws ServiceException {
		
	}

	@Override
	public void register(String login, String password, String email, String number) throws ServiceException {
		if (StringCheck.hasForbiddenCharacters(login, password, email, number)) {
			throw new ServiceException();
		}else {
			noteDAO.register(login, password, email, number);
		}
	}

	@Override
	public void deleteUser() throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createLoan(int id, int amount, String description, Date date) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void payLoan(int id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLoan(int id) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getLoansAfter(Date date) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createPayment(int id, int value, String description, Date date) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPaymentsAfter(Date date) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLoan() throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int monthlyExpenses() throws ServiceException {
		// TODO Auto-generated method stub
		return 0;
	}

}
