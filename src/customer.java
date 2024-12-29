import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Vehicle> rentalHistory;
    private Vehicle currentRental;

    public Customer(String name) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Invalid name");
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getName() { return name; }
    public Vehicle getCurrentRental() { return currentRental; }

    public void rentVehicle(Vehicle vehicle) {
        if (currentRental != null) throw new IllegalStateException("Customer already has a rental");
        currentRental = vehicle;
        vehicle.setAvailable(false);
    }

    public void returnVehicle() {
        if (currentRental == null) throw new IllegalStateException("No current rental to return");
        currentRental.setAvailable(true);
        rentalHistory.add(currentRental);
        currentRental = null;
    }
}

