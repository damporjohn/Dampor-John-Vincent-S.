import java.util.Scanner;

public class ActivtyThreeDampor {
    public static void main(String[] args) 
    {   
        // Here in this step, is where you define the exchange rate from PHP to USD
        double exchangeRate = 0.019; // 1 PHP = 0.019 USD

        // Here in this step, by using arrays you can define the menu and add-ons
        String[] menuItems = {"c1", "c2", "c3"};
        double[] menuPrices = {100.00, 150.00, 200.00};

        String[] addonItems = {"r1", "r2"};
        double[] addonPrices = {35.00, 50.00};

        // Here in this step, is the initializing variables to store order info
        int[] orderQuantities = new int[menuItems.length + addonItems.length];
        double totalCost = 0.00;

        // Here in this step, is where you create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Here in this step, is the display the menu
        System.out.println("Menu:");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println("*" + menuItems[i] + " = PHP " + menuPrices[i]);
        }

        // Here in this step, is the display the add-ons
        System.out.println("\nAdd-ons:");
        for (int i = 0; i < addonItems.length; i++) {
            System.out.println("*" + addonItems[i] + " = PHP " + addonPrices[i]);
        }

        // Here in this step, is where you take customer orders
        while (true) {
            System.out.print("\nChoose item or items from 'Menu, Add-ons'.\nType 'done, Done, DONE' to finish: ");
            String item = scanner.nextLine().trim().toLowerCase();

            if (item.equalsIgnoreCase("done"))

            {
                break;
            }

            boolean itemFound = false;

            // Here in this step, is where you check if the item is in the menu. If not. the statment on "if (!itemFound)" will show.
            for (int i = 0; i < menuItems.length; i++) {
                if (item.equals(menuItems[i])) {
                    orderQuantities[i]++;
                    totalCost += menuPrices[i];
                    itemFound = true;
                    break;
                }
            }

            // Here in this step, is where you check if the item is in the add-ons. If not, the statment on "if (!itemFound)" will show.
            if (!itemFound) {
                for (int i = 0; i < addonItems.length; i++) {
                    if (item.equals(addonItems[i])) {
                        orderQuantities[menuItems.length + i]++;
                        totalCost += addonPrices[i];
                        itemFound = true;
                        break;
                    }
                }
            }

            if (!itemFound) {
                System.out.println("Item not found! Please select an item from the menu or add-ons.");
            }
        }

        // Here in this step is where you calculate the total cost in USD
        double totalCostUSD = totalCost * exchangeRate;


        // Here in this step, is where you'll see the formula of the order summary and its display
        System.out.println("\nOrder Summary:");
        for (int i = 0; i < menuItems.length + addonItems.length; i++) {
            if (orderQuantities[i] > 0) {
                String itemName = (i < menuItems.length) ? menuItems[i] : addonItems[i - menuItems.length];
                double itemCost = (i < menuItems.length) ? menuPrices[i] : addonPrices[i - menuItems.length];
                System.out.println(itemName + " x" + orderQuantities[i] + " = PHP " + (itemCost * orderQuantities[i]));
            }
        }

        System.out.println("Total Cost: PHP " + totalCost);
        System.out.println("Total Cost in USD: $" + totalCostUSD);

        // last step, Close the scanner
        scanner.close();
    }
}
