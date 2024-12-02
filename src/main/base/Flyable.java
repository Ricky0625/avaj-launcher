package base;

import weather.WeatherTower;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    abstract public void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
        weatherTower.register(this);
    }

}
