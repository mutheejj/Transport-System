import java.sql.Timestamp;
import java.util.Date;

public class Location {
    private int locationID;
    private Vehicle vehicle;
    private double latitude;
    private double longitude;
    private Date timestamp;

    public Location(int locationID, Vehicle vehicle, double latitude, double longitude, Date timestamp) {
        this.locationID = locationID;
        this.vehicle = vehicle;
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTimestamp() {
        return new Timestamp(timestamp.getTime());
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}