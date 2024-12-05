package aircraft;

import java.util.HashMap;
import java.util.Map;

import base.Aircraft;
import types.WeatherType;
import coords.Coordinates;
import types.AircraftType;
import utils.LoggerUtils;

public class Baloon extends Aircraft {

    private static final Map<WeatherType, String> weatherMsg;

    static {
        // shy nerdy kid
        weatherMsg = new HashMap<>();
        weatherMsg.put(WeatherType.SUN, "Warm sun... D-don’t pop me!");
        weatherMsg.put(WeatherType.RAIN, "U-uhm, please stop raining...");
        weatherMsg.put(WeatherType.FOG, "I c-can't see! Should I just stay here?");
        weatherMsg.put(WeatherType.SNOW, "S-s-snow?! Time to go down... slowly.");
    }

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        WeatherType weather = WeatherType.fromString(weatherTower.getWeather(getCoordinates()));
        final int currentLongitude = coordinates.getLongitude();
        final int currentHeight = coordinates.getHeight();

        switch (weather) {
            case SUN:
                coordinates.setLongitude(currentLongitude + 2);
                coordinates.setHeight(currentHeight + 4);
                break;

            case RAIN:
                coordinates.setHeight(currentHeight - 5);
                break;

            case FOG:
                coordinates.setHeight(currentHeight - 3);
                break;

            case SNOW:
                coordinates.setHeight(currentHeight - 15);
                break;
        }

        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            return;
        }

        LoggerUtils.log(super.getPrefix() + weatherMsg.get(weather));
    }

    @Override
    public String getAircraftType() {
        return AircraftType.BALOON.toString();
    }
}
