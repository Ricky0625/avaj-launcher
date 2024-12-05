package weather;

import coords.Coordinates;
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

    private int getSeed(final Coordinates p_coordinates) {
        // bday algo lol
        int seed = 6 * p_coordinates.getLongitude()
                + 2 * p_coordinates.getLatitude()
                + 5 * p_coordinates.getHeight();
        // prevent overflow. since coords are positive, seed should not be negative
        return seed % Integer.MAX_VALUE;
    }

}
