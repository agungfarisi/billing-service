package org.billing.logic;

import java.util.LinkedList;
import java.util.List;

public class Seat {

	public static String SEAT_DEFAULT_NAME_PREFIX = "Seat#";
	
	private List<Item> itemsList;
	private String name;
	
	public Seat(String name)
	{
		this.itemsList = new LinkedList<Item>();
		this.name = name;
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
	
	public void removeItem(String itemDescription)
	{
		for(Item currItem : itemsList)
		{
			if(currItem.getDescription().equals(itemDescription))
			{
				this.itemsList.remove(currItem);
				return;
			}
		}
	}
	
	public double getCalculatedTip(int tipPercent)
	{
		double total = getCalculatedPrice();
		
		return (total * (tipPercent / 100));
	}
	
	public double getCalculatedPrice(int tipPercent)
	{
		double total = getCalculatedPrice();
		
		return (total * (1 + (tipPercent / 100)));
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
	
	public void clear()
	{
		this.itemsList = new LinkedList<Item>();
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
