public class CartItem // The CartItem class represents an item that can be added to a shopping cart.
{
    private String productId; // Private  variables use to store product information
    private String productName;
    private String category;
    private double price;

    public CartItem(String productId, String productName, String category, double price)// Constructor to initialize a CartItem
    {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
    }

    public double getPrice() // Getter method to retrieve the price
    {
        return price;
    }

    // Getter and setter methods for the product ID,product name,category and quantity
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return 1;
    }
}


