package SatelliteSystem.patterns;

import SatelliteSystem.commands.ActivatePanelsCommand;
import SatelliteSystem.commands.CollectDataCommand;
import SatelliteSystem.commands.Command;
import SatelliteSystem.commands.DeactivatePanelsCommand;
import SatelliteSystem.commands.RotateCommand;
import SatelliteSystem.core.Satellite;

public class CommandFactory {
    public static Command createCommand(String type, Satellite satellite, String... args) {
        switch (type.toLowerCase()) {
            case "rotate":
                if (args.length < 1) {
                    throw new IllegalArgumentException("Rotate command requires a direction argument.");
                }
                return new RotateCommand(satellite, args[0]);
            case "activate":
                return new ActivatePanelsCommand(satellite);
            case "deactivate":
                return new DeactivatePanelsCommand(satellite);
            case "collect":
                return new CollectDataCommand(satellite);
            default:
                throw new IllegalArgumentException("Unknown command: " + type);
        }
    }
}