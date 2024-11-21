import entity.Command;
import entity.DisplayType;
import entity.ParkingLot;
import entity.VehicleType;
import service.ParkingLotService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    // Define color codes for terminal output
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.next().toUpperCase();  // Convert input to uppercase
            try {
                Command type = Command.valueOf(input);  // Match the input with the enum, now case-insensitive
                switch (type) {
                    case CREATE_PARKING_LOT:
                        parkingLotService.createParkingLot(new ParkingLot(scanner.next(), scanner.nextInt(), scanner.nextInt()));
                        break;
                    case PARK_VEHICLE:
                        parkingLotService.parkVehicle(VehicleType.valueOf(scanner.next()), scanner.next(), scanner.next());
                        break;
                    case UNPARK_VEHICLE:
                        parkingLotService.unParkedVechile(scanner.next());
                        break;
                    case DISPLAY:
                        parkingLotService.display(DisplayType.valueOf(scanner.next()), VehicleType.valueOf(scanner.next()));
                        break;
                    case EXIT:
                        System.out.println("Exiting program...");
                        scanner.close();
                        return;
                    case HELP:
                        printHelp();
                        break;
                    default:
                        System.out.println(RED + "Invalid command. Please try again." + RESET);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(RED + "Invalid input. Please try again." + RESET);
            }
        }
    }

    private static void printHelp() {
        // Print commands with descriptions
        for (Command command : Command.values()) {
            System.out.printf("%-20s : %s%n", command.toString(), command.getDescription());
            // Print command syntax to System.err in green
            System.err.println(GREEN + "Syntax: " + RESET + command.getSyntax());
        }

        // Convert VehicleType enum values to string array and join them
        String vehicleTypes = Arrays.stream(VehicleType.values())
                .map(Enum::name)  // Convert each enum value to a string
                .collect(Collectors.joining(", "));
        // Print vehicle types in green
        System.out.println(GREEN + "Vehicle Types: " + RESET + vehicleTypes);

        // Convert DisplayType enum values to string array and join them
        String displayTypes = Arrays.stream(DisplayType.values())
                .map(DisplayType::toString)  // Convert each enum value to a string
                .collect(Collectors.joining(", "));  // Join the strings with a comma and space
        // Print display types in green
        System.out.println(GREEN + "Display Types: " + RESET + displayTypes);
    }
}
