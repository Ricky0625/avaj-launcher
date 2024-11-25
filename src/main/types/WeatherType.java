package types;

public enum WeatherType {
    RAIN,
    FOG,
    SUN,
    SNOW;

    @Override
    public String toString() {
        return name();
    }
}
