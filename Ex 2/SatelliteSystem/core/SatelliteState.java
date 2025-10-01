package SatelliteSystem.core;

public class SatelliteState {
    private String orientation;
    private String panels;
    private int dataCollected;

    public SatelliteState(String orientation, String panels, int dataCollected) {
        this.orientation = orientation;
        this.panels = panels;
        this.dataCollected = dataCollected;
    }

    public String getOrientation() { return orientation; }
    public void setOrientation(String orientation) { this.orientation = orientation; }

    public String getPanels() { return panels; }
    public void setPanels(String panels) { this.panels = panels; }

    public int getDataCollected() { return dataCollected; }
    public void setDataCollected(int dataCollected) { this.dataCollected = dataCollected; }

    @Override
    public String toString() {
        return "[Orientation=" + orientation + 
               ", Panels=" + panels + 
               ", Data Collected=" + dataCollected + "]";
    }
}