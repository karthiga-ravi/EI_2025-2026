package SatelliteSystem.core;

import java.time.LocalDateTime;

public class SatelliteLogger {
    public void log(String message) {
        System.out.println(LocalDateTime.now() + " [LOG] " + message);
    }
}