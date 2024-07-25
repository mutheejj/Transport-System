import java.util.List;

public class Tracker {
  private DatabaseManager databaseManager;

  public Tracker(DatabaseManager databaseManager) {
    this.databaseManager = databaseManager;
  }

  public void trackLocation(Vehicle vehicle, Location location) {
    databaseManager.trackLocation(vehicle, location);
  }

  public List<Location> getLocations(Vehicle vehicle) {
    return databaseManager.getLocations(vehicle);
  }
}
