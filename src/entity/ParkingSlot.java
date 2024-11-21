package entity;

public class ParkingSlot {
    int floorId;
    int slotId;
    Vehicle vehicle;
    boolean isFree;
    VehicleType vehicleType;

    public ParkingSlot() {super();}

    public ParkingSlot(int floorId, int slotId, Vehicle vehicle, boolean isFree, VehicleType vehicleType) {
        this.floorId = floorId;
        this.slotId = slotId;
        this.vehicle = vehicle;
        this.isFree = isFree;
        this.vehicleType = vehicleType;
    }

    public ParkingSlot(VehicleType vehicleType, boolean isFree, int slotId) {
        this.vehicleType = vehicleType;
        this.isFree = isFree;
        this.slotId = slotId;
    }
    // ---------------------------------------------------------------------------------------------------------------------

    public int getFloorId() { return floorId; }
    public void setFloorId(int floorId) { this.floorId = floorId; }

    // ---------------------------------------------------------------------------------------------------------------------

    public int getSlotId() { return slotId; }
    public void setSlotId(int slotId) { this.slotId = slotId; }

    // ---------------------------------------------------------------------------------------------------------------------

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    // ---------------------------------------------------------------------------------------------------------------------

    public boolean isFree() { return isFree; }
    public void setFree(boolean free) { isFree = free; }

    // ---------------------------------------------------------------------------------------------------------------------

    public VehicleType getVehicleType() { return vehicleType; }
    public void setVehicleType(VehicleType vehicleType) { this.vehicleType = vehicleType; }

    // ---------------------------------------------------------------------------------------------------------------------
}
