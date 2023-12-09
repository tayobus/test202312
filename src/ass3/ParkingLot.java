package ass3;

public class ParkingLot {
    private final ParkingSpot[] parkingLot;

    public ParkingLot(int numberOfSpots) {
        parkingLot = new ParkingSpot[numberOfSpots];
    }

    public boolean isAssigned(int i) {
        return parkingLot[i].isAssigned();
    }

    public boolean isOccupied(int i) {
        return parkingLot[i].isOccupied();
    }

    public ParkingSpot getMaxAssignable() {
        for (int i = parkingLot.length - 1; i >= 0; i--) {
            ParkingSpot s = parkingLot[i];
            if (!s.isAssigned()) return s;
        }
        return null;
    }

    public ParkingSpot getMinParkable() {
        for (ParkingSpot s : parkingLot) if (!s.isOccupied()) return s;
        return null;
    }
}
