package Entidades;

import java.util.Date;

public class UsedProduct extends Product{
	private Date Date;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, java.util.Date date) {
		super(name, price);
		Date = date;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}
	
	@Override
	public String priceTag()
	{
		return "Name: " + getName() + "\nPrice: " + getPrice()+"\nDate: "+this.Date.toString();
	}

	@Override
	public String toString() {
		return "UsedProduct [Date=" + Date + ", getDate()=" + getDate() + ", priceTag()=" + priceTag() + "]";
	}

}
