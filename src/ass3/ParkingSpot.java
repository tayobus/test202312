package ass3;

public class ParkingSpot {
    private String Vid;
    private boolean occupied = false;
    private boolean assigned = false;

    public void enter(String Vid) {
        this.Vid = Vid;
        occupied = true;
    }

    public void assign(String Vid) {
        this.Vid = Vid;
        assigned = true;
    }

    public void exit() {
        Vid = null;
        occupied = false;
    }

    public void withdraw() {
        Vid = null;
        assigned = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public String getVid() {
        return Vid;
    }
}
