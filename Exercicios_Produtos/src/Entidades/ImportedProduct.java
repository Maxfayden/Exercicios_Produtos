package Entidades;

public class ImportedProduct extends Product {

	private Double costomsFee;

	public ImportedProduct() {
	}

	public ImportedProduct(String name, Double price, Double costomsFee) {
		super(name, price);
		this.costomsFee = costomsFee;
	}

	public Double getCostomsFee() {
		return costomsFee;
	}

	public void setCostomsFee(Double costomsFee) {
		this.costomsFee = costomsFee;
	}

	@Override
	public String priceTag() {
		return "Name: " + getName() + "\nPrice: " + getPrice() + this.costomsFee + "\nCostumsFee: " + this.costomsFee;
	}

	public double totalPrice() {
		return this.costomsFee + getPrice();
	}

	@Override
	public String toString() {
		return "ImportedProduct [costomsFee=" + costomsFee + ", getCostomsFee()=" + getCostomsFee() + ", priceTag()="
				+ priceTag() + ", totalPrice()=" + totalPrice() + ", getName()=" + getName() + ", getPrice()="
				+ getPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
