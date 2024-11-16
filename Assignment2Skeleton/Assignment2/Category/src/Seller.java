public class Seller {
	private String name; // name of the seller
	private double salesTotal; // running total of sales in $
	// running total of number of lap top computers sold
	private int lapTopSold;
	// running total of number of desk top computers sold
	private int deskTopSold;
	// running total of number of tablet computers sold
	private int tabletSold;
	// This is a non-default constructor for this
	// seller. It Initializes the Seller's name to newname and all other
	// fields to 0.
	// params: (String)
	//
	Seller (String name){
	}
	// Returns true if the seller's name is the same as nameToSearch.
	// false otherwise.
	// params: (String)
	//
	public boolean SellerHasName (String nameToSearch){
	}
	// Returns true if the seller sold at least 12 computers
	// or has a sale amount of at least $35,000.00.
	// params: (none)
	//
	public boolean WinsPrize (){
	}
	//
	// Print the salesperson's name, sales total, and number of
	// computers sold.
	// params: (none)
	//
	public String toString( ){
	}
	// Adds the money and number of computers to the seller's accumulated
	// sales total and number of computers sold based on the computer type.
	// That is, if the computer type is “DESKTOP” then the desktop field is
	// updated by numComputers if the computer type is “LAPTOP” then the
	// laptop field is updated by numComputers if the computer type is
	// “TABLET” then the tablet fields are updated by numComputers.
	// Param: ( double , int , String )
	public void UpdateSales ( double totalDollars, int numComputers,String computerType ){
	}
}// end class Seller
