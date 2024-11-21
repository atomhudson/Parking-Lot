package repository;

import entity.ParkingFloor;
import entity.ParkingSlot;
import entity.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingDataRepository {
    List<ParkingSlot> parkingSlotsData;
    List<ParkingFloor> parkingFloors;

    public List<ParkingFloor> initializeDataOfFloor(int noOfParkingFloors,int noOfParkingSlots) {
        parkingFloors = new ArrayList<>(noOfParkingFloors);
        for (int i = 0; i < noOfParkingFloors; i++) {
            initializeSlotsData(noOfParkingSlots);
            List<ParkingSlot> parkingSlots = getAllParkingSlotData(i);
            parkingFloors.add(new ParkingFloor(parkingSlots));
        }
        return parkingFloors;
    }

    public void initializeSlotsData(int noOfSlots) {
        parkingSlotsData = new ArrayList<>(noOfSlots);

        if(noOfSlots >= 1)
            parkingSlotsData.add(getTruckData());

        if(noOfSlots >= 3)
            for (int i = 1; i < 3; i++)
                parkingSlotsData.add(getBikeData(i));

        if (noOfSlots > 3)
            for (int i = 3; i < noOfSlots; i++)
                parkingSlotsData.add(getCarData(i));

    }

    public List<ParkingSlot> getAllParkingSlotData(int floorId){
        parkingSlotsData.forEach(parkingSlot -> parkingSlot.setFloorId(floorId));
        return parkingSlotsData;
    }

    private ParkingSlot getTruckData(){ return new ParkingSlot(VehicleType.TRUCK, true,0); }
    private ParkingSlot getBikeData(int slotId){ return new ParkingSlot(VehicleType.BIKE, true, slotId); }
    private ParkingSlot getCarData(int slotId){ return new ParkingSlot(VehicleType.CAR, true, slotId); }

}
