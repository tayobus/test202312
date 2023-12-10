package ass3;

public class ParkingLot {
    private final ParkingSpot[] parkingLot;

    public ParkingLot(int numberOfSpots) {
        parkingLot = new ParkingSpot[numberOfSpots];
    }
    public ParkingSpot getSpot(int i) {
        return parkingLot[i];
    }
    public void assign(int i) {
        parkingLot[i].assign();
    }
    public void withdraw(int i) {
        parkingLot[i].withdraw();
    }
    public void enter(int i) {
        parkingLot[i].enter();
    }
    public void exit(int i) {
        parkingLot[i].exit();
    }

    public boolean isAssigned(int i) {
        return parkingLot[i].isAssigned();
    }

    public boolean isOccupied(int i) {
        return parkingLot[i].isOccupied();
    }

    public int getMaxAssignable() {
        for (int i = parkingLot.length - 1; i >= 0; i--) {
            if (!parkingLot[i].isAssigned()) return i;
        }
        return -1;
    }

    public int getMinParkable() {
        for (int i = 0; i < parkingLot.length; i++) {
            if (!parkingLot[i].isOccupied()) return i;
        }
        return -1;
    }
}
