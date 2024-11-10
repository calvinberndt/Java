Assignment 2:


Page
1
of 9
Comp SCI 256- Programming Assignment 2 -
Fall 2024
10 Points
Problem Description
In this assignment, you are going to write a computer program to
manage computer salespeople. If a salesperson sells 12 or more
computers or sells computers that total more than or equal to
$35,000, (s)he wins a trip to Bellevue, Washington, the home of
Microsoft Pacific Northwest. A salesperson's sales can be
updated many times before his/her totals are requested, so the
sales data needs to be accumulated. You will maintain a list of
such sellers using commands to Add = add a name, Output = output
totals, Update = update computer values, or Quit = quit and give
prizes to winners in the list. There are three types of
computers that can be sold which are laptops, desktops, and
tablets.
Input
You will read and process commands from the standard input, quit
if the Quit command is entered. Commands consist of a single
word, possibly followed by parameters.
The commands you are to implement are of the form:
Add Sellername
Output Sellername
Update Sellername typeOfComputer total-Dollars number-of-Computers-Sold
Quit
1. Add – Add command. Add a seller with the given name
(Sellername) to the end of the list if a seller with that
name doesn't already exist. The name will be a contiguous
sequence of non-white-space characters. Your program
doesn't need to check this. See sample outputs.
2. Output – Output command. Output the total value of
computers sold and the total number of each type of computer
sold for that seller. If the seller doesn't exist, print an
appropriate message. See sample outputs.
3. Update – Update command. Update the seller with the given
sales and the appropriate number of computers. For this
command: Sellername designates the name of the salesperson;
typeOfComputer designates either laptop, desktop, or tablet;
total-Dollars designates the amount in dollars that was
sold; number-of-Computers-Sold designates the quantity of
computers of this type that were sold. Your program should
convert the typeOfComputer parameter to lower case, as the
input will use a mixed case designation. If the seller
doesn't exist, print an appropriate message (and read and
discard the data). See sample outputs.
4. Quit – Quit command. Print out the list of people who sold
enough to win the fabulous vacation.
You don't need to check for bad commands or bad parameters. You
can assume that the parameters for all commands are correct,
including the number, type, and order.
See the sample output for the exact wordings of all the messages.
Output
See the sample output for the output after executing each command
and for the exact wordings of all the messages.
Requirements
A- You must use and declare the following enumerated type:
ComputerType: { DESKTOP, LAPTOP, TABLET}
B- You must use and finish the following for the Seller class.
Copy/paste the Seller class below to your program and write
the bodies for the methods to satisfy the comment block
descriptions. You are allowed to add any more methods/data,
change the prototype or description of any method, or
change a private member to be public.
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
Seller (String name)
{
}
// Returns true if the seller's name is the same as nameToSearch.
// false otherwise.
// params: (String)
//
public boolean SellerHasName (String nameToSearch)
{
}
// Returns true if the seller sold at least 12 computers
// or has a sale amount of at least $35,000.00.
// params: (none)
//
public boolean WinsPrize ()
{
}
//
// Print the salesperson's name, sales total, and number of
// computers sold.
// params: (none)
//
public String toString( )
{
}
// Adds the money and number of computers to the seller's accumulated
// sales total and number of computers sold based on the computer type.
// That is, if the computer type is “DESKTOP” then the desktop field is
// updated by numComputers if the computer type is “LAPTOP” then the
// laptop field is updated by numComputers if the computer type is
// “TABLET” then the tablet fields are updated by numComputers.
// Param: ( double , int , String )
public void UpdateSales ( double totalDollars, int numComputers,
String computerType )
{
}
}// end class Seller
C- You must use and finish the following for the SellerList
class. Copy/paste the SellerList class below to your
program and write the bodies for the methods to satisfy the
comment block descriptions. You are allowed to add any more
methods/data, change the prototype or description of any
method, or change a private member to be public.
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
SellerList ()
{
}
// The method reads and processes user’s commands. After reading a
// command, the next step is to call the corresponding method for each
// command. The method uses switch statements for that.
// params: (none)
//-----------------------------------------------------------------
public void processCommands( )
{
String command;
command = input.next();
while (! (command.equals("Quit")
{ // starts of while
switch ( command )
{
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
public void processAddCommands( )
{
}
// The method reads and processes Output commands. The method displays the
// total value of computers sold and the total number of each type of
// computer sold for that seller. If the seller doesn't exist, print an
// appropriate message. See sample outputs.
// params: (none)
//-----------------------------------------------------------------
public void processOutputCommands( )
{
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
public void processUpdateCommands( )
{
}
// The method prints out the list of people who sold enough to win the
// fabulous vacation. See sample outputs.
// params: (none)
//-----------------------------------------------------------------
public void whoWin( )
{
}
}// end of class SellerList
D- You must use the below MainClass that includes the main
method to run your application. Copy/paste the MainClass
class below to your program.
public class MainClass {
public static void main(String[] args) {
// TODO Auto-generated method stub
SellerList GBStore = new SellerList();
SellerList.processCommands();
}
} // end of MainClass
Notes
• Follow the output format exactly. If you have any questions
about this format, just ask!
Group Requirements:
• You must work in groups for this assignment.
• Make sure that you instructor has your name and your partner’s
names on his list of teams for this assignment.
• Each person in the group of programmers must do their fair
share of work for the program.
• You are expected to be respectful towards your partners. It
is also expected that you will conduct yourself in a
professional manner in class and class-related activities
(like group meetings). No member of the group should exhibit
crude language, sexist comments or prejudicial comments of
any sort during any meetings. If this does occur, your
instructor will ask to meet with you privately.
• One person of the group MUST be designated as the "submitter"
to the Canvas system. That person must be indicated with an
* on the instructor's signup sheet. That person is
responsible for submitting the assignment to the Canvas by
the due date.
Sample run (Test Case 1)
Test Case 1: Input:
Add Alice
Add Bob
Update Alice laptop 6000 2
Output Alice
Update Bob desktop 18000 4
Update Bob tablet 4600 3
Output Bob
Add Charlie
Update Alice Desktop 37000 2
Update Charlie Laptop 40000 4
Update Bob laptop 9500 5
Update Charlie Desktop 10600 2
Update Tom laptop 6000 2
Output Tom
Add Tom
Update Tom laptop 6000 2
Output Tom
Quit
Do NOT COME HERE
don't
stop
wait
Ouch
Test Case 1: Output:
Alice is seller 1.
Bob is seller 2.
Alice sold 2 laptop computers for 6000 Dollars.
Alice: $6000; sold 2 LapTops, 0 DeskTops and 0 Tablets.
Bob sold 4 desktop computers for 18000 Dollars.
Bob sold 3 tablet computers for 4600 Dollars.
Bob: $22600; sold 0 LapTops, 4 DeskTops and 3 Tablets.
Charlie is seller 3.
Alice sold 2 desktop computers for 37000 Dollars.
Charlie sold 4 laptop computers for 40000 Dollars.
Bob sold 5 laptop computers for 9500 Dollars.
Charlie sold 2 desktop computers for 10600 Dollars.
Cannot update statistics. Tom is not in the list.
Cannot output. Tom is not in the list.
Tom is seller 4.
Tom sold 2 laptop computers for 6000 Dollars.
Tom: $6000; sold 2 LapTops, 0 DeskTops and 0 Tablets.
The contest is over. The winners are:
Alice: $43000; sold 2 LapTops, 2 DeskTops and 0 Tablets.
Bob: $32100; sold 5 LapTops, 4 DeskTops and 3 Tablets.
Charlie: $50600; sold 4 LapTops, 2 DeskTops and 0 Tablets.
