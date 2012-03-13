package org.billing.logic;

import java.util.LinkedList;
import java.util.List;

public class Table {

	private static Table table;
	
	private List<Seat> seats;
	private Bill bill;	
		
	public Bill getBill() {
		return bill;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void resetSeats(int numberOfSeats)
	{
		this.seats = new LinkedList<Seat>();
		for(int i = 0; i < numberOfSeats; ++i)
		{
			this.seats.add(new Seat());
		}
	}
	
	public static synchronized Table getInstance()
	{
		if ( table == null )
		{
			table = new Table();
			return table;
		}
		
		return table;
	}
	
	private Table() 
	{
		this.bill = new Bill();
		this.seats = new LinkedList<Seat>();		
	}
}