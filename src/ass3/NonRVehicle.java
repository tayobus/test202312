package ass3;

import java.time.LocalDateTime;

public class NonRVehicle extends Vehicle {
    private final LocalDateTime entryT;

    public NonRVehicle(String id, int attribute, LocalDateTime entryT, ParkingSpot spot) {
        super(id, attribute, spot);
        this.entryT = entryT;
    }

    public LocalDateTime getEntryT() {
        return entryT;
    }
}
