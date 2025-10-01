package SatelliteSystem.commands;

import SatelliteSystem.core.Direction;
import SatelliteSystem.core.Satellite;

public class RotateCommand implements Command {
    private final Satellite satellite;
    private final Direction direction;

    public RotateCommand(Satellite satellite, String directionInput) {
        this.satellite = satellite;
        this.direction = Direction.fromString(directionInput);
    }

    @Override
    public void execute() {
        satellite.rotate(direction); // now strictly uses enum
    }
}
