package Program;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Controle.Product_Controller;
import Entidades.Product;
import Persistence.Products_Persistence;

public class Main {
	public static Products_Persistence persitedProducts = new Products_Persistence();
	public static void registerAnProduct(Scanner sc) {
		System.out.print("Common,Used or Imported (c/u/i)?");
		char tipo = sc.next().toUpperCase().charAt(0);
		System.out.print("Name:");
		String name = sc.next();
		System.out.print("Price:");
		Double price = Double.parseDouble(sc.next());
		if (tipo == 'C')
			Product_Controller.registerAProduct(persitedProducts, name, price);
		else if (tipo == 'I') {
			System.out.print("Customs Fee:");
			Double fee = Double.parseDouble(sc.next());
			Product_Controller.registerAProduct(persitedProducts, name, price, fee);
		} else if (tipo == 'U') {
			System.out.print("Manufacture date(YYYY/MM/DD):");
			@SuppressWarnings("deprecation")
			Date date = new Date(sc.next());
			Product_Controller.registerAProduct(persitedProducts, name, price, date);
		}
		if(Product_Controller.getProductByName(persitedProducts, name)!=null)
			System.out.print("Success!");
		else
			System.out.print("Fail!");
	}

	public static void searchForAProductByName(Scanner sc) {
		System.out.print("Name:");
		String name = sc.next();
		Product product = Product_Controller.getProductByName(persitedProducts, name);
		System.out.println(product != null ? product.priceTag() : "Product Not Found");
		
	}
	
	public static void  searchAllProducts()
	{
		List<Product> products = Product_Controller.getAllProducts(persitedProducts);
		for (Product product : products)
		{
			System.out.println(product.priceTag());
			System.out.println();
		}
	
	}

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		int op;
		do {

			op = 0;
			System.out.println("----------Menu----------");
			System.out.println("1 - Register an Product");
			System.out.println("2 - Search a product by name");
			System.out.println("3 - Show all products");
			System.out.println("4 - Exit");
			System.out.println("------------------------");
			System.out.print("Option:");
			op = Integer.parseInt(sc.next());
			System.out.println("------------------------");
			switch (op) {
			case 1:
				registerAnProduct(sc);
				break;
			case 2:
				searchForAProductByName(sc);
				break;
			case 3:
				searchAllProducts();
			break;
			case 4:
			System.out.println("See you, thanks!");
			break;
			default:
				System.out.println("Invalid Option!");
				break;
			}
			System.out.println("Press Enter to Continue...");
			try {
				System.in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (op != 4);
		sc.close();
	}

}
