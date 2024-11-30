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

    public AircraftType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

}
