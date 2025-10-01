package SatelliteSystem.commands;

import SatelliteSystem.core.Satellite;

public class DeactivatePanelsCommand implements Command {
    private Satellite satellite;

    public DeactivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
         if ("Inactive".equals(satellite.getState().getPanels())) {
            System.out.println("Solar panels are already inactive.");
        } else {
        satellite.deactivatePanels();
        }
    }
}