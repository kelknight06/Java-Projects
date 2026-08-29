package products;
/*Author: Kel Knight and Kendall Ward-Hill
Date: 9/16/2025
Purpose: This program creates an apparel object which is a subclass to the product superclass */
public class Apparel extends Product {
	private String apparelName;
	private float percDiscount;
	
	/*Preconditions: the class needs to be named apparel
	 * a default constructor is made to allocate space and construct the parent
	 * default constructor as well
	 *Postconditions: space is allocated for the object
	 */
	public Apparel () {
		super();
		apparelName = "default apparel name";
		percDiscount = 0.00f;
	}
	/*Preconditions: a default constructor for the object must exist so that 
	 * the explicit one can give it values
	 *Postconditions: values are passed through the parameters and assigned to the instance variables
	 *as well as passing ones through to the parent explicit constructor
	 */
	public Apparel (int prodId, int mId, float wPrice, float perPrice, String aName, float pDiscount) {
		super(prodId,mId,wPrice,perPrice);
		apparelName = aName;
		percDiscount = pDiscount;
	}
	/*Preconditions: this mutator method allows for different values to be set to the instance variables
	 *Postconditions: instance variables will have the values passed through
	 */
	public void SetApparel(int pID, int mID, float wholeP, float percentMark, String name, float discount) {
		productId = pID;
		manId = mID;
		wholePrice = wholeP;
		percMarkup = percentMark;
		apparelName = name;
		percDiscount = discount;
	}
	/*Preconditions: the apparel object must exist
	 *Postconditions: the saleprice is returned once the calculation is performed
	 */
	public float SalePrice() {
		return (RetailPrice()*(1- percDiscount));
	}
	/*Preconditions: the annotation is needed, the object must exist
	 *Postconditions: the formatted information of the apparel object will be returned 
	 */
	@Override
	   public String toString() {
	       return String.format("%s: %s\n%s: %.2f\n%s: %d\n%s: %d\n%s: $%.2f\n%s: %.2f",
	                "Apparel name", apparelName,
	                "percent of discount as a decimal", percDiscount,
	                "product id", productId,
	                "manufacturer id", manId,
	                "whole sale price",wholePrice,
	                "percent mark up as decimal", percMarkup);
	}
	/*Preconditions: the correct annotation is needed, and the object must exist and be passed
	 * through
	 *Postconditions: the structural and referentially equality will be checked, as well as if the object has values, and
	 *true or false returned depending on that
	 */
	 @Override
	    public boolean equals(Object o) {
	        if (o == null) {
	            return false;
	        }
	        if (getClass() == o.getClass()) {
	            Apparel other = (Apparel) o;
	            return super.equals(other) && 
	            		this.apparelName.equals(other.apparelName) &&
	            		this.percDiscount == other.percDiscount;
	        }
	        return true;
	    }
}
