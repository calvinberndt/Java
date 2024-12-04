import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {


        //test Stock class
        ArrayList<Stock> List = new ArrayList<Stock>();
        Stock s1 = new Stock("AAPL", 100, 100);
        List.add(s1);
        System.out.printf("%s\n", s1);
        //add s4 to test transaction function
        Stock s4 = new Stock("AAPL", 50, -50);
        System.out.printf("%s\n", s4);
        List.add(s4);
        
        //test transaction function
        double profit = s1.Transaction(s4);
        System.out.printf("Profit: %.2f\n", profit);



    }
}