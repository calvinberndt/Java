import java.util.Scanner;
import java.util.ArrayList;

public class Portfolio {
    private Scanner input = new Scanner(System.in);
    // total profit or loss earned on the shares of all stocks being
// monitored by a DI.
    private double profit;
    // total cash balance of all bank accounts owned by a DI
    private double totalCash;
    // number of stocks currently being monitored by a DI
    private int numStocks;
    // number of cash accounts currently being monitored by a DI
    private int numCashs;
    // maximum number of stocks being monitored by a DI
    private final int MAX_STOCKS = 6;
    // maximum number of cash accounts being monitored by a DI
    private final int MAX_CASHS = 6;
    // The list of Assets that holds all stocks and cash accounts that are
// currently being monitored by a DI
    private ArrayList<Asset> List = new ArrayList<Asset>();

    //-------------------------------------------------------------------
// This is a default constructor for this
// Portfolio.
// params: (none)
//-----------------------------------------------------------------
    Portfolio() {
        profit = 0;
        totalCash = 0;
        numStocks = 0;
        numCashs = 0;
    }

    //-------------------------------------------------------------------
// This method reads commands from a DI. The method use a switch
// statement to process the inputted commands and calls the appropriate
// method.
// params: (none)
//-----------------------------------------------------------------
    public void ProcessCommands() {

    	boolean isRunning = true;
        while (isRunning) {
            System.out.print("Enter command: ");
            char command = input.next().toLowerCase().charAt(0); // take user input
            switch (command) {
                case 's':
                    // Call ProcessStock with appropriate parameters
                    ProcessStock();
                    break;
                case 'c':
                    // Call ProcessCash with appropriate parameters
                    ProcessCash();
                    break;
                case 'd':
                    DisplayPortfolio();
                    break;
                case 'v':
                    DisplayPortfolioValue();
                    break;
                case 'q':
                    isRunning = false; // using boolean because I am feeling Devious. 
                    break; // boolean becomes false disabling the While loop 
                default:
                    System.out.println("Invalid Command. Please try again!");
                    break;
    		}// end of swtich
    	}//end of while 
    }// end of ProcessCommands

    //-------------------------------------------------------------------
// Here is a good method to have. It can do a bunch of heavy lifting for
// the S command. It will search for the argument AnotherStock inputted
// with the S command. If the AnotherStock isn’t in the list and the DI
// doesn’t reach the maximum allowable number of stocks, the method adds
// AnotherStock into the list and displays a successful transaction
// message. If AnotherStock isn't in the list and the DI does reach the
// maximum allowable number of stocks, the method displays an unsuccessful
// transaction message.
// Otherwise, it will make use of the Transaction method in the class
// Stock. It will also update the total profit of this portfolio and
// display a successful transaction message. Be sure to charge the $5 for
// each successful Transaction. Besides that, if the number of shares
// owned or sold for a particular stock in the list becomes zero, the
// method removes it from the list of assets.
// params: (Stock)
//-----------------------------------------------------------------
    public void ProcessStock(Stock AnotherStock) {
        System.out.print("Enter stock name, price, and shares: ");
        String name = input.next();
        double price = input.nextDouble();
        int shares = input.nextInt();

        Stock newStock = new Stock(name, price, shares);
        boolean stockExists = false; // Bool to keep track if stock is in list or not.

        for (int i = 0; i < List.size(); i++) {
            if (List.get(i) instanceof Stock && List.get(i).getName().equals(name)) {
                Stock existingStock = (Stock) List.get(i);
                double profit = existingStock.Transaction(newStock);
                this.profit += profit - 5; // Deduct $5 transaction fee
                if (existingStock.getShares() == 0) {
                    List.remove(i);
                }
                stockExists = true;
                System.out.println("Transaction completed.");
                break;
            }
        }

        if (!stockExists) {
            if (numStocks < MAX_STOCKS) {
                List.add(newStock);
                numStocks++;
                this.profit -= 5; // Deduct $5 transaction fee
                System.out.println("Transaction completed.");
            } else {
                System.out.println("Transaction NOT completed. Maximum number of stocks being monitored.");
            }
        }
    }
    	

    //-------------------------------------------------------------------
// Here is another good method to have. It can do a bunch of heavy lifting
// for the C command. It will search for the argument AnotherCash inputted
// with the C command. If the AnotherCash isn’t in the list and the DI
// doesn’t reach the maximum allowable number of cash accounts, the method
// adds AnotherCash into the list and displays a successful transaction
// message. If AnotherCash isn’t in the list and the DI does reach the
// maximum allowable number of Cash accounts, the method displays an
// unsuccessful transaction message.
// Otherwise, it will make use of the Transaction method in the class
// Cash. It will also update the total cash balance owned by a DI and
// display a successful transaction message. Besides that, if the balance
// for a particular cash account in the list becomes zero, the method
// removes it from the list of assets.
// params: (Cash)
//-----------------------------------------------------------------
    public void ProcessCash(Cash AnotherCash) {
    	
    	System.out.print("Enter bank name and amount: ");
        String bankName = input.next();
        double amount = input.nextDouble();
        boolean cashExists = false;
        
        Cash newCash = new Cash(bankName, amount);  
       
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i) instanceof Cash && List.get(i).getName().equals(bankName)) {
                Cash existingCash = (Cash) List.get(i);
                existingCash.Transaction(newCash);
                if (existingCash.getMarketValue() == 0) {
                    List.remove(i);
                    numCashs--;
                }
                cashExists = true;
                System.out.println("Transaction completed.");
                break;
            }
        }

        if (!cashExists) {
            if (numCashs < MAX_CASHS) {
                List.add(newCash);
                numCashs++;
                System.out.println("Transaction completed.");
            } else {
                System.out.println("Transaction NOT completed. Maximum number of cash accounts being monitored.");
            }
        }
    }

    //-------------------------------------------------------------------
// This method can do the task associated with the D command. It will
// display a report of all assets (stocks and cash accounts) that are
// currently on this portfolio, one per line.
// params: (none)
//-----------------------------------------------------------------
    public void DisplayPortfolio() {
    	for (Asset asset : List) {
            System.out.println(asset.toString()); // not much but size does not matter. This forloop has personality
        }
    }

    //-------------------------------------------------------------------
// This method can do the task associated with the V command. It will
// display the values of profit and total cash that are relevant to current
// assets on this portfolio.
// params: (none)
//-----------------------------------------------------------------
    public void DisplayPortfolioValue() {
    	// scrubing list and getting market value. 
    	double totalCash = 0.0; // total sum of market value
    	for (int i = 0; i < List.size(); i++) {
            Asset asset = List.get(i);
            if (asset instanceof Cash) {
                totalCash += asset.getMarketValue();
            }
        }
    	
    	System.out.printf("Profit so far: $ %.2f, Cash so far: $ %.2f%n", profit, totalCash); //that's a print
    }
}// end of class Portfolio