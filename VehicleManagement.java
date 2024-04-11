//add vehicle details
//ABC123, Toyota, 2018, Php25000.0
//XYZ456, Honda, 2020, Php18000.0
//DEF789, Ford, 2015, Php30000.0
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class VehicleManagement {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter registration number: ");
                    String regNo = scanner.nextLine();
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter year of manufacture: ");
                    int yearOfManufacture = scanner.nextInt();
                    System.out.print("Enter value: ");
                    double value = scanner.nextDouble();
                    vehicleList.add(new Vehicle(regNo, make, yearOfManufacture, value));
                    System.out.println("Vehicle added successfully!");
                    System.out.println();
                    break;
                case 2:
                    System.out.println("List of vehicle details:");
                    for (Vehicle vehicle : vehicleList) {
                        System.out.println(vehicle);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Enter the index of the vehicle to delete: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < vehicleList.size()) {
                        vehicleList.remove(index);
                        System.out.println("Vehicle deleted successfully!");
                    } else {
                        System.out.println("Invalid index!");
                    }
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    sortMenu(scanner, vehicleList);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Exiting program...");
                    System.out.println();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    public static void sortMenu(Scanner scanner, ArrayList<Vehicle> vehicleList) {
        int sortChoice;
        do {
            System.out.println("Sort Menu:");
            System.out.println("1. Sort by age (ascending)");
            System.out.println("2. Sort by age (descending)");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");
            sortChoice = scanner.nextInt();
            scanner.nextLine();

            switch (sortChoice) {
                case 1:
                    Collections.sort(vehicleList, (vehicle1, vehicle2) -> Integer.compare(vehicle1.getYearOfManufacture(), vehicle2.getYearOfManufacture()));
                    System.out.println("List of vehicle details sorted by age (ascending):");
                    for (Vehicle vehicle : vehicleList) {
                        System.out.println(vehicle);
                    }
                    System.out.println();
                    break;
                case 2:
                    Collections.sort(vehicleList, (vehicle1, vehicle2) -> Integer.compare(vehicle2.getYearOfManufacture(), vehicle1.getYearOfManufacture()));
                    System.out.println("List of vehicle details sorted by age (descending):");
                    for (Vehicle vehicle : vehicleList) {
                        System.out.println(vehicle);
                    }
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (sortChoice != 3);
    }
}