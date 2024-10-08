import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    // Scanner object to read user input
    public static Scanner butcherScanner = new Scanner(System.in);
    // List to store item names
    public static ArrayList<String> butcherItemNames = new ArrayList<>();
    // 2D array to store item information: [pOrdered, pInStore, pSold, manufPrice, sellingPrice]
    public static double [][] butcherItemInfo = new double[25][5];
    // Array to store total votes (not used in the current code)
    public static int [] butcherTotalVotes = new int[25];

    public static void main(String[] args) {
        // Start processing commands
        processButcherCommands();
    }

    // Method to process user commands
    public static void processButcherCommands() {
        String butcherCommand;
        // Read the first command
        butcherCommand = butcherScanner.next();
        // Loop until the command is "Quit"
        while (!butcherCommand.equals("Quit")) {
            switch (butcherCommand) {
                case "Add":
                    // Process add command
                    processButcherAddCommand();
                    break;
                case "Output":
                    // Process output command
                    processButcherOutputCommand();
                    break;
                case "Sell":
                    // Process sell command
                    processButcherSellCommand();
                    break;
                case "Display":
                    // Process display command
                    processButcherDisplayCommand();
                    break;
                default:
                    // Handle invalid command
                    System.out.println("Bad command.");
                    butcherScanner.nextLine();
                    break;
            }
            // Read the next command
            butcherCommand = butcherScanner.next();
        }
    }

    // Method to process the add command
    public static void processButcherAddCommand() {
        // Read item details from input
        String butcherAddItem = butcherScanner.next();
        double butcherPOrdered = butcherScanner.nextDouble();
        double butcherManufPrice = butcherScanner.nextDouble();
        double butcherSellingPrice = butcherScanner.nextDouble();

        // Check if the item already exists
        if (butcherItemNames.contains(butcherAddItem)) {
            System.out.printf("The item %s already exists.\n", butcherAddItem);
            return;
        } else {
            // Add new item to the list
            butcherItemNames.add(butcherAddItem);
            int butcherIndex = butcherItemNames.size() - 1;
            // Store item information in the array
            butcherItemInfo[butcherIndex][0] = butcherPOrdered;
            butcherItemInfo[butcherIndex][1] = butcherPOrdered;
            butcherItemInfo[butcherIndex][2] = 0;
            butcherItemInfo[butcherIndex][3] = butcherManufPrice;
            butcherItemInfo[butcherIndex][4] = Math.round(butcherSellingPrice * 100.0) / 100.0;
            System.out.printf("You have added %s.\n", butcherAddItem);
        }
    }

    // Method to process the sell command
    public static void processButcherSellCommand() {
        // Read item name and quantity sold from input
        String butcherSellItem = butcherScanner.next();
        double butcherItemsSold = butcherScanner.nextDouble();
        // Check if the item exists
        if (!butcherItemNames.contains(butcherSellItem)) {
            System.out.printf("The item %s does not exist.\n", butcherSellItem);
        } else {
            // Update the sold quantity for the item
            int butcherItemIndex = butcherItemNames.indexOf(butcherSellItem);
            butcherItemInfo[butcherItemIndex][2] += butcherItemsSold;
            System.out.printf("You have sold %.2f items of %s.\n", butcherItemsSold, butcherSellItem);
        }
    }

    // Method to process the display command
    public static void processButcherDisplayCommand() {
        // Display header
        displayButcherHeader();
        // Display each item's information
        for (int i = 0; i < butcherItemNames.size(); i++) {
            System.out.printf("%-25s %15.0f %15.0f %15.0f %15.2f %15.2f\n",
                butcherItemNames.get(i),
                butcherItemInfo[i][0],
                butcherItemInfo[i][1],
                butcherItemInfo[i][2],
                butcherItemInfo[i][3],
                butcherItemInfo[i][4]);
        }
        // Calculate and display total inventory and selling value
        double totalInventory = 0;
        double totalSellingValue = 0;
        for (int i = 0; i < butcherItemNames.size(); i++) {
            totalInventory += butcherItemInfo[i][1];
            totalSellingValue += butcherItemInfo[i][1] * butcherItemInfo[i][4];
        }
        System.out.printf("The total inventory is %.2f.\n", totalInventory);
        System.out.printf("The total selling value is %.2f.\n", totalSellingValue);
    }

    // Method to process the output command
    public static void processButcherOutputCommand() {
        // Read item name from input
        String butcherProcessItemName = butcherScanner.next();
        // Check if the item exists
        if (!butcherItemNames.contains(butcherProcessItemName)) {
            System.out.printf("The item %s does not exist.\n", butcherProcessItemName);
        } else {
            // Display header and item information
            displayButcherHeader();
            int butcherItemIndex = butcherItemNames.indexOf(butcherProcessItemName);
            System.out.printf("%-25s %15.0f %15.0f %15.0f %15.2f %15.2f\n",
                butcherItemNames.get(butcherItemIndex),
                butcherItemInfo[butcherItemIndex][0],
                butcherItemInfo[butcherItemIndex][1],
                butcherItemInfo[butcherItemIndex][2],
                butcherItemInfo[butcherItemIndex][3],
                butcherItemInfo[butcherItemIndex][4]);
        }
    }

    // Method to display the table header
    public static void displayButcherHeader() {
        // Display table header
        System.out.println("------------------------------------ Scary Halloween Butcher Tool Shop - Use Your Imagination  ------------------------------------");
        System.out.printf("%-25s %15s %15s %15s %15s %15s\n", "butcherItemName", "butcherPOrdered", "butcherPInStore", "butcherPSold", "butcherManufPrice", "butcherSellingPrice");
        System.out.printf("%-25s %15s %15s %15s %15s %15s\n", "-------------", "-------------", "-------------", "-------------", "-------------", "-------------");
    }
}