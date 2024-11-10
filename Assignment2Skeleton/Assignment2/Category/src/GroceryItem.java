public class GroceryItem
{
    public double tax = 0.05;
    private String itemName;
    private double itemUnitPrice;
    private int itemQuantity;
    //private enum, data field named item_category for the category of an item
    private Category itemCategory;

    //non-default constructor
    public GroceryItem(String itemName, double itemUnitPrice, int itemQuantity, Category itemCategory)
    {
        this.itemName = itemName;
        this.itemUnitPrice = itemUnitPrice;
        this.itemQuantity = itemQuantity;
        this.itemCategory = itemCategory;
    }
    //getters
    public String getItemName() {
        return itemName;
    }

    public double getItemUnitPrice() {
        return itemUnitPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public Category getItemCategory() {
        return itemCategory;
    }

    public double getTax() {
        return tax;
    }
    //setters
    public void setItemCategory(Category itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public void setItemUnitPrice(double itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-20.2f %-20d %-20s\n", itemName, itemUnitPrice, itemQuantity, itemCategory);
    }

    public double getCost(){
        return itemUnitPrice * itemQuantity;
    }
}
