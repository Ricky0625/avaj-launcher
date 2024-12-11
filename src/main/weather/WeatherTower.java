package weather;

import coords.Coordinates;
import base.Tower;

public class WeatherTower extends Tower {

    public WeatherTower() {
    }

    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        super.contitionChanged();
    }

}
