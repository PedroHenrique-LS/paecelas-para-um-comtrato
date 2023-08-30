package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	private LocalDate date;
	private double amount;
	private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Installment(LocalDate date, double amount) {
		super();
		this.date = date;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return  date.format(fmt) + " - " + amount;
	}
	
	
	
	
	
}
