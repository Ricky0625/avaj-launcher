package base;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        id = p_id;
        name = p_name;
        coordinates = p_coordinates;
    }

    @Override
    public void updateConditions() {
    }

    public String getAircraftType() {
        return "UNKNOWN";
    }

    public String getPrefix() {
        return String.format("%s#%s(%d): ", getAircraftType(), name, id);
    }

}
