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

    public static String[] getWeathers() {
        WeatherType[] types = WeatherType.values();
        String[] weathers = new String[types.length];

        for (int i = 0; i < types.length; i++) {
            weathers[i] = types[i].name();
        }

        return weathers;
    }

    public static WeatherType fromString(String name) throws IllegalArgumentException {
        return WeatherType.valueOf(name.toUpperCase());
    }
}
