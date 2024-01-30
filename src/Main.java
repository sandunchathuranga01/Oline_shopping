import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Create an instance of the ProductManager class to manage the system
        ProductManager shoppingManager = new ProductManager();

        while (true)
        {// select the user to select a user type
            System.out.println("************************************************************");
            System.out.println("WELCOME TO WESTMINSTER SHOPPING SYSTEM");
            System.out.println("************************************************************");
            System.out.println(" ");
            System.out.println("----User Types----");
            System.out.println("01-I am WA Manager");
            System.out.println("02-I am client");


            System.out.println(" ");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please Select user type NUMBER:");
            int userType = scanner.nextInt();

            switch (userType) {
                case 1:
                {
                    String[] Usernames = {"user1", "user2", "user3"}; // Manager authentication
                    String[] Passwords = {"000", "111", "222"};

                    userAuthentication userLogin = new userAuthentication(Usernames, Passwords);
                    Scanner logScanner = new Scanner(System.in);

                    System.out.println("Important :- Please enter your logging details for logging to admin panel");

                    while (true) {
                        System.out.print("Enter username: ");
                        String username = logScanner.nextLine();

                        System.out.print("Enter password: ");
                        String password = logScanner.nextLine();

                        if (userLogin.loggin(username, password)) // Checking provided credentials are valid.
                        {
                            System.out.println("Login successful!");
                            break;
                        } else {
                            System.out.println("Invalid username or password. Please try again.");
                        }
                    }
                    shoppingManager.displayMenu();  // Display  menu for the Manager.
                    return;
                }

                case 2:
                    System.out.println("01-I am client");// Client interface
                    shoppingManager.displayGUI();


                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }

}


