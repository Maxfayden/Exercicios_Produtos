package Persistence;

import java.util.ArrayList;
import java.util.List;

import Entidades.Product;

public class Products_Persistence {

	private List<Product> registredProducts = new ArrayList<>();

	public Products_Persistence() {

	}
	
	public Products_Persistence(List<Product> registredProducts) {
		this.registredProducts = registredProducts;
	}

	public boolean AddProduct(Product product) {
		boolean flCanADD = product != null
				&& !this.registredProducts.stream().anyMatch(p -> p.getName() == product.getName());
		if (flCanADD)
			this.registredProducts.add(product);
		return flCanADD;
	}
	
	public List<Product> getRegistredProducts()
	{
		return this.registredProducts;
	}

}
