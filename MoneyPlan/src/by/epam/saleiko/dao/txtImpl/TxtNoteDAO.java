package by.epam.saleiko.dao.txtImpl;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import by.epam.saleiko.bean.User;
import by.epam.saleiko.dao.NoteDAO;
import by.epam.saleiko.dao.exception.DAOException;
import by.epam.saleiko.service.util.Converter;

public class TxtNoteDAO implements NoteDAO {
	private File USER_DATA = new File("E://MoneyPlan/hz.txt");	
	
	@Override
	public User signIn(String login, String password) throws DAOException {
		try (TxtNoteReader reader = new TxtNoteReader(USER_DATA)){	
			while (reader.hasNext()) {
				String[] note = reader.next().split("#");
				if (note.length > 1 && note[0] == login && note[1] == password) {
					return new User(note[0], note[2], note[3], Converter.toLoans(note[4]), Converter.toPayments(note[5]));
				}
			}
		}catch (Exception e) {
			throw new DAOException(e);}
		return null;
	}


	@Override
	public void deleteUser(String login) throws DAOException {
		try (TxtNoteReader reader = new TxtNoteReader(USER_DATA)){
			ArrayList <String> notes = new ArrayList<String>();
			FileWriter writer = new FileWriter(USER_DATA);
			while (reader.hasNext()) {
				notes.add(reader.next());
				}	
			writer.write("");
			for(int i = 0  ; i < notes.size(); i++) {
				if(notes.get(i).split("#").length > 1 && 
						notes.get(i).split("#")[0].equals(login)) {
					continue;}
				writer.append(notes.get(i) + "\n");
			}
			writer.close();
		}catch (Exception e) {
			throw new DAOException(e);}
	}

	@Override
	public void register(String login, String password, String email, String number) throws DAOException {
		try(FileWriter writer = new FileWriter(USER_DATA);){
			if (occupied(login))
			writer.append(login + "#" + password + "#" + email + "#" + number + "#");
		}catch (Exception e){
			throw new DAOException(e);}
	}

	@Override
	public void updateInfo(User user) throws DAOException {
		try (TxtNoteReader reader = new TxtNoteReader(USER_DATA)){	
			ArrayList <String> notes = new ArrayList<String>();
			FileWriter writer = new FileWriter(USER_DATA);
			while (reader.hasNext()) {
				notes.add(reader.next());
				}	
			writer.write("");
			for(String note : notes) {
				if(note.split("#").length > 0 && note.split("#")[0] == user.getName()) {
					note = user.toString();
				}
				writer.append(note + "\n");
			}
			writer.close();
			}catch (Exception e) {
			throw new DAOException(e);
			}
	}


	@Override
	public boolean occupied(String name) throws DAOException {
		try (TxtNoteReader reader = new TxtNoteReader(USER_DATA)){	
			while (reader.hasNext()) {
				if (reader.next().split("#")[0] == name) {
					return true;
				}
			}
		}catch (Exception e) {
			throw new DAOException(e);
		}
		return false;
	}
}