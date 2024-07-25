import java.util.ArrayList;
import java.util.List;

public class FleetManager {
    private List<Vehicle> vehicles;

    public FleetManager() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
        }
    }

    public List<Vehicle> getVehicles() {
        return new ArrayList<>(vehicles);
    }

    public Vehicle findSuitableVehicle(int capacity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findSuitableVehicle'");
    }
}
