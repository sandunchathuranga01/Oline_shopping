import java.util.List;

interface WestminsterShoppingManager {
    void addProduct(Product product);
    void removeProduct(Product product);
    List<Product> getAllProducts();

    void displayMenu();
}