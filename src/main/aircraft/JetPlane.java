package aircraft;

import base.Aircraft;
import base.Coordinates;
import types.AircraftType;
import utils.LoggerUtils;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(getCoordinates());
        LoggerUtils.log(getPrefix() + weather);
    }

    @Override
    public String getAircraftType() {
        return AircraftType.JETPLANE.toString();
    }
}
