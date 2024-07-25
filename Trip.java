import java.sql.Date;


public class Trip {
  private int tripID;
  private String origin;
  private String destination;
  private int passengers;
  private Date departureTime;
  private Date arrivalTime;


  public Trip(int capacity, String origin2, String destination2, int capacity2, String departureTime2,
        String arrivalTime2) {
    //TODO Auto-generated constructor stub
}
public Trip(int tripID, String origin, String destination, int passengers, Date departureTime, Date arrivalTime) {
  this.tripID = tripID;
  this.origin = origin;
  this.destination = destination;
  this.passengers = passengers;
  this.departureTime = departureTime;
  this.arrivalTime = arrivalTime;
}

public int getTripID() {
    return tripID;
  }

  public String getOrigin() {
    return origin;
  }

  public String getDestination() {
    return destination;
  }

  public int getPassengers() {
    return passengers;
  }

  public Date getDepartureTime() {
    return departureTime;
  }

  public Date getArrivalTime() {
    return arrivalTime;
  }
}