package base;

import coords.Coordinates;
import weather.WeatherTower;

public class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected WeatherTower weatherTower;

    // "TYPE#NAME(UNIQUE_ID): "
    protected final String PREFIX_TEMPLATE = "%s#%s(%d): ";

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
    }

    @Override
    public String getAircraftType() {
        throw new UnsupportedOperationException("Unimplemented method 'getAircraftType'");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Coordinates getCoordinates() {
        return coordinates;
    }

    protected String getPrefix() {
        return String.format(PREFIX_TEMPLATE, getAircraftType(), getName(), id);
    }

    @Override
    public void updateConditions() {
        // do nothing
    }

    @Override
    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }

}
