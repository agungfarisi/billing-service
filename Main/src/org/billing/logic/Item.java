package org.billing.logic;


public class Item {

	private final String description;
	private final double singleItemPrice;
	private int quantity;	
	
	public Item(String desc, int quantity, double singleItemPrice)
	{
		this.description = desc;
		this.quantity = quantity;
		this.singleItemPrice = singleItemPrice;
	}
	
	public void increaseQuantity(int increaseBy)
	{
		this.quantity += increaseBy;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public int getQuantity()
	{
		return this.quantity;
	}
	
	public double getSingleItemPrice()
	{
		return this.singleItemPrice;
	}
	
	public double getTotalPrice()
	{
		return (this.quantity * this.singleItemPrice);
	}
}