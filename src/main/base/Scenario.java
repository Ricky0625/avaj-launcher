package base;

import types.AircraftType;

public class Scenario {

    private final AircraftType type;
    private final String name;
    private final Coordinates coordinates;

    public Scenario(final AircraftType type, final String name, final Coordinates coordinates) {
        this.type = type;
        this.name = name;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type.toString();
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "[TYPE] " + type.toString() + "\n[NAME] " + name + "\n[Coord] " + coordinates.toString();
    }

}
