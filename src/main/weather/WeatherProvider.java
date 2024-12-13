package weather;

import java.util.Random;

import coords.Coordinates;
import types.WeatherType;

public class WeatherProvider {
    public static WeatherProvider instance;
    private final String[] weather = WeatherType.getWeathers();
    private final Random random = new Random();

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int bias = (p_coordinates.getLongitude() + p_coordinates.getLatitude()
                + p_coordinates.getHeight()) % weather.length;
        int index = (random.nextInt(weather.length) + bias) % weather.length;
        return weather[index];
    }

}
