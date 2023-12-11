public class ParkingSpot {
    private boolean occupied = false;
    private boolean assigned = false;

    public void enter() {
        occupied = true;
    }

    public void assign() {
        assigned = true;
    }

    public void exit() {
        occupied = false;
    }

    public void withdraw() {
        assigned = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isAssigned() {
        return assigned;
    }
}
