package by.epam.saleiko.dao.txtImpl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TxtNoteReader implements AutoCloseable {
	
	private FileReader reader;
	private Scanner scan;
	
	public TxtNoteReader(File USER_DATA) throws IOException{
		 reader = new FileReader(USER_DATA);
		 scan = new Scanner(reader);
		 scan.hasNextLine();
	}
	
	public String next() throws IOException{
		return scan.nextLine();
	}
	
	public boolean hasNext() throws IOException{
		return scan.hasNextLine();
	}
	

	@Override
	public void close() throws IOException {
		scan.close();
		reader.close();
	}
}
