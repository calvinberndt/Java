public class Stock extends Asset {

    private String Stock_Name; // Name(Symbol) of this Stock
    private int Stock_Shares; // Number of shares of this Stock
    private double Stock_Price; // Price per share of this Stock

    Stock(String Name, double Price, int numShares) {
        this.Stock_Name = Name;
        this.Stock_Price = Price;
        this.Stock_Shares = numShares;
    }

    //-------------------------------------------------------------------
// This method returns the current market value of the shares of this
// Stock. Stock's market value is the total number of shares purchased
// times the current price per share
// params: (none)
//-----------------------------------------------------------------
    public double getMarketValue() {
        return this.Stock_Price * this.Stock_Shares;
    }

    //-------------------------------------------------------------------
// This method returns the string representation of this stock
// params: (none)
//-----------------------------------------------------------------
    public String toString() {
        return String.format("%15s%6d%8.2f%10.2f", Stock_Name,
                Stock_Shares, Stock_Price, getMarketValue());
    }

    //-------------------------------------------------------------------
// This method returns the name of this stock
// params: (none)
//-----------------------------------------------------------------
    public String getName() {
        return this.Stock_Name;
    }

    //-------------------------------------------------------------------
// This method updates this stock with the data from AnotherStock that
// inputted along with the S command, and returns any resulting profit.
// If the number of shares for this stock and AnotherStock have the
// same sign (both positive or both negative), then there is no profit
// (just buying or selling more) and the price of this stock
// is updated to be the weighted average of the prices (see Example1).
// Otherwise, profit is the minimum of the absolute values of the
// shares times the difference between the prices of AnotherStock and
// this stock. If the number of shares of this stock is negative,
// the sign of the profit is reversed. The price of this stock is
// updated to be the price of whichever of this stock or AnotherStock
// has the larger absolute value of shares.
// In all cases, the number of shares for this stock is updated by
// adding in the number of shares for AnotherStock.
// Note that a negative value for the profit indicates a loss.
// Please consider Example1 to gain more ideas about how to implement
// this method. Since Transaction is tricky, we gave you the first couple
// of lines
// params: (Stock)
    public double Transaction(Stock AnotherStock) {

        double profit = 0.0;

        //Calculate the new stock price if the stock shares have the same sign
        if (Stock_Shares < 0 && AnotherStock.Stock_Shares < 0 ||
                Stock_Shares > 0 && AnotherStock.Stock_Shares > 0) {
            Stock_Price = (Stock_Shares * Stock_Price +
                    AnotherStock.Stock_Shares * AnotherStock.Stock_Price) /
                    (Stock_Shares + AnotherStock.Stock_Shares);
        }

        //Calculate profit and update the stock price if the stock shares have different signs
        else {
            profit = Math.min(Math.abs(Stock_Shares) * Math.abs(Stock_Price - AnotherStock.Stock_Price),
                    Math.abs(AnotherStock.Stock_Shares) * Math.abs(Stock_Price - AnotherStock.Stock_Price));

            //If the stock shares are negative, the profit is negative
            if (Stock_Shares < 0) {
                profit = -profit;
            }

            //Update the stock price
            if (Math.abs(Stock_Shares) < Math.abs(AnotherStock.Stock_Shares)) {
                Stock_Price = AnotherStock.Stock_Price;
            }
        }

        //Update the stock shares
        Stock_Shares += AnotherStock.Stock_Shares;

        return profit;
    }
}
