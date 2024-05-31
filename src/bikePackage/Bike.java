package bikePackage;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import bikePackage.Bike;

import static bikePackage.BikeUI.displayAllBikes;

/**
 * bikePackage.Bike Registry System that provides services for the user:<br>
 * 1. Add a new bike. Prompt the user for the owner’s name, type, serial number, brake type, and wheel size. The program should save the information while assigning a unique bike ID that is not already taken. Invalid inputs should be handled appropriately.<br>
 * 2. Delete a bike. First list all current bikes and allow the user to choose the bike to delete (or 0 to cancel). Entering an invalid input should be handled by the program.<br>
 * 3. Alter bike attributes. First list all current bikes, allow the user to choose the bike to alter, then prompt the user to choose which attribute to alter. Once again, you will need to handle invalid inputs.<br>
 * 4. Display the toString() on each bike in the system. This should print out the bikes in the format described in the sample output. It should include the package, followed by the class (not hard coded), followed by the fields of the object.<br>
 * @author Vu Hai Nam Nguyen (301541574)
 */
public class Bike {
    private int bid;
    private String owner;
    private String type;
    private String serialNumber;
    private String brake;
    private double wheelSize;
    public static List<Bike> bikeList = new ArrayList<Bike>();
    private static int count = 0;

    // Constructor, Getters, and Setters.
    public Bike(int bid, String owner, String type, String serialNumber, String brake, double wheelSize) {
        this.bid = bid;
        this.owner = owner;
        this.type = type;
        this.serialNumber = serialNumber;
        this.brake = brake;
        this.wheelSize = wheelSize;
    }
    public int getBid() {
        return bid;
    }
    public void setBid(int bid) {
        this.bid = bid;
    }
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getBrake() {
        return brake;
    }
    public void setBrake(String brake) {
        this.brake = brake;
    }
    public double getWheelSize() {
        return wheelSize;
    }
    public void setWheelSize(double wheelSize) {
        this.wheelSize = wheelSize;
    }

    // Add a new bike. Prompt the user for the owner’s name, type, serial number, brake type, and wheel size.
    // The program should save the information while assigning a unique bike ID that is not already taken.
    // Invalid inputs should be handled appropriately.
    public static void addNewBike() {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter bike owner name:\t\t\t");
        String ownerName = userInput.nextLine();
        System.out.print("Enter bike type:\t\t\t\t");
        String bikeType = userInput.nextLine();
        System.out.print("Enter bike's serial number:\t\t");
        String serialNumber = userInput.nextLine();
        System.out.print("Enter bike's brake type:\t\t");
        String brakeType = userInput.nextLine();
        double wheelSize = 0;
        while (true) {
            System.out.print("Enter bike's wheel size:\t\t");
            if (userInput.hasNextDouble()) {
                wheelSize = userInput.nextDouble();
                userInput.nextLine();
                break;
            } else {
                System.out.println("Invalid input... Wheel size must be a number!");
                userInput.nextLine();
            }
        }

        Bike newBike = new Bike(++count, ownerName, bikeType, serialNumber, brakeType, wheelSize);
        bikeList.add(newBike);
    }

    // Delete a bike. First list all current bikes and allow the user to choose the bike to delete (or 0 to cancel).
    // Entering an invalid input should be handled by the program.
    public static void deleteBike() {
        displayAllBikes();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter ID (0 to cancel)");
        System.out.print("> ");
        int selection = userInput.nextInt();

        if (selection == 0) {
            return;
        } else if (selection > 0 && selection <= count) {
            bikeList.remove(selection - 1);
            for (Bike bike : bikeList) {
                if (bike.getBid() > selection) {
                    bike.setBid(bike.getBid() - 1);
                }
            }
            count--;
        } else {
            System.out.println("Invalid ID selection... Try again!");
        }
    }

    // Alter bike attributes. First list all current bikes, allow the user to choose the bike to alter, then prompt the user to choose which attribute to alter.
    // Once again, you will need to handle invalid inputs.
    public static void alterBike() {
        displayAllBikes();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter ID (0 to cancel)");
        System.out.print("> ");
        int selection = userInput.nextInt();
        userInput.nextLine();
        if (selection == 0) {
            return;
        } else if (selection > 0 && selection <= count) {
            Bike modifiedBike = bikeList.get(selection - 1);
            System.out.println(count);
            System.out.println("Which Attribute?");
            System.out.print("> ");
            String attribute = userInput.nextLine();
            switch (attribute.toLowerCase()) {
                case "owner":
                    System.out.println("New owner name:");
                    System.out.print("> ");
                    modifiedBike.setOwner(userInput.nextLine());
                    System.out.println("Saved!");
                    return;
                case "type":
                    System.out.println("New bike type:");
                    System.out.print("> ");
                    modifiedBike.setType(userInput.nextLine());
                    System.out.println("Saved!");
                    return;
                case "serial":
                    System.out.println("New serial number:");
                    System.out.print("> ");
                    modifiedBike.setSerialNumber(userInput.nextLine());
                    System.out.println("Saved!");
                    return;
                case "brake":
                    System.out.println("New brake type:");
                    System.out.print("> ");
                    modifiedBike.setBrake(userInput.nextLine());
                    System.out.println("Saved!");
                    return;
                case "wheel size":
                    while (true) {
                        System.out.println("New wheel size:");
                        System.out.print("> ");
                        if (userInput.hasNextDouble()) {
                            modifiedBike.setWheelSize(userInput.nextDouble());
                            userInput.nextLine();
                            System.out.println("Saved!");
                            break;
                        } else {
                            System.out.println("Invalid input... Wheel size must be a number!");
                            userInput.nextLine();
                        }
                    }
                    return;
                default:
                    System.out.println("Invalid attribute selection... Try again!");
                    return;
            }
        } else {
            System.out.println("Invalid ID selection... Try again!");
        }
    }

    // Display the toString() on each bike in the system. This should print out the bikes in the format described in the sample output.
    // It should include the package, followed by the class (not hard coded), followed by the fields of the object.
    public static void dumpObjects() {
        int index = 1;
        System.out.println("All Bike Objects:");
        for (Bike bike : bikeList) {
            System.out.println(index++ + ". " + bike.toString());
        }
    }
    @Override
    public String toString() {
        return getClass().getName() + "[Id: " + bid + ", Owner: " + owner + ", Type: " + type + ", Serial Number: " + serialNumber + ", Brake Type: " + brake + ", Wheel Size: " + wheelSize + "]";
    }
}
