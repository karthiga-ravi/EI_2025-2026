package SatelliteSystem.core;

public class Satellite {
    private SatelliteState state;
    private SatelliteLogger logger;

    private Direction orientation = Direction.NORTH;  // enum instead of String

    public Satellite() {
        this.state = new SatelliteState("North", "Inactive", 0);
        this.logger = new SatelliteLogger();
        logger.log("Satellite initialized with orientation North, panels Inactive, data 0.");
    }

    public void rotate(Direction newDirection) {
        if (newDirection == null) {
            System.out.println("Cannot rotate: Invalid direction.");
            return;
        }

        if (newDirection == orientation) {
            System.out.println("Satellite is already facing " + newDirection);
        } else {
            orientation = newDirection;
            logger.log("Satellite rotated to " + orientation);
        }
    }

    public void activatePanels() {
        if ("Active".equals(state.getPanels())) {
            logger.log("Panels are already active.");
        } else {
            state.setPanels("Active");
            logger.log("Solar panels activated.");
        }
    }

    public void deactivatePanels() {
        if ("Inactive".equals(state.getPanels())) {
            logger.log("Panels are already inactive.");
        } else {
            state.setPanels("Inactive");
            logger.log("Solar panels deactivated.");
        }
    }

    public void collectData() {
        if ("Active".equals(state.getPanels())) {
            state.setDataCollected(state.getDataCollected() + 10);
            logger.log("Data collected: +10 units. Total = " + state.getDataCollected());
        } else {
            logger.log("Cannot collect data. Panels are inactive.");
        }
    }

    public SatelliteState getState() {
        return state;
    }

    public void printStatus() {
        System.out.println("Current Satellite State: " + state);
    }
}
