import bikePackage.Bike;
import java.util.Scanner;
import static bikePackage.BikeUI.displayAllBikes;
import static bikePackage.BikeUI.displayMainMenu;

public class Main {
    public static void main(String[] args) {
        System.out.print("""
                **************************************************
                * Bike Registry by Vu Hai Nam Nguyen (301541574) *
                **************************************************
                """);

        Scanner userInput = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            displayMainMenu();
            try {
                System.out.print("> ");
                String command = userInput.next();
                switch (command) {
                    case "1":
                        displayAllBikes();
                        break;
                    case "2":
                        Bike.addNewBike();
                        break;
                    case "3":
                        Bike.deleteBike();
                        break;
                    case "4":
                        Bike.alterBike();
                        break;
                    case "5":
                        Bike.dumpObjects();
                        break;
                    case "6":
                        flag = false;
                        System.out.println("Thank you for using our service! Bye-bye!");
                        break;
                    default:
                        System.out.print("Invalid command... Try again!\n");
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        userInput.close();
    }
}