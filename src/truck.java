class Truck extends Vehicle {
    private double maxLoad;

    public Truck(String vehicleId, String model, double baseRentalRate, double maxLoad) {
        super(vehicleId, model, baseRentalRate);
        if (maxLoad <= 0) throw new IllegalArgumentException("Invalid max load");
        this.maxLoad = maxLoad;
    }

    public double getMaxLoad() { return maxLoad; }

    @Override
    public double calculateRentalCost(int days) {
        return days * getBaseRentalRate() + (maxLoad * 0.1);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }
}

