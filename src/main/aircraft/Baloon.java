package aircraft;

import base.Aircraft;
import base.Coordinates;
import types.AircraftType;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
    }

    @Override
    public String getAircraftType() {
        return AircraftType.BALOON.toString();
    }

}
