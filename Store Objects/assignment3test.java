package assignment3;
/*Author: Kel Knight and Kendall Ward-Hill
Date: 9/16/2025
Purpose: This program creates product, electronic, and apparel objects then runs some of their methods */
import products.Product;
import products.Electronics;
import products.Apparel;

public class assignment3test {
	/*Preconditions: this is main so the correct formatting
	 *Postconditions: all of the objects will be made and assigned values
	 */
	public static void main(String[] args) {
		Electronics e1 = new Electronics();
		e1.SetElectronics(67891, 1234, 550.23f, 0.20f, "PS5", 5, 55.67f);
		Electronics e2 = new Electronics(12345, 4321, 4.24f, 0.13f, "Ipad", 3, 1.35f);
		e1.SetElectronics(67891, 1234, 550.23f, 0.20f, "PS5", 5, 55.67f);
		System.out.println("Sale price for electronics");
		System.out.printf("The Sale Price of the first electronic is: $%.2f\n", e1.SalePrice());
		System.out.printf("The Sale Price of the second electronic is: $%.2f\n", e2.SalePrice());
		System.out.println("-------------------");
		System.out.println("Showing e1, then e2");
		System.out.println(e1.toString());
		System.out.println();
		System.out.println(e2.toString());
		Product e2Clone = e2.getClone();
		System.out.println("-------------------");
		System.out.println("Comparing the clone with the original.");
		System.out.printf("e2Clone (deep copy) and e2 are referentially equal: %b\n", (e2Clone == e2));
		System.out.printf("e2Clone (deep copy) and e2 are structurally equal: %b\n", e2Clone.equals(e2));
		System.out.println();
		System.out.println("Showing e2, then the clone's information.");
		System.out.println(e2.toString());
		System.out.println();
		System.out.println(e2Clone.toString());
		Apparel a1 = new Apparel();
		Apparel a2 = new Apparel(45637, 2345, 12.99f, 0.40f, "expensive shirt", 0.25f);
		a1.SetApparel(19786, 1987, 98.99f, 0.70f, "cheap shirt", 0.10f);
		System.out.println("Sale Price for apparel");
		System.out.printf("The Sale Price of the first apparel item is: $%.2f\n", a1.SalePrice());
		System.out.printf("The Sale Price of the second apparel item is: $%.2f\n", a2.SalePrice());
		System.out.println("-------------------");
		System.out.println("Showing a1, then a2");
		System.out.println();
		System.out.println(a1.toString());
		System.out.println();
		System.out.println(a2.toString());
		Product a2Clone = a2.getClone();
		//a2Clone.getClone();
		System.out.println("Comparing the clone to the original.");
		System.out.printf("a2Clone (deep copy) and a2 are referentially equal: %b\n", (a2Clone == a2));
		System.out.printf("a2Clone (deep copy) and a2 are structurally equal: %b\n", a2Clone.equals(a2));
		System.out.println();
		System.out.println("Showing a2 and then a2 clone");
		System.out.println(a2.toString());
		System.out.println(a2Clone.toString());
		System.out.println("-------------------");
		System.out.println("The product with the largest product ID value is: ");
		Product [] productsArray = {e1,e2,a1,a2}; /* create an array of objects via the product object
		then assign it the values of all the created objects*/
		Product largestproductID = new Product();
		/* check to see which object is the largest and print the corresponding to string method*/
		if (largestproductID.largestId(productsArray).equals(e1)) {
			System.out.println(e1.toString());
		}
		else if (largestproductID.largestId(productsArray).equals(e2)) {
			System.out.println(e2.toString());
		}
		else if (largestproductID.largestId(productsArray).equals(a1)) {
			System.out.println(a1.toString());
		}
		else {
				System.out.println(a2.toString());
		}
	}

}
