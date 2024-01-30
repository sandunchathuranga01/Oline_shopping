// This Electronic class is a subclass of the Product class
public class Electronic extends Product {
    private String brand; // Private member variables to store additional details
    private double warrantyPeriod;
    // Constructor to initialize an Electronic object
    public Electronic(String productId, String productName, int availableItems, double price, String brand, Double warrantyPeriod) {
        super(productId, productName, availableItems, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() // Getter & setter methods to retrieve the brand and warranty period of the Electronic product.
    {
        return brand;
    }
    public double getWarrantyPeriod() {
        return warrantyPeriod;
    }


    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() // Override the toString method to provide a formatted string representation of the Electronic product
    {
        return super.toString() + "| Warranty Period= " + warrantyPeriod + " years";
    }

}

