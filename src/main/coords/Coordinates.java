package coords;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    // package-private constructor, can only instantiated in coords package
    Coordinates(int p_longitude, int p_latitude, int p_height) {
        longitude = p_longitude;
        latitude = p_latitude;
        height = p_height;
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

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setHeight(int height) {
        this.height = Math.max(0, height);
    }

    @Override
    public String toString() {
        return String.format("[%d,%d,%d]", longitude, latitude, height);
    }
}
