package org.billing.logic;

import java.util.LinkedList;
import java.util.List;

public class Bill {

	private List<Item> itemsList;
	private int tipPercent;
	
	public Bill() 
	{
		this.itemsList = new LinkedList<Item>();
		this.tipPercent = 0;
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
		
	public Item getItem(String itemDescription)
	{
		for(Item currItem : itemsList)
		{
			if(currItem.getDescription().equals(itemDescription))
			{
				return currItem;
			}
		}
		
		return null;
	}
		
	public List<Item> getItemsList()
	{
		return itemsList;
	}

	public int getTipPercent()
	{
		return tipPercent;
	}

	public void setTipPercent(int tipPercent) 
	{
		this.tipPercent = tipPercent;
	}
}
