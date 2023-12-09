package ass3;

import java.time.LocalDateTime;

public class NonRVehicle extends Vehicle{
    public NonRVehicle(String id, int attribute, LocalDateTime entryT, ParkingSpot spot) {
        super(id, attribute, spot);
    }
}
