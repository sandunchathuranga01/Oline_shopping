//create cloth subclass(Cloth) of product
public class Cloth extends Product
{
    private String size; // Private  variables to store additional details
    private String color;

    public Cloth(String productId, String productName, int availableItems, double price, String size, String color)// Constructor to initialize a Cloth object with product details
    {
        super(productId, productName, availableItems, price);
        this.size = size;
        this.color = color;
    }
    // Getter & setter methods to retrieve the size and color of the Cloth.
    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }


    public void setSize(String size) {this.size = size;}
    public void setColor(String color) {
        this.color = color;
    }

    // Override the toString method to provide a formatted string representation of the Cloth

    @Override
    public String toString() {
        return super.toString() + " | Size= " + size + " | Color= " + color;}
}



