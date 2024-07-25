// Scheduler.java
import java.util.List;

public class Scheduler {
  private DatabaseManager databaseManager;

  public Scheduler(DatabaseManager databaseManager) {
    this.databaseManager = databaseManager;
  }

  public void scheduleTrip(Trip trip, Vehicle vehicle) {
    databaseManager.scheduleTrip(trip, vehicle);
  }

  public List<Trip> getTrips(Vehicle vehicle) {
    return databaseManager.getTrips(vehicle);
  }

public static void schedule(Trip trip) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'schedule'");
}
}