import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager implements WestminsterShoppingManager {

    private ArrayList<Cloth> clothProducts = new ArrayList<>();
    private ArrayList<Electronic> electronicProducts = new ArrayList<>();
    protected List<Product> productList;
    private final Scanner scanner;
    private Cart shoppingCart;

    public ProductManager() {
        this.productList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.shoppingCart = new Cart();
        loadProductsFromFile();
    }

    public Cart getShoppingCart() {
        return shoppingCart;
    }


    @Override
    public void addProduct(Product product) {
        if (productList.size() < 50) {
            productList.add(product);
            System.out.println(product.getProductName()+ "  Product added successfully! ");
        } else {
            System.out.println("Cannot add more products.Remove unwanted product.");
        }
    }

    @Override
    public void removeProduct(Product product) {
        if (productList.remove(product)) {
            System.out.println(  product.getProductName()+" Product removed: ");
            System.out.println("Number of remaining products: " + productList.size());
        } else {
            System.out.println( product.getProductName()+"Product not found: ");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        return new ArrayList<>(productList);
    }

    public void displayGUI() {
        new UserGUI(this);
    }

    @Override
    public void displayMenu() {
        int choice;

        do {
            System.out.println(" ");
            System.out.println("-----------------------------------");
            System.out.println("Hello Westminster Shopping Manager");
            System.out.println("-----------------------------------");
            System.out.println(" ");
            System.out.println("******  System Control MENU  ******");
            System.out.println("1-ADD product to system");
            System.out.println("2-REMOVE product from system");
            System.out.println("3-PRINT available product");
            System.out.println("4-SAVE TO FILE");
            System.out.println("5-EXIT");
            System.out.println(" ");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    printProductList();
                    break;
                case 4:
                    saveProductsToFile();
                    break;
                case 5:
                    saveProductsToFile();
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    private void addNewProduct() {
        boolean validProductType = false;
        do {
            try {
                System.out.println(" ");
                System.out.println("1-CLOTH");
                System.out.println("2-ELECTRONIC");
                System.out.println(" ");
                System.out.println("Enter product type : ");
                int productType = scanner.nextInt();

                if (productType==1 || productType==2) {
                    validProductType = true;
                    System.out.println("Enter the product id: ");
                    String productID = scanner.next();

                    System.out.println("Enter the product name: ");
                    String name = scanner.next();

                    System.out.println("Enter the available items: ");
                    int availableItem = scanner.nextInt();

                    System.out.println("Enter price: ");
                    double price = scanner.nextDouble();

                    if (productType==1)
                    {
                        System.out.println("Enter Size( S | M | L | XL | XXL | XXXL ): ");
                        String size = scanner.next().toUpperCase();

                        System.out.println("Enter color: ");
                        String color = scanner.next().toUpperCase();

                        Product product = new Cloth(productID, name, availableItem, price, size, color);
                        addProduct(product);

                        Cloth newClothProducts = new Cloth(productID, name, availableItem, price, size, color);
                        clothProducts.add(newClothProducts);
                    }
                    else if (productType==2)
                    {
                        System.out.println("Enter the brand here : ");
                        String brand = scanner.next();

                        System.out.println("Enter the warranty period (Years): ");
                        double time = scanner.nextDouble();

                        Product product = new Electronic(productID, name, availableItem, price, brand, time);
                        addProduct(product);

                        Electronic newElectronicProducts = new Electronic(productID, name, availableItem, price, brand, time);
                        electronicProducts.add(newElectronicProducts);
                    }
                }
                else
                {
                    System.err.println("Please enter a valid number!");
                }
            }
            catch (java.util.InputMismatchException e) {
                System.err.println("Invalid input. Please enter the correct data type.");
                scanner.nextLine(); // Clear the buffer
            }
        } while (!validProductType);
    }

    private void removeProduct() {
        try {
            System.out.println("Enter the product ID to Remove :-  ");
            String removeProductId = scanner.next();

            Product removeProduct = null;
            for (Product product : getAllProducts()) {
                if (product.getProductId().equals(removeProductId)) {
                    removeProduct = product;
                    break;
                }
            }

            if (removeProduct != null) {
                removeProduct(removeProduct);
            } else {
                System.out.println(removeProductId + "ProductID not found " );
            }
        } catch (java.util.InputMismatchException e) {
            System.err.println("Invalid input. Please enter the correct data type.");
            scanner.nextLine(); // Clear the buffer
        }
    }


    public void printProductList() {
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Products in the system now (alphabetically based on product names):- ");
        System.out.println(" ");

        try {
            List<Product> productList = getAllProducts();

            // Sort the productList alphabetically based on product names
            Collections.sort(productList, (p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));

            for (Product product : productList) {
                System.out.println(product);
            }
        } catch (Exception e) {
            System.err.println("An error occurred while processing the product list: " + e.getMessage());
        }
    }


    private void saveProductsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productData.txt"))) {
            oos.writeObject(productList);
            System.out.println("Products saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }

    private void loadProductsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productData.txt"))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                productList = (List<Product>) obj;
                System.out.println("Products loaded from file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading products from file: " + e.getMessage());
        }
    }


}
