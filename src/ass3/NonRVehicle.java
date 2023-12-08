package ass3;

import java.time.LocalDateTime;

public class NonRVehicle extends Vehicle{
    public NonRVehicle(String id, char type, int attribute, LocalDateTime entryT, int spotN) {
        super(id, type, attribute, spotN);
    }
}
