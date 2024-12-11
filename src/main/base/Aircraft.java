package base;

import coords.Coordinates;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

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

}
