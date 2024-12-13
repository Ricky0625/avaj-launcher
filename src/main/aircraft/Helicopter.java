package aircraft;

import java.util.HashMap;
import java.util.Map;

import base.Aircraft;
import coords.Coordinates;
import types.AircraftType;
import types.WeatherType;
import utils.LoggerUtils;

public class Helicopter extends Aircraft {

    private static final Map<WeatherType, String> weatherMsg;

    static {
        // helipcoter is a boomer
        weatherMsg = new HashMap<>();
        weatherMsg.put(WeatherType.SUN, "Ah, classic flying weather.");
        weatherMsg.put(WeatherType.RAIN, "Rain? Back in my day, we flew through worse.");
        weatherMsg.put(WeatherType.FOG, "Fog? My blades got this.");
        weatherMsg.put(WeatherType.SNOW, "Snow? Just power through like the old days.");
    }

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        WeatherType weather = WeatherType.fromString(weatherTower.getWeather(getCoordinates()));
        final int currentLongitude = coordinates.getLongitude();
        final int currentHeight = coordinates.getHeight();

        switch (weather) {
            case SUN:
                coordinates.setLongitude(currentLongitude + 10);
                coordinates.setHeight(currentHeight + 2);
                break;

            case RAIN:
                coordinates.setLongitude(currentLongitude + 5);
                break;

            case FOG:
                coordinates.setLongitude(currentLongitude + 1);
                break;

            case SNOW:
                coordinates.setHeight(currentHeight - 12);
                break;
        }

        LoggerUtils.log(super.getPrefix() + weatherMsg.get(weather));

        if (coordinates.getHeight() <= 0) {
            weatherTower.unregister(this);
            return;
        }
    }

    @Override
    public String getAircraftType() {
        return AircraftType.HELICOPTER.toString();
    }

}
