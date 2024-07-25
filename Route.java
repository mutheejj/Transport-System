import java.util.ArrayList;
import java.util.List;

public class Route {
  private List<String> waypoints;
  private int capacity;

  public Route() {
    waypoints = new ArrayList<>();
  }

  public void addWaypoint(String waypoint) {
    waypoints.add(waypoint);
  }

  public List<String> getWaypoints() {
    return waypoints;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}