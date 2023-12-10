package ass3;

import java.time.LocalDate;

public class RVehicle extends Vehicle {
    private LocalDate assignT;
    private Resident owner;

    public RVehicle(String id, int attribute, LocalDate assignT, int spotNo, Resident owner) {
        super(id, attribute, spotNo);
        this.assignT = assignT;
        this.owner = owner;
    }

    public LocalDate getAssignT() {
        return assignT;
    }

    public Resident getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s %s %s %s %s ",
                getSpotNo(),
                getId(),
                owner.getContact(),
                owner.getName(),
                assignT.getYear(),
                assignT.getMonthValue(),
                assignT.getDayOfMonth()) + attribute2str();
    }
}
