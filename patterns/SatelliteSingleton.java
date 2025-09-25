package SatelliteSystem.patterns;

import SatelliteSystem.core.Satellite;

public class SatelliteSingleton {
    private static Satellite instance;

    private SatelliteSingleton() {}

    public static Satellite getInstance() {
        if (instance == null) {
            instance = new Satellite();
        }
        return instance;
    }
}