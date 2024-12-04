package weather;

import base.Coordinates;
import base.Tower;

public class WeatherTower extends Tower {

    public WeatherTower() {
    }

    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(p_coordinates);
    }

    public void changeWeather() {
        contitionChanged(); // from Tower class
    }

}
