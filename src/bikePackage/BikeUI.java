package bikePackage;

import static bikePackage.Bike.bikeList;

/**
 * bikePackage.BikeUI provides user interface by: <br>
 * 1. Display the main menu for user to interact with the bike registry system. <br>
 * 2. Display all bikes in the registry. <br>
 * @author Vu Hai Nam Nguyen (301541574)
 */
public class BikeUI {
    // Display the main menu that gives users options to choose, and looped until exit
    public static void displayMainMenu() {
        System.out.print("""
                \n*************
                * Main Menu *
                *************
                1. List bikes
                2. Add a new bike
                3. Remove a bike
                4. Change bike attribute
                5. DEBUG: Dump Objects (toString)
                6. Exit
                """);
    }

    // List all bikes including the bike ID, owner’s name, type, serial number, brake type, and wheel size.
    public static void displayAllBikes() {
        System.out.print("""
            \n*****************
            * List of Bikes *
            *****************
            """);
        String format = "%-5s %-18s %-12s %-12s %-12s %-12s%n";
        System.out.printf(format, "ID", "Owner", "Type", "Serial", "Brake", "Wheel Size");
        for (Bike bike : bikeList) {
            System.out.printf(format, bike.getBid(), bike.getOwner(), bike.getType(), bike.getSerialNumber(), bike.getBrake(), bike.getWheelSize());
        }

    }
}
