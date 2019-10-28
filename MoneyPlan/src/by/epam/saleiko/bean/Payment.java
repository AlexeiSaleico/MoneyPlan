package by.epam.saleiko.bean;

import java.io.Serializable;
import java.util.Date;

public class Payment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int value;
	private String description;
	private Date date;
	
	
	public Payment(int id, int value, String description, Date date){
		this.id = id;
		this.value = value;
		this.setDescription(description);
		this.setDate(date);
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override 
	public String toString() {
		return getId() + "/" + value + "/" + description + "/" + date.getTime();
	}

}
