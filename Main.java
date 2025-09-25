package SatelliteSystem;

import java.util.Scanner;

import SatelliteSystem.commands.Command;
import SatelliteSystem.core.Satellite;
import SatelliteSystem.patterns.CommandFactory;
import SatelliteSystem.patterns.SatelliteSingleton;

public class Main {
    public static void main(String[] args) {
        Satellite satellite = SatelliteSingleton.getInstance();
        Scanner scanner = new Scanner(System.in);

        boolean run=true;

        System.out.println("Welcome to the Satellite Command System");
        System.out.println("Select an option:");
        System.out.println("1. Rotate");
        System.out.println("2. Activate Solar Panels");
        System.out.println("3. Deactivate Solar Panels");
        System.out.println("4. Collect Data");
        System.out.println("5. Status");
        System.out.println("6. Exit");

        while (run) {
            System.out.print("\nEnter option: ");
            String input = scanner.nextLine().trim().toLowerCase();

            switch (input) {
                case "1": // Rotate
                    System.out.print("Enter direction (North, South, East, West): ");
                    String direction = scanner.nextLine().trim();
                    try {
                        Command rotate = CommandFactory.createCommand("rotate", satellite, direction);
                        rotate.execute();
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case "2": // Activate panels
                    Command activate = CommandFactory.createCommand("activate", satellite);
                    activate.execute();
                    break;

                case "3": // Deactivate panels
                    Command deactivate = CommandFactory.createCommand("deactivate", satellite);
                    deactivate.execute();
                    break;

                case "4": // Collect data
                    Command collect = CommandFactory.createCommand("collect", satellite);
                    collect.execute();
                    break;

                case "5": // Status
                    satellite.printStatus();
                    break;

                case "6": // Exit
                    System.out.println("Exiting Satellite Command System...");
                    run=false;
                    break;

                default:
                    System.out.println("Invalid option. Please enter 1-6.");
                    break;
            }
        }
    }
}
