public class ParkingLot {
    private final ParkingSpot[] parkingLot;

    public ParkingLot(int numberOfSpots) {
        parkingLot = new ParkingSpot[numberOfSpots];
        for (int i = 0; i < numberOfSpots; i++) parkingLot[i] = new ParkingSpot();
    }

    public ParkingSpot getSpot(int i) {
        if (isValidIndex(i)) {
            return parkingLot[i];
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    public void assign(int i) {
        if (isValidIndex(i)) {
            parkingLot[i].assign();
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    public void withdraw(int i) {
        if (isValidIndex(i)) {
            parkingLot[i].withdraw();
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    public void enter(int i) {
        if (isValidIndex(i)) {
            parkingLot[i].enter();
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    public void exit(int i) {
        if (isValidIndex(i)) {
            parkingLot[i].exit();
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    public boolean isAssigned(int i) {
        if (isValidIndex(i)) {
            return parkingLot[i].isAssigned();
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    public boolean isOccupied(int i) {
        if (isValidIndex(i)) {
            return parkingLot[i].isOccupied();
        } else {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    private boolean isValidIndex(int i) {
        return i >= 0 && i < parkingLot.length;
    }

    public int getMaxAssignable() {
        for (int i = parkingLot.length - 1; i >= 0; i--) {
            if (!parkingLot[i].isAssigned()) return i;
        }
        throw new IllegalStateException("No assignable parking spot available.");
    }

    public int getMinParkable() {
        for (int i = 0; i < parkingLot.length; i++) {
            if (!parkingLot[i].isOccupied()) return i;
        }
        throw new IllegalStateException("No parkable parking spot available.");
    }
}
