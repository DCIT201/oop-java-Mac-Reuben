import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class RentalAgency {
    private String agencyName; // Field to store the name of the agency
    private List<Vehicle> fleet;

    // Constructor to initialize the agency with a name
    public RentalAgency(String agencyName) {
        if (agencyName == null || agencyName.isEmpty()) 
            throw new IllegalArgumentException("Invalid agency name");
        this.agencyName = agencyName;
        this.fleet = new ArrayList<>();
    }

    // Getter for agencyName
    public String getAgencyName() {
        return agencyName;
    }

    // Method to add a vehicle to the fleet
    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("Invalid vehicle");
        fleet.add(vehicle);
    }

    // Method to find an available vehicle of a specified type
    public Vehicle findAvailableVehicle(Class<?> type) {
        for (Vehicle vehicle : fleet) {
            if (type.isInstance(vehicle) && vehicle.isAvailableForRental()) {
                return vehicle;
            }
        }
        throw new NoSuchElementException("No available vehicle of type " + type.getSimpleName());
    }

    // Process rental for a customer
    public void processRental(Customer customer, Class<?> vehicleType, int days) {
        Vehicle vehicle = findAvailableVehicle(vehicleType);
        customer.rentVehicle(vehicle);
        System.out.println("Rental processed for " + customer.getName() + ": " + vehicle);
        System.out.println("Total cost: " + vehicle.calculateRentalCost(days));
    }
}


