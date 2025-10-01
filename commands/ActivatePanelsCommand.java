package SatelliteSystem.commands;

import SatelliteSystem.core.Satellite;

public class ActivatePanelsCommand implements Command {
    private Satellite satellite;

    public ActivatePanelsCommand(Satellite satellite) {
        this.satellite = satellite;
    }

    @Override
    public void execute() {
        if ("Active".equals(satellite.getState().getPanels())) {
            System.out.println("Solar panels are already active.");
        } else {
        satellite.activatePanels();
        }
    }
}