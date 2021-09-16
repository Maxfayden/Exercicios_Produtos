package Controle;

import java.util.Date;
import Entidades.ImportedProduct;
import Entidades.Product;
import Entidades.UsedProduct;
import Persistence.Products_Persistence;

public class Product_Controller {

	public static void registerAProduct(Products_Persistence registredProducts, String name, Double price) {

		registredProducts.AddProduct(new Product(name, price));
	}

	public static void registerAProduct(Products_Persistence registredProducts, String name, Double price,
			Double customsFee) {

		registredProducts.AddProduct(new ImportedProduct(name, price, customsFee));
	}

	public static void registerAProduct(Products_Persistence registredProducts, String name, Double price, Date date) {

		registredProducts.AddProduct(new UsedProduct(name, price, date));
	}

	public static Product getProductByName(Products_Persistence registredProducts, String name) {
		return registredProducts.getRegistredProducts().stream().filter(p -> p.getName().equals(name)).iterator()
				.next();
	}

	public static java.util.List<Product> getAllProducts(Products_Persistence registredProducts) {

		return registredProducts.getRegistredProducts();

	}
}
