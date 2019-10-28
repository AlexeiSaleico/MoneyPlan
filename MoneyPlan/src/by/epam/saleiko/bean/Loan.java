package by.epam.saleiko.bean;

import java.io.Serializable;
import java.util.Date;

public class Loan implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int amount;
	private String description;
	private Date date;
	
	public Loan(int id, int amount, String description, Date date){
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.date = date;
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

	public void setName(Date date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Override 
	public String toString() {
		return getId() + "/" + amount + "/" + description + "/" + date.getTime();
	}
}
