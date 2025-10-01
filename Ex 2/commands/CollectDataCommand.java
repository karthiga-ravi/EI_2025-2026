package SatelliteSystem.commands;

import SatelliteSystem.core.Satellite;

public class CollectDataCommand implements Command {
    private Satellite satellite;

    public CollectDataCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
         if ("Inactive".equals(satellite.getState().getPanels())) {
            System.out.println("Cannot collect data. Panels are inactive.");
        } else {
            satellite.collectData();
        }
    }
}