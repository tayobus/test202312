import java.time.LocalDateTime;

public class NonRVehicle extends Vehicle {
    private final LocalDateTime entryT;

    public NonRVehicle(String id, int attribute, LocalDateTime entryT, int spot) {
        super(id, attribute, spot);
        this.entryT = entryT;
    }

    public LocalDateTime getEntryT() {
        return entryT;
    }
    @Override
    public String toString() {
        return String.format("%d %s %s %s %s %s %s ",
                getSpotNo(),
                getId(),
                entryT.getYear(),
                entryT.getMonthValue(),
                entryT.getDayOfMonth(),
                entryT.getHour(),
                entryT.getMinute()) + attribute2str();
    }
}
