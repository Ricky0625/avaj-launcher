package aircraft;

import base.Aircraft;
import base.Coordinates;
import types.AircraftType;

public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
    }

    @Override
    public String getAircraftType() {
        return AircraftType.HELICOPTER.toString();
    }
}
