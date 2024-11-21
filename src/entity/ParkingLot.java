package entity;

import java.util.List;

public class ParkingLot {
    String parkingLotId;
    int noOfFloor;
    int noOfSlotsPerFloor;
    List<ParkingFloor> parkingFloorList;

    public ParkingLot(String parkingLotId, int noOfFloor, int noOfSlotsPerFloor) {
        this.parkingLotId = parkingLotId;
        this.noOfFloor = noOfFloor;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }

    public ParkingLot(String parkingLotId, int noOfFloor, int noOfSlotsPerFloor, List<ParkingFloor> parkingFloorList) {
        this.parkingLotId = parkingLotId;
        this.noOfFloor = noOfFloor;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        this.parkingFloorList = parkingFloorList;
    }

    // ---------------------------------------------------------------------------------------------------------------------

    public String getParkingLotId() { return parkingLotId; }
    public void setParkingLotId(String parkingLotId) { this.parkingLotId = parkingLotId; }

    // ---------------------------------------------------------------------------------------------------------------------

    public int getNoOfFloor() { return noOfFloor; }
    public void setNoOfFloor(int noOfFloor) { this.noOfFloor = noOfFloor; }

    // ---------------------------------------------------------------------------------------------------------------------

    public int getNoOfSlotsPerFloor() { return noOfSlotsPerFloor; }
    public void setNoOfSlotsPerFloor(int noOfSlotsPerFloor) { this.noOfSlotsPerFloor = noOfSlotsPerFloor; }

    // ---------------------------------------------------------------------------------------------------------------------

    public List<ParkingFloor> getParkingFloorList() { return parkingFloorList; }
    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) { this.parkingFloorList = parkingFloorList; }

    // ---------------------------------------------------------------------------------------------------------------------
}
