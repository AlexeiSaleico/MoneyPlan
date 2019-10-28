package by.epam.saleiko.dao;

import by.epam.saleiko.bean.User;
import by.epam.saleiko.dao.exception.DAOException;

public interface NoteDAO {
	public User signIn(String login, String password) throws DAOException;
	public void register(String login, String password, String email, String number) throws DAOException;
	public void deleteUser(String login) throws DAOException;
	public void updateInfo(User user) throws DAOException;
	public boolean occupied(String name) throws DAOException;
}
