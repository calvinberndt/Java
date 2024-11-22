package SellerPackage;
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
        System.out.println("Type the name of the seller:");
        String name = input.next(); // takes name the user wants to add to the list 
        for (int i = 0; i < List.size(); i++)
        {
            if (List.get(i).SellerHasName(name)) // Loops through list and checks to see if name exist in list already
            {

                System.out.printf("%s is already in the system.\n", name);
                //if name already exists then we notifies user that name exists. 
            }
            else {
                List.add(new Seller(name));
                System.out.printf("%s has been added!\n", name);
                // Else adds name to the end of Seller List and notifies the user
            }

        }

    }
"SellerList.java" 117L, 4197B                                                                      