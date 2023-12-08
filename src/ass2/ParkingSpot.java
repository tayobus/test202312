package ass2;

public class ParkingSpot {
    private boolean isAllocated = false, isOccupied = false;

    public boolean isAllocated() {
        return isAllocated;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void allocate() {
        isAllocated = true;
    }

    public void withdraw() {
        isAllocated = false;
    }

    public void enter() {
        isOccupied = true;
    }

    public void exit() {
        isOccupied = false;
    }
}