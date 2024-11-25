package base;

import types.AircraftType;

public class Scenario {

    private final AircraftType type;
    private final String name;
    private final int longitude;
    private final int latitude;
    private final int height;

    public Scenario(
            final AircraftType type,
            final String name,
            final int longitude,
            final int latitude,
            final int height) {
        this.type = type;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public AircraftType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }
}
