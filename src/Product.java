import java.io.Serializable;

public abstract class Product implements Serializable {
    private String productId;  // Private variables to store information
    private String productName;
    private int availableItems;
    private double price;

    protected Product(String productId, String productName, int availableItems, double price)  // Constructor to initialize a Product
    {
        this.productId = productId;
        this.productName = productName;
        this.availableItems = availableItems;
        this.price = price;
    }
    // Getter methods to retrieve product ID,name,available item and price.
    public String getProductId() {
        return productId;
    }
    public String getProductName() {
        return productName;
    }
    public int getAvailableItems() {
        return availableItems;
    }
    public double getPrice() {
        return price;
    }

    // setter methods to retrieve product ID,name,available item and price.
    public void setAvailableItems(int availableItems) {
        this.availableItems = availableItems;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override // Override the toString method to provide a formatted string representation of the Product
    public String toString() {
        return "Product ID= " + productId + " | Product Name= " + productName  + " | Count of available Items= " + availableItems + " | Product price= " + price ;
    }
}


