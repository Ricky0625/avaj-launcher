package types;

public enum AircraftType {
    HELICOPTER,
    JETPLANE,
    BALOON;

    public static AircraftType fromString(String name) {
        return AircraftType.valueOf(name.toUpperCase());
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
