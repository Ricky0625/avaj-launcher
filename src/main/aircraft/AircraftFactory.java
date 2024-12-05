package aircraft;

import base.Flyable;
import coords.Coordinates;
import types.AircraftType;

public class AircraftFactory {

    private static AircraftFactory instance;
    private long currentId = 1;

    private AircraftFactory() {
    }

    public static AircraftFactory getInstance() {
        if (instance == null) {
            instance = new AircraftFactory();
        }
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {

        AircraftType type = AircraftType.fromString(p_type);
        Flyable aircraft;

        switch (type) {
            case HELICOPTER:
                aircraft = new Helicopter(currentId++, p_name, p_coordinates);
                break;

            case JETPLANE:
                aircraft = new JetPlane(currentId++, p_name, p_coordinates);
                break;

            case BALOON:
                aircraft = new Baloon(currentId++, p_name, p_coordinates);
                break;

            default:
                throw new IllegalArgumentException("Unknown AircraftType: " + type);
        }
        return aircraft;
    }
}
