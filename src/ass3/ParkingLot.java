package ass3;

import java.util.ArrayList;

public class ParkingLot {
    private ArrayList<ParkingSpot> parkingLot;

    public ParkingLot(int numberOfSpots) {
        parkingLot = new ArrayList<>(numberOfSpots);
    }

    public boolean isAssigned(int i) {
        return parkingLot.get(i).isAssigned();
    }

    public boolean isOccupied(int i) {
        return parkingLot.get(i).isOccupied();
    }

    public ParkingSpot getMinParkableSpot(){
        for(ParkingSpot s : parkingLot) if (!s.isOccupied()) return s;
        return null;
    }
}
