// 15th Oct 

/*
You are given a list of Product objects with fields name, category, and price. 
Write a Given a list of Product objects with the following fields:
	- name (String)
	- category (String)
	- price (double)
	- quantityInStock (int)
	
Write a program to filter products where the stock is more than 5 units.
Then group the products by their category, then find the total value of stock 
(price × quantity) for each category and finally find the category with the 
highest total stock value.

Input Format:
-------------
Line-1: AN integer N, number of products.
Next N lines: 3 space separated strings, first is name, 
              second is category and thrid is price and
			  last one is quantity.

Output Format:
--------------
A string, name of the category with highest stock value.


Sample Input:
-------------
5
Laptop Electronics 1000.0 10
Phone Electronics 500.0 5
Shoes Clothing 50.0 20
Jacket Clothing 100.0 10
Blender Home_Appliances 150.0 3

Sample Output:
--------------
Electronics
	
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

class Product {
	private String name;
	private String category;
	private double price;
	private int qty;

	public Product(String name, String category, double price, int qty) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", price=" + price + ", qty=" + qty + "]";
	}

}

public class P1GetHighestStocks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine(); // consume the remaining newline character

		List<Product> products = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			String[] details = input.split(" ");
			String name = details[0];
			String category = details[1];
			double price = Double.parseDouble(details[2]);
			int qty = Integer.parseInt(details[3]);

			products.add(new Product(name, category, price, qty));
		}

		Map<String, Double> res = products.stream()
				.filter(p -> p.getQty() > 5)
				.collect(Collectors.groupingBy(
						// groupby catrgory
						Product::getCategory,
						Collectors.summingDouble(p -> p.getPrice() * p.getQty())));

		String maxCategory = res.entrySet().stream()
				.max(Entry.comparingByValue())
				.map(Entry::getKey) // Get the key (category) of the max entry
				.orElse(""); // In case no category is found

		System.out.println(maxCategory);

		sc.close();
	}
}