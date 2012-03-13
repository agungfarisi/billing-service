package org.billing.logic;

import java.util.LinkedList;
import java.util.List;

public class Seat {

	private List<Item> itemsList;
	private String name;
	
	public Seat()
	{
		this.itemsList = new LinkedList<Item>();
	}
	
	public void addItem(Item newItem)
	{
		for(Item currItem : itemsList)
		{
			if(currItem.getDescription().equals(newItem.getDescription()))
			{
				currItem.increaseQuantity(newItem.getQuantity());
				return;
			}
		}
		
		this.itemsList.add(newItem);
	}
	
	public double getCalculatedPrice()
	{	
		double total = 0;
		for(Item currItem : itemsList)
		{
			total += currItem.getTotalPrice();				
		}
		
		return total;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
