package aircraft;

import java.util.HashMap;
import java.util.Map;

import base.Aircraft;
import coords.Coordinates;
import types.AircraftType;
import types.WeatherType;
import utils.LoggerUtils;

public class JetPlane extends Aircraft {

    private static final Map<WeatherType, String> weatherMsg;

    static {
        // personality: a show-off king
        weatherMsg = new HashMap<>();
        weatherMsg.put(WeatherType.SUN, "Shining brigther than the sun, as usual.");
        weatherMsg.put(WeatherType.RAIN, "Raining? Watch me dodge every drop.");
        weatherMsg.put(WeatherType.FOG, "Fog? Easy, I'm built different.");
        weatherMsg.put(WeatherType.SNOW, "Snow? Just another flex opportunity.");
    }

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        WeatherType weather = WeatherType.fromString(weatherTower.getWeather(getCoordinates()));
        final int currentLatitude = coordinates.getLatitude();
        final int currentHeight = coordinates.getHeight();

        switch (weather) {
            case SUN:
                coordinates.setLatitude(currentLatitude + 10);
                coordinates.setHeight(currentHeight + 2);
                break;

            case RAIN:
                coordinates.setLatitude(currentLatitude + 5);
                break;

            case FOG:
                coordinates.setLatitude(currentLatitude + 1);
                break;

            case SNOW:
                coordinates.setHeight(currentHeight - 7);
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
        return AircraftType.JETPLANE.toString();
    }
}
