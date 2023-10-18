import java.util.InputMismatchException;
import java.util.Scanner;

public class RouteActivity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! We will guide you to the Best Route to Moalboal.");
        char ans = getUserChoice(scanner, "Is Route via Barili obstructed? [Y/N]: ");
        ans = Character.toLowerCase(ans);

        Route route = new Route();
        int speed;

        if (ans == 'y') {
            char ans2 = getUserChoice(scanner, "Is Via Dumajug (Route 2) obstructed? [Y/N]: ");
            ans2 = Character.toLowerCase(ans2);

            if (ans2 == 'y') {
                System.out.println("Since Default route and Route 2 are obstructed, we will be using route 3.");
                speed = getSpeedFromUser(scanner, "Route 3");
                route.route3(speed);
            } else {
                speed = getSpeedFromUser(scanner, "Route 2");
                route.Route2(speed);
            }
        } else if (ans == 'n') {
            speed = getSpeedFromUser(scanner, "Route 1");
            route.defRoute1(speed);
        } else {
            System.out.println("Invalid input. Please enter 'Y' or 'N'.");
        }

        scanner.close();
    }

    static char getUserChoice(Scanner scanner, String message) {
        char choice = ' ';
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(message);
                String input = scanner.next().toLowerCase();
                if (input.equals("y") || input.equals("n")) {
                    choice = input.charAt(0);
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Please enter 'Y' or 'N'.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the invalid input
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
        return choice;
    }

    static int getSpeedFromUser(Scanner scanner, String routeName) {
        int speed = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter the speed for " + routeName + " (km/h): ");
                speed = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the invalid input
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        return speed;
    }

    static class Route {
        void defRoute1(int speed) {
            System.out.println("Default Route:");
            System.out.println("Cebu City...  (Start)");
            System.out.println("Minglanilla... (Route 1)");
            System.out.println("San Fernando... (Route 2)");
            System.out.println("Carcar City... (Route 3)");
            System.out.println("Barili.. (Route 4)");
            System.out.println("Dumajug... (Route 4.2.1)");
            System.out.println("Alcantara... (Route 4.2.2)");
            System.out.println("Moalboal.. (Enjoy your Best Day in Moalboal!)");
            double time = 86.6 / speed;
            System.out.println("Your distance from your location to your destination will be 86.6km");
            displayTime(time);
        }

        void Route2(int speed) {
            System.out.println("Route 2: via Sibonga ");
            System.out.println("Cebu City... (Start)");
            System.out.println("Minglanilla.. (Route 1)");
            System.out.println("San Fernando... (Route 2)");
            System.out.println("Carcar City...  (Route 3)");
            System.out.println("Sibonga...  (Route 4.2)");
            System.out.println("Dumajug...  (Route 4.2.1)");
            System.out.println("Alcantara..  (Route 4.2.2)");
            System.out.println("Moalboal.. (Enjoy your Best Day in Moalboal!)");
            double time = 94.0 / speed;
            System.out.println("Your distance from your location to your destination will be 94.0km");
            displayTime(time);
        }

        void route3(int speed) {
            System.out.println("Route 3: via Argao ");
            System.out.println("Cebu City...  (Start)");
            System.out.println("Minglanilla... (Route 1)");
            System.out.println("San Fernando... (Route 2)");
            System.out.println("Carcar City... (Route 3)");
            System.out.println("Argao... (Route 5)");
            System.out.println("Ronda... (Route 5.1)");
            System.out.println("Alcantara... (Route 5.2)");
            System.out.println("Moalboal.. (Enjoy your Best Day in Moalboal!)");
            double time = 92.2 / speed;
            System.out.println("Your distance from your location to your destination will be 92.2km");
            displayTime(time);
        }

        void displayTime(double time) {
            int hours = (int) time;
            int minutes = (int) ((time - hours) * 60);
            int seconds = (int) ((time - hours - minutes / 60.0) * 3600);
            System.out.println("Estimated Time: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds");
        }
    }
}
