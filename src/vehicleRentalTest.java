class VehicleRentalTest {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency("Speedy Rentals");

        // Add vehicles to the agency
        Car car = new Car("C001", "Sedan", 40.0, true);
        Motorcycle motorcycle = new Motorcycle("M001", "Sport Bike", 20.0, true);
        Truck truck = new Truck("T001", "Freightliner", 100.0, 5000.0);

        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        // Create a customer
        Customer customer = new Customer("John Doe");

        // Test renting a car
        System.out.println("Testing Car Rental:");
        agency.processRental(customer, Car.class, 3);
        System.out.println();

        // Return the car
        System.out.println("Returning Car:");
        customer.returnVehicle();
        System.out.println("Car returned successfully.");
        System.out.println();

        // Test renting a motorcycle
        System.out.println("Testing Motorcycle Rental:");
        agency.processRental(customer, Motorcycle.class, 5);
        System.out.println();

        // Test renting a truck
        System.out.println("Testing Truck Rental:");
        customer.returnVehicle(); // Return motorcycle first
        agency.processRental(customer, Truck.class, 2);
        System.out.println();

        // Return the truck
        System.out.println("Returning Truck:");
        customer.returnVehicle();
        System.out.println("Truck returned successfully.");
    }
}

