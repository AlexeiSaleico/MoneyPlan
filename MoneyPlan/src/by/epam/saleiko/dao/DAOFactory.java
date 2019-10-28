package by.epam.saleiko.dao;

import by.epam.saleiko.dao.txtImpl.TxtNoteDAO;


public final class DAOFactory  {
	private static final DAOFactory instance = new DAOFactory();
	private NoteDAO NoteImpl = new TxtNoteDAO();
	
	public static DAOFactory getInstance() {
		return instance;
	}
	public NoteDAO getNoteDAO(){
		return NoteImpl;
	}
}
