import java.util.ArrayList;
import java.util.Scanner;

public class GroceryStore
{
    private Scanner input = new Scanner(System.in);
    private ArrayList<GroceryItem> list = new ArrayList<GroceryItem>();
    private String storeName;

    GroceryStore(String storeName){
        this.storeName = storeName;
        //Methods can also be called in the constructor to set up the object
    }
    public void setStoreName(String storeName){
        this.storeName = storeName;
    }


    //Create a run method to interface with the main method
    void Run() {
        String userCommand;
        System.out.println("******************************");
        System.out.println("*    Welcome to " + storeName + "    *");
        System.out.println("******************************");
        userCommand = input.next(); //read the very first command
        while (!userCommand.equals("none")){
            switch (userCommand) {
                case "Add":
                    addItems(); //method that adds items to the store
                    break;
                case "Display":
                    displayHeader();
                    displayItems(); //method that displays all items in the store
                    break;
                case "Remove":
                    removeItem(); //method that removes items from the store
                    break;
                case "Update":
                    updateItem(); //method that updates the price and quantity of a given item
                    break;
                case "Budget":
                    displayBudget(); //method that displays the total budget of the store
                    break;
                default:
                    break;
            }
            userCommand = input.next();
        }
        findLowestPrice();
        lowestPriceInCategory();
    }//end of run method

//Create a method that displays the menu
public void displayMenu(){
    System.out.print("Please select your command:\n");
    System.out.print("Load - Load new items into the store.\n");
    System.out.print("Show - Display all items in the store.\n");
    System.out.print("Find - Find an item in the store.\n");
    }

//Create a method that adds items to the store
public void addItems(){
    //Format: itemName itemPrice itemQuantity Category
    String itemName;
    double itemPrice;
    int itemQuantity;
    String categoryAsString;
    Category itemCategory;

    itemName = input.next();
    itemPrice = input.nextDouble();
    itemQuantity = input.nextInt();
    categoryAsString = input.next();
    itemCategory = stringToEnum(categoryAsString);
    GroceryItem newItem = new GroceryItem(itemName, itemPrice, itemQuantity, itemCategory);
    list.add(newItem);
}

//create a method that displays all items in the store
public void displayItems(){
        //Array Traversal to visit each item in the list and display them
    for (GroceryItem item: list){
        System.out.printf("%s", item);
    }
}
public void displayHeader(){
        //Add Store name to header with it being centered
        System.out.printf("%-20s\n", storeName);
        System.out.printf("%-20s %-20s %-20s %-20s\n", "Item Name", "Item Price", "Item Quantity", "Item Category");
        System.out.printf("%-20s %-20s %-20s %-20s\n", "---------", "----------", "------------", "-------------");
}
//create a method that takes the categoryAsString and converts to a Category enum
public Category stringToEnum(String categoryAsString){
    switch (categoryAsString.toUpperCase()){
        case "PRODUCE":
            return Category.PRODUCE;
        case "DAIRY":
            return Category.DAIRY;
        case "MEAT":
            return Category.MEAT;
        default:
            return Category.OTHER;
    }
}

public void removeItem(){
    String itemName;
    itemName = input.next();
    for (int index = 0; index < list.size(); index++){
        if (list.get(index).getItemName().equals(itemName)){
            list.remove(index);
            System.out.println("Item removed successfully!");
            return;
        }
    }
    System.out.println("Item not found!");
}

//method that updates the price and quanity of a given item
public void updateItem(){
    String itemName;
    double newPrice;
    int newQuantity;
    itemName = input.next();
    newPrice = input.nextDouble();
    newQuantity = input.nextInt();
    for (GroceryItem item: list){
        if (item.getItemName().equals(itemName)){
            item.setItemUnitPrice(newPrice);
            item.setItemQuantity(newQuantity);
            System.out.println("Item updated successfully!");
            return;
        }
    }
    System.out.println("Item not found!");
}

//create a method to displayBudget
public void displayBudget(){
    double total = 0;
    for (GroceryItem item: list){
        total += item.getItemUnitPrice() * item.getItemQuantity();
    }
    System.out.printf("Total Budget: %.2f\n", total);
}

//create a method to find the item with the lowest price
public void findLowestPrice() {
    double lowestPrice = list.get(0).getItemUnitPrice();
    String lowestItem = list.get(0).getItemName();
    for (GroceryItem item : list) {
        if (item.getItemUnitPrice() < lowestPrice) {
            lowestPrice = item.getItemUnitPrice();
            lowestItem = item.getItemName();
        }
    }
    System.out.printf("The item with the lowest price is %s with a price of %.2f\n", lowestItem, lowestPrice);
}

//create a method to find the lowest price item in a given category
public void lowestPriceInCategory(){
    String categoryAsString;
    categoryAsString = input.next();
    Category itemCategory = stringToEnum(categoryAsString);
    double minPrice = 1000000.0;
    int minIndex = 0;
    for(int index=0; index < list.size(); index++){
        if (minPrice > list.get(index).getItemUnitPrice() && list.get(index).getItemCategory() == itemCategory){
            minPrice = list.get(index).getItemUnitPrice();
            minIndex = index;
        }
    }
    System.out.printf("Item whose unit price is the lowest in the %s category is: \n", itemCategory);
    System.out.printf("%s\n", list.get(minIndex));
    System.out.printf("The lowest price in %s category is %.2f\n",itemCategory, minPrice);
}
//public void bargainItemMethod(){
//        String categoryAsString;
//        categoryAsString = input.next();
//        Category itemCategory = stringToEnum(categoryAsString);
//        double minPrice = 0.0;
//        int minIndex = 0;
//        for(int index=0; index < list.size(); index++){
//            if (minPrice > list.get(index).getItemUnitPrice() && list.get(index).getItemCategory() == itemCategory){
//                minPrice = list.get(index).getItemUnitPrice();
//                minIndex = index;
//            }
//        }
//        System.out.printf("Item whose unit price is the lowest in the %s category is: \n", itemCategory);
//        System.out.printf("%s\n", list.get(minIndex));
//        System.out.printf("The lowest price in %s category is %.2f\n",itemCategory, minPrice);
//}
}
