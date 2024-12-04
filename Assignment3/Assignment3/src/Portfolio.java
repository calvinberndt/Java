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

    }

    //-------------------------------------------------------------------
// Here is a good method to have. It can do a bunch of heavy lifting for
// the S command. It will search for the argument AnotherStock inputted
// with the S command. If the AnotherStock isn’t in the list and the DI
// doesn’t reach the maximum allowable number of stocks, the method adds
// AnotherStock into the list and displays a successful transaction
// message. If AnotherStock isn’t in the list and the DI does reach the
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
    }

    //-------------------------------------------------------------------
// This method can do the task associated with the D command. It will
// display a report of all assets (stocks and cash accounts) that are
// currently on this portfolio, one per line.
// params: (none)
//-----------------------------------------------------------------
    public void DisplayPortfolio() {
    }

    //-------------------------------------------------------------------
// This method can do the task associated with the V command. It will
// display the values of profit and total cash that are relevant to current
// assets on this portfolio.
// params: (none)
//-----------------------------------------------------------------
    public void DisplayPortfolioValue() {
    }
}// end of class Portfolio