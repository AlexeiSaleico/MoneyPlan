package by.epam.saleiko.dao.util;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import by.epam.saleiko.dao.exception.DAOException;

public class IdGenerator {
	private static String ID_FILE = "E://MoneyPlan/hz2.txt";
	
	public static int nextId() throws DAOException{
		
		try (FileReader reader = new FileReader(ID_FILE)){	
			try (Scanner scan = new Scanner(reader)){
					int id = scan.nextInt();
					id++;
					scan.close();
					reader.close();
					try (FileWriter writer = new FileWriter(ID_FILE)){
						writer.write(id);
					}
					return id;
					
			}
		}catch (Exception e) {
			throw new DAOException(e);}
	}
}
