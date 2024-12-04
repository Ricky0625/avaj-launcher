package base;

import aircraft.AircraftMetadata;
import weather.WeatherTower;

public interface Flyable extends AircraftMetadata {
    // by default it's abstract and public
    void updateConditions();

    void registerTower(WeatherTower p_tower);

}
