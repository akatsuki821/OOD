package ParkingLot;

public class ParkingSpot {
    //boolean fit(Vehicle): check size and availability
    private final VehicleSize size;
    private Vehicle currentVehicle;

    ParkingSpot(VehicleSize size) {
        this.size = size;
    }

    boolean fit(Vehicle v) {
        if (currentVehicle == null) {
            if (this.size.getSize() >= v.getSize().getSize()) {
                return true;
            }
        }
        return false;
    }

    void park(Vehicle v) {
        currentVehicle = v;
    }

    void leave() {
        currentVehicle = null;
    }

    Vehicle getVehicle() {
        return currentVehicle;
    }
}
