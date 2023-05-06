  public enum VehicleStatus {
    AVAILABLE, RESERVED, LOANED, LOST, BEING_SERVICED, OTHER
  }
  
  public enum ReservationStatus {
    ACTIVE, PENDING, CONFIRMED, COMPLETED, CANCELLED, NONE
  }
  
  public enum AccountStatus {
    ACTIVE, CLOSED, CANCELED, BLACKLISTED, BLOCKED
  }
  
  public enum PaymentStatus {
    UNPAID, PENDING, COMPLETED, FILLED, DECLINED, CANCELLED, ABANDONED, SETTLING, SETTLED, REFUNDED
  }
  
  public class Address {
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String country;
  }
  
  public class Person {
    private String name;
    private Address address;
    private String email;
    private String phone;
  }

  // For simplicity, we are not defining getter and setter functions. The reader can
// assume that all class attributes are private and accessed through their respective
// public getter method and modified only through their public setter method.

public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;
    private Person person;
  
    public boolean resetPassword();
  }
  
  public class Member extends Account {
    private int totalVehiclesReserved;
  
    public List<VehicleReservation> getReservations();
  }
  

  // Car Rental System 

  public class CarRentalLocation {
    private String name;
    private Address location;
  
    public Address getLocation();
  }
  
  public class CarRentalSystem {
    private String name;
    private List<CarRentalLocation> locations;
  
    public boolean addNewLocation(CarRentalLocation location);
  }
//Search interface 

  public interface Search {
    public List<Vehicle> searchByType(String type);
    public List<Vehicle> searchByModel(String model);
  }
  
  public class VehicleInventory implements Search {
    private HashMap<String, List<Vehicle>> vehicleTypes;
    private HashMap<String, List<Vehicle>> vehicleModels;
  
    public List<Vehicle> searchByType(String query) {
      // return all vehicles of the given type.
      return vehicleTypes.get(query);
    }
  
    public List<Vehicle> searchByModel(String query) {
      // return all vehicles of the given model.
      return vehicleModels.get(query);
    }
  }

  // Vehicle Log 

  public abstract class Vehicle {
    private String licenseNumber;
    private String stockNumber;
    private int passengerCapacity;
    private String barcode;
    private boolean hasSunroof;
    private VehicleStatus status;
    private String model;
    private String make;
    private int manufacturingYear;
    private int mileage;
  
    private List<VehicleLog> log;
  
    public boolean reserveVehicle();
  
    public boolean returnVehicle();
  }
  
  public class Car extends Vehicle {
    private CarType type;
  }
  
  
  // We can have similar definition for other vehicle types
  
  
  public class VehicleLog {
    private String id;
    private VehicleLogType type;
    private String description;
    private Date creationDate;
  
    public bool update();
  
    public List<VehicleLogType> searchByLogType(VehicleLogType type);
  }
  
  public class VehicleReservation {
    private String reservationNumber;
    private Date creationDate;
    private ReservationStatus status;
    private Date dueDate;
    private Date returnDate;
    private String pickupLocationName;
    private String returnLocationName;
  
    private int customerID;
    private Vehicle vehicle;
    private Bill bill;
    private List<AdditionalDriver> additionalDrivers;
    private List<Notification> notifications;
    private List<RentalInsurance> insurances;
    private List<Equipment> equipments;
    private List<Service> services;
  
    public static VehicleReservation fetchReservationDetails(String reservationNumber);
  
    public List<Passenger> getAdditionalDrivers();
  }