class Car extends Vehicle {
    private boolean hasGPS;

    public Car(String vehicleId, String model, double baseRentalRate, boolean hasGPS) {
        super(vehicleId, model, baseRentalRate);
        this.hasGPS = hasGPS;
    }

    public boolean hasGPS() { return hasGPS; }

    @Override
    public double calculateRentalCost(int days) {
        double cost = days * getBaseRentalRate();
        if (hasGPS) cost += 50; // Extra cost for GPS
        return cost;
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}

