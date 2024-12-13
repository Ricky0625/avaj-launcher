package base;

import aircraft.AircraftMetadata;
import weather.WeatherTower;

public interface Flyable extends AircraftMetadata {
    void updateConditions();

    void registerTower(WeatherTower p_tower);
}
