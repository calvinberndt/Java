import java.util.Scanner;
import java.util.ArrayList;
public class SellerList {
	private Scanner input = new Scanner(System.in);
	private ArrayList <Seller> List = new ArrayList <Seller>();
	//----------------------------------------------------------------
	// This is a default constructor for this
	// SellerList.
	// params: (none)
	//----------------------------------------------------------------
	SellerList (){
	}
	// The method reads and processes user’s commands. After reading a
	// command, the next step is to call the corresponding method for each
	// command. The method uses switch statements for that.
	// params: (none)
	//-----------------------------------------------------------------
	public void processCommands( ){
	String command;
	command = input.next();
	while (! (command.equals("Quit"){ // starts of while
		switch ( command ){
			case "Add":
				ProcessAddCommand( );
				break;
			case "Output":
				ProcessOutputCommand( );
				break;
			case "Update":
				ProcessUpdateCommand( );
				break;
			default:
				System.out.println("Bad command.");
				input.nextLine(); //////// skip the rest of the line
				break;
		} // end switch
		command = input.next(); // read the next command
	} // end while loop
	whoWin();
	} // end of method ProcessCommands
// The method reads and processes Add commands. After reading the
// sellername, the method adds the seller with the given name to the end
// of the list if a seller with that name doesn't already exist.
// If the seller does exist, the method should display an appropriate
// message.
// params: (none)
//-----------------------------------------------------------------
	public void processAddCommands( ){
		String name = input.next();
		for (int i = 0; i < List.size(); i++)
		{
			if (List.get(i).SellerHasName(name))
			{
				System.out.printf("%s is already in the system.\n", name);
			}
			else {
				List.add(new Seller(name));
				System.out.printf("%s has been added!\n", name);
			}
		}
		
	}
// The method reads and processes Output commands. The method displays the
// total value of computers sold and the total number of each type of
// computer sold for that seller. If the seller doesn't exist, print an
// appropriate message. See sample outputs.
// params: (none)
//-----------------------------------------------------------------
	public void processOutputCommands( ){
	}
// The method reads and processes Update commands. The method Update the
// seller with the given sales and the appropriate number of computers.
// For this command: Sellername designates the name of the salesperson;
// typeOfComputer designates either laptop, desktop, or tablet;
// total-Dollars designates the amount in dollars that was sold;
// number-of-Computers-Sold designates the quantity of computers of this
// type that were sold. Your program should convert the typeOfComputer
// parameter to lower case, as the input will use a mixed case
// designation. If the seller doesn't exist, print an appropriate message
// (and read and discard the data). See sample outputs.
// params: (none)
//-----------------------------------------------------------------
	public void processUpdateCommands( ){
	}
// The method prints out the list of people who sold enough to win the
// fabulous vacation. See sample outputs.
// params: (none)
//-----------------------------------------------------------------
	public void whoWin( ){
	}
}//End of Class
