package entity;

public class Vehicle {
    VehicleType vehicleType;
    ParkingSlot parkingSlot;
    String ticketId;
    String color;
    String vehicleRegistrationNumber;

    public Vehicle(VehicleType vehicleType, ParkingSlot parkingSlot,String color, String vehicleRegistrationNumber) {
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.color = color;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }

    public Vehicle(VehicleType vehicleType, ParkingSlot parkingSlot, String ticketId, String color, String vehicleRegistrationNumber) {
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.ticketId = ticketId;
        this.color = color;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }
    // ---------------------------------------------------------------------------------------------------------------------

    public VehicleType getVehicleType() { return vehicleType; }
    public void setVehicleType(VehicleType vehicleType) { this.vehicleType = vehicleType; }

    // ---------------------------------------------------------------------------------------------------------------------

    public ParkingSlot getParkingSlot() { return parkingSlot; }
    public void setParkingSlot(ParkingSlot parkingSlot) { this.parkingSlot = parkingSlot; }

    // ---------------------------------------------------------------------------------------------------------------------

    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }

    // ---------------------------------------------------------------------------------------------------------------------

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    // ---------------------------------------------------------------------------------------------------------------------

    public String getVehicleRegistrationNumber() { return vehicleRegistrationNumber; }
    public void setVehicleRegistrationNumber(String vehicleRegistrationNumber) { this.vehicleRegistrationNumber = vehicleRegistrationNumber; }

    // ---------------------------------------------------------------------------------------------------------------------
}
