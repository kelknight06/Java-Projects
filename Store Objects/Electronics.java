package products;
/*Author: Kel Knight and Kendall Ward-Hill
Date: 9/16/2025
Purpose: This program creates an electronics object that is a subclass to the prodcut superclass
 */
public class Electronics extends Product {
	private String name;
	private int warrantyDuration;
	private float warrantyCharge;
	/*Preconditions: the class needs to be named Electronics, and products default constructor needs to exist
	 *Postconditions: a default constructor is used to allocate space for the object
	 */
	public Electronics() {
		super();
		name = "default name";
		warrantyDuration = 0;
		warrantyCharge = 0.00f;
	}
	/*Preconditions: the default constructor was made and the object exists
	 *Postconditions: values are passed through to assign to the instance variables
	 *inside of this explicit value constructor
	 *values are also passed through to the parent explicit constructor
	 */
	public Electronics(int prodId, int mId, float wPrice, float perPrice, String eName, int duration, float charge) {
		super(prodId,mId,wPrice,perPrice);
		name = eName;
		warrantyDuration = duration;
		warrantyCharge = charge;
	}
	/*Preconditions: the electronics object exists, and the correct values are passed through
	 * as parameters
	 *Postconditions: all of the desired instance variables are assigned values in this mutator method 
	 */
	public void SetElectronics(int pID, int mID, float wholeP, float percentMark, String electName, int years, float price) {
		productId = pID;
		manId = mID;
		wholePrice = wholeP;
		percMarkup = percentMark;
		name = electName;
		warrantyDuration = years;
		warrantyCharge = price;
	}
	/*Preconditions: an electronics object exists and warrantyCharge has value
	 *Postconditions: the sale price is returned based off of the calculation
	 */
	public float SalePrice () {
		return (RetailPrice() + warrantyCharge);
	}
	/*Preconditions: the electronics object exists and the annotation is correct
	 *Postconditions: the formatted details of the electronic object is returned, including 
	 *inherited instance variables
	 */
	@Override
	   public String toString() {
	       return String.format("%s: %s\n%s: %d\n%s: $%.2f\n%s: %d\n%s: %d\n%s: $%.2f\n%s: %.2f",
	                "Electronic name", name,
	                "warranty duration in years", warrantyDuration,
	                "warranty charge",warrantyCharge,
	                "product id", productId,
	                "manufacturer id", manId,
	                "whole sale price",wholePrice,
	                "percent mark up as decimal", percMarkup);
	}
	/*Preconditions:  the electronics object exists and has an object passed through, with right
	 * annotation
	 *Postconditions: the equality is being checked, as well as the object having value. 
	 *the structural and referentially equality will be returned 
	 */
	 @Override
	    public boolean equals(Object o) {
	        if (o == null) {
	            return false;
	        }
	        if (getClass() == o.getClass()) {
	            Electronics other = (Electronics) o;
	            return super.equals(other) && 
	            		this.name.equals(other.name) &&
	            		this.warrantyDuration == other.warrantyDuration &&
	            		this.warrantyCharge == other.warrantyCharge;
	        }
	        return true;
	    }
}
