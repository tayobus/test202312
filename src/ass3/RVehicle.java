package ass3;

import java.time.LocalDate;

public class RVehicle extends Vehicle {
    private LocalDate assignT;
    private Resident owner;

    public RVehicle(String id, char type, int attribute, LocalDate assignT, int spotN, Resident owner) {
        super(id, type, attribute, spotN);
        this.assignT = assignT;
        this.owner = owner;
    }
}
