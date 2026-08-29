package products;
/*Author: Kel Knight and Kendall Ward-Hill
Date: 9/16/2025
Purpose: This program creates the Product object, while also assigning it values and providing mutator and accessor methods */
public class Product {
		protected int productId;
		protected int manId;
		protected float wholePrice;
		protected float percMarkup;
		protected final int PIDLENGTH = 5;
		protected final int MIDLENGTH = 4;
		protected String isvalid;
		
		/*Preconditions: Product must be an object for the default constructor
		 *Postconditions: Once the default constructor is made, space is allocated for the object
		 */
		public Product() {
			productId = 0;
			manId = 0;
			wholePrice = 0.00f;
			percMarkup = 0.00f;
			isvalid = null;
		}
		/*Preconditions: the default constructor was already made so now the explicit constructor
		 * may assign values to the object
		 *Postconditions: an object of product will be made with the corresponding values to variables
		 *and the length of the id's will be checked
		 */
		public Product(int pId, int mId, float price, float markup) {
			String pIdString = String.valueOf(pId);
			String mIdString = String.valueOf(mId);
		    if (pIdString.length()== PIDLENGTH && mIdString.length()== MIDLENGTH) {
			productId = pId;
			manId = mId;
			wholePrice = price;
			percMarkup = markup;
			isvalid = "Those are valid ids.";
		    }
		    else {
		    	isvalid = "Product IDs must be 5 in length, and manufacturer IDs must be 4." ;
		    }
		}
		/*Preconditions: the Product object must exist and input passed
		 * through the parameters for the mutator method to work
		 *Postconditions: the instance variables will take in input and change
		 *to be reassigned it
		 */
		public void SetProduct(int pFive, int pFour, float pPrice, float pMarkup) {
			productId = pFive;
			manId = pFour;
			wholePrice = pPrice;
			percMarkup = pMarkup;
		}
		/*Preconditions: the Product object must exist for the accesor method to work
		 *Postconditions: the product id will be returned 
		 */
		public int getProductId() {
			return productId;
		}
		/*Preconditions: the product object must exist
		 *Postconditions: the retail price will be returned after the calculation is performed
		 */
		public float RetailPrice() {
			float retailPrice = wholePrice * (1 + percMarkup);
			return retailPrice;
		}
		/*Preconditions:a product object must exist and be passed through the parameter 
		 *Postconditions: the product id method is called to compare lengths, if it is less
		 *than, then it returns true
		 */
		public boolean LessThan(Product a) {
			if(this.productId < a.productId) {
				return true;
			
		}
			return false;
	}
		/*Preconditions: an array of object products must exist and be passed through as a parameter
		 *Postconditions: a check is done to see if the array is empty, if so then null is returned
		 *if it is not, then a for loop is used to compare product id sizes and returns the product
		 *with the largest id
		 */
		public Product largestId(Product [] products) {
	        if (products == null || products.length == 0) {
	            return null;
	        }

	        Product largestProduct = products[0]; 

	        for (int i = 1; i < products.length; i++) {
	            if (products[i].getProductId() > largestProduct.getProductId()) {
	                largestProduct = products[i];
	            }
	        }

	        return largestProduct;
	    }
		/*Preconditions: a product object must exist with values in it
		 *Postconditions: a deep copy clone of the product is then returned
		 */
		public Product getClone() {
			Product clone = new Product(this.productId, this.manId, this.wholePrice, this.percMarkup);
			return clone;
		}
		/*Preconditions: a product must exist, and override annotation is needed
		 *Postconditions: this will override the root toString and display all product
		 *information to the user when called
		 */
		@Override
		   public String toString() {
		       return String.format("%s: %d\n%s: %d\n%s: $%.2f\n%s: %.2f\n%s",
		                "product id", productId,
		                "manufacturer id", manId,
		                "whole sale price",wholePrice,
		                "percent mark up as decimal", percMarkup, isvalid);
		}
		/*Preconditions: a product must exist, override annotation is needed, and a
		 * product must be passed through as an object 
		 *Postconditions: this will override the root equals method, and check to see if
		 *objects are equal structurally or referentially, the equality will be returned
		 */
		 @Override
		    public boolean equals(Object o) {
		        if (o == null) {
		            return false;
		        }
		        if (getClass() == o.getClass()) {
		            Product other = (Product) o;
		            return this.productId == other.productId &&
		                    this.manId == other.manId &&
		                    this.wholePrice == other.wholePrice &&
		                    this.percMarkup == other.percMarkup;
		        }
		        return true;
		    }
}
