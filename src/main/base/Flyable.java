package base;

import aircraft.AircraftMetadata;
import weather.WeatherTower;

public abstract class Flyable implements AircraftMetadata {

    protected WeatherTower weatherTower;

    // by default is public
    abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }

}
