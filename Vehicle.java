public class Vehicle {
  private int vehicleID;
  private String vehicleType;
  private int capacity;

  public Vehicle(String vehicleType, int capacity) {
      this.vehicleType = vehicleType;
      this.capacity = capacity;
  }

  public int getVehicleID() {
      return vehicleID;
  }

  public void setVehicleID(int vehicleID) {
      this.vehicleID = vehicleID;
  }

  public String getVehicleType() {
      return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
      this.vehicleType = vehicleType;
  }

  public int getCapacity() {
      return capacity;
  }

  public void setCapacity(int capacity) {
      this.capacity = capacity;
  }
}
