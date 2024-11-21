package service;

import entity.*;
import repository.ParkingDataRepository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotService {
    HashMap<String, Vehicle> vehicleHashMap;
    ParkingLot parkingLot;
    ParkingDataRepository parkingDataRepository;

    public void createParkingLot(ParkingLot parkingLot){
        vehicleHashMap = new HashMap<>();
        this.parkingLot = parkingLot;
        parkingDataRepository = new ParkingDataRepository();
        this.parkingLot.setParkingFloorList(
                parkingDataRepository.initializeDataOfFloor(parkingLot.getNoOfFloor(), parkingLot.getNoOfSlotsPerFloor())
        );
    }

    public void parkVehicle(VehicleType vehicleType, String vehicleNumber, String color){
        ParkingSlot parkingSlot = getFirstAvailableSlot(vehicleType);
        if (parkingSlot == null){
            System.out.println("No available parking lot");
        }else{
            parkingSlot.setFree(false);
            Vehicle vehicle = new Vehicle(vehicleType, parkingSlot, color , vehicleNumber);
            String ticket = generateTicket(parkingSlot);
            vehicle.setTicketId(ticket);
            vehicleHashMap.put(ticket,vehicle);
            System.out.println("Vehicle parked successfully with Ticket Id: "+ ticket);
        }
    }

    public void unParkedVechile(String ticketId){
        if (vehicleHashMap.get(ticketId) != null){
            Vehicle vehicle = vehicleHashMap.get(ticketId);
            ParkingSlot parkingSlot = vehicle.getParkingSlot();
            parkingSlot.setFree(true);
            parkingLot.getParkingFloorList().get(parkingSlot.getFloorId()).getParkingSlots().get(parkingSlot.getSlotId()).setFree(true);
            vehicleHashMap.remove(ticketId);
            System.out.println("Unparked vehicle of Vehicle Type: "+ vehicle.getVehicleType()+ " with Registration Number: "+ vehicle.getVehicleRegistrationNumber()+" and Color: "+vehicle.getColor());
        }else{
            System.out.println("Invalid Ticket");
        }
    }
    public void display(DisplayType displayType, VehicleType vehicleType){
        if (displayType == DisplayType.FREE_COUNT){
            displayFreeCount(vehicleType);
        } else if (displayType == DisplayType.FREE_SLOTS) {
            displayFreeSlots(vehicleType);
        } else if (displayType == DisplayType.OCCUPIED_SLOTS) {
            displayOccupiedSlots(vehicleType);
        }else{
            System.out.println("Invalid Display Type");
        }
    }

    private ParkingSlot getFirstAvailableSlot(VehicleType vehicleType){
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloorList();
        for (ParkingFloor parkingFloor : parkingFloors){
            List<ParkingSlot> parkingSlots = getAvailableVechicleTypeParkingSlot(parkingFloor.getParkingSlots(),vehicleType);
            for (ParkingSlot parkingSlot : parkingSlots){
                if (parkingSlot.getVehicleType().equals(vehicleType) && parkingSlot.isFree()){
                    return parkingSlot;
                }
            }
        }
        return null;
    }
    private List<ParkingSlot> getAvailableVechicleTypeParkingSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.TRUCK) && parkingSlots.size() >= 1) {
            return Arrays.asList(parkingSlots.get(0));
        } else if (vehicleType.equals(VehicleType.BIKE) && parkingSlots.size() >= 3) {
            return Arrays.asList(parkingSlots.get(1), parkingSlots.get(2));
        } else {
            return parkingSlots;
        }
    }

    private String generateTicket(ParkingSlot parkingSlot){
        String getParkingLotId = parkingLot.getParkingLotId();
        String getFloorId = Integer.toString(parkingSlot.getFloorId()+1);
        String getSlotId = Integer.toString(parkingSlot.getSlotId()+1);
        return getParkingLotId+"_"+getFloorId+"_"+getSlotId;
    }

    private void displayFreeCount(VehicleType vehicleType){
        for (int i = 0; i < parkingLot.getParkingFloorList().size(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloorList().get(i);
            long count = parkingFloor.getParkingSlots()
                    .stream()
                    .filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType))
                    .filter(ParkingSlot::isFree)
                    .count();
            System.out.println("Number of Free Slots for: " + vehicleType +" on Floor "+(i+1)+" : "+count);
        }
    }
    private void displayFreeSlots(VehicleType vehicleType){
        for (int i = 0; i < parkingLot.getParkingFloorList().size(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloorList().get(i);
            List<ParkingSlot> collect = parkingFloor.getParkingSlots()
                    .stream()
                    .filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType))
                    .filter(ParkingSlot::isFree).collect(Collectors.toList());
            StringBuilder printStatement = new StringBuilder("Free slots for "+ vehicleType+" on Floor "+(i+1)+" :");
            for (ParkingSlot parkingSlot : collect) {
                printStatement.append(parkingSlot.getSlotId()+1);
                printStatement.append(",");
            }
            System.out.println(printStatement);
        }
    }

    private void displayOccupiedSlots(VehicleType vehicleType){
        for (int i = 0; i < parkingLot.getParkingFloorList().size(); i++) {
            ParkingFloor parkingFloor = parkingLot.getParkingFloorList().get(i);
            List<ParkingSlot> collect = parkingFloor.getParkingSlots()
                    .stream()
                    .filter(parkingSlot -> parkingSlot.getVehicleType().equals(vehicleType))
                    .filter(parkingSlot -> !parkingSlot.isFree()).collect(Collectors.toList());
            StringBuilder printStatement = new StringBuilder("Occupied slots for "+vehicleType+" on Floor "+(i+1)+" :");
            for (ParkingSlot parkingSlot : collect){
                printStatement.append(parkingSlot.getSlotId()+1);
                printStatement.append(",");
            }
            System.out.println(printStatement);
        }
    }
}
