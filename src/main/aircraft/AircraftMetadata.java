package aircraft;

import base.Coordinates;

// some util functions to get aircraft metadata from the Flyable
public interface AircraftMetadata {
    String getAircraftType();

    String getName();

    Coordinates getCoordinates();
}