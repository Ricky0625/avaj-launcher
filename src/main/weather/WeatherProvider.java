package weather;

import base.Coordinates;
import types.WeatherType;

public class WeatherProvider {
    public static WeatherProvider instance;
    private final String[] weather = WeatherType.getWeathers();

    private WeatherProvider() {
    }

    public static WeatherProvider getInstance() {
        if (instance == null) {
            instance = new WeatherProvider();
        }
        return instance;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int index = getSeed(p_coordinates) % weather.length;
        return weather[index];
    }

    // ah damn how should i test it?
    private int getSeed(final Coordinates p_coordinates) {
        long timeFactor = System.currentTimeMillis() / 10000; // change every sec
        // bday algo lol
        int seed = 6 * p_coordinates.getLongitude()
                + 2 * p_coordinates.getLatitude()
                + 5 * p_coordinates.getHeight();
        // prevent overflow. since coords are positive, seed should not be negative
        return (seed + (int) timeFactor) % Integer.MAX_VALUE;
    }

}
