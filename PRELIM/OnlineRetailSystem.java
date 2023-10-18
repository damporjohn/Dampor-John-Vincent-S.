
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineRetailSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int userID;
        String username;
        String emailAddress;

        System.out.print("Enter User ID: ");
        userID = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Username: ");
        username = scanner.nextLine();

        System.out.print("Enter Email Address: ");
        emailAddress = scanner.nextLine();

        User user;
        int roleChoice;

        do {
            System.out.print("Choose your role (1 for Customer, 2 for Admin): ");
            roleChoice = scanner.nextInt();
        } while (roleChoice != 1 && roleChoice != 2);

        if (roleChoice == 1) {
            user = new Customer(userID, username, emailAddress);
        } else {
            user = new Admin(userID, username, emailAddress);
        }

        System.out.println("Welcome to the Online Retail System, " + user.getUsername() + "!");
        user.login();

        List<Product> sampleProducts = new ArrayList<>();
        sampleProducts.add(new Product("Laptop"));
        sampleProducts.add(new Product("Smartphone"));
        sampleProducts.add(new Product("Headphones"));
        sampleProducts.add(new Product("Tablet"));
        sampleProducts.add(new Product("Camera"));

        while (true) {
            if (user instanceof Customer) {
                displayCustomerMenu();
                int customerChoice = scanner.nextInt();
                handleCustomerChoice(customerChoice, (Customer) user, sampleProducts, scanner);
            } else if (user instanceof Admin) {
                displayAdminMenu();
                int adminChoice = scanner.nextInt();
                handleAdminChoice(adminChoice, (Admin) user, sampleProducts, scanner);
            } else {
                System.out.println("Invalid user. Exiting...");
                scanner.close();
                return;
            }
        }
    }

    private static void displayCustomerMenu() {
        System.out.println("Customer Menu:");
        System.out.println("1. Place an order");
        System.out.println("2. View order history");
        System.out.println("3. Logout");
        System.out.print("Enter your choice: ");
    }

    private static void displayAdminMenu() {
        System.out.println("Admin Menu:");
        System.out.println("1. Add a product");
        System.out.println("2. Remove a product");
        System.out.println("3. Manage inventory");
        System.out.println("4. Logout");
        System.out.print("Enter your choice: ");
    }

    private static void handleCustomerChoice(int customerChoice, Customer customer, List<Product> products, Scanner scanner) {
        switch (customerChoice) {
            case 1:
                System.out.println("Available Products:");
                for (int i = 0; i < products.size(); i++) {
                    System.out.println((i + 1) + ". " + products.get(i).getName());
                }
                System.out.print("Enter the product number to order: ");
                int productNumber = scanner.nextInt();
                if (productNumber >= 1 && productNumber <= products.size()) {
                    Product selectedProduct = products.get(productNumber - 1);
                    Order order = new Order();                    
                    customer.placeOrder(order, selectedProduct);
                } else {
                    System.out.println("Invalid product number.");
                }
                break;
            case 2:
                customer.viewOrderHistory();
                break;
            case 3:
                customer.logout();
                System.out.println("Goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void handleAdminChoice(int adminChoice, Admin admin, List<Product> products, Scanner scanner) {
        switch (adminChoice) {
            case 1:
                System.out.print("Enter the name of the product to add: ");
                scanner.nextLine();                
                String productName = scanner.nextLine();
                Product newProduct = new Product(productName);
                products.add(newProduct);
                admin.addProduct(newProduct);
                break;
            case 2:
                System.out.println("Current Products:");
                for (int i = 0; i < products.size(); i++) {
                    System.out.println((i + 1) + ". " + products.get(i).getName());
                }
                System.out.print("Enter the product number to remove: ");
                int productNumber = scanner.nextInt();
                if (productNumber >= 1 && productNumber <= products.size()) {
                    Product productToRemove = products.get(productNumber - 1);
                    products.remove(productToRemove);
                    admin.removeProduct(productToRemove);
                } else {
                    System.out.println("Invalid product number.");
                }
                break;
            case 3:
                System.out.println("Managing inventory...");
                break;
            case 4:
                admin.logout();
                System.out.println("Goodbye!");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
