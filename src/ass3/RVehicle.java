package ass3;

import java.time.LocalDate;

public class RVehicle extends Vehicle {
    private LocalDate assignT;
    private Resident owner;

    public RVehicle(String id, int attribute, LocalDate assignT, ParkingSpot spot, Resident owner) {
        super(id, attribute, spot);
        this.assignT = assignT;
        this.owner = owner;
    }
}
