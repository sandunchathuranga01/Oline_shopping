import java.util.ArrayList;
import java.util.List;

public class Cart // Constructor to initialize the Cart with an empty list of items
{
    private List<CartItem> items;

    public Cart()
    {
        this.items = new ArrayList<>();
    }

    public void addItem(CartItem item)// Method to add a CartItem to the cart
    {
        this.items.add(item);
    }

    public List<CartItem> getItems() // Method to retrieve the list of CartItems in the cart
    {
        return items;
    }

    public double getTotal()  // Method to calculate and return the total price of all items in the cart
    {
        double total = 0.0;
        for (CartItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}