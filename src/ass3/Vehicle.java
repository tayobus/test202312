package ass3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Vehicle {
    private static int fee;
    private static int Rfee;
    private String id;
    /**
     * 0 -> e, 1~3 -> v, 4~ -> g
     */
    private int attribute;
    private int spotIndex;

    public Vehicle(String id, char type, int attribute, int spotIndex) {
        this.id = id;
        this.attribute = attribute;
        this.spotIndex = spotIndex;
    }

    public static void setFee(int fee, int Rfee) {
        Vehicle.fee = fee;
        Vehicle.Rfee = (int) Math.ceil((double) Rfee / 30);
    }

    public int calculate(LocalDateTime entryT, LocalDateTime out) {
        long minutesDifference = ChronoUnit.MINUTES.between(entryT, out);
        int i = (int) Math.ceil((double) minutesDifference / 10);
        i = i == 1 ? 0 : fee * i;
        i = func(i);
        if (ParkingLot.isAssigned(i)) i /= 2;
        return i;
    }

    public int calculate(LocalDate assignT, LocalDate out) {
        long daysDifference = ChronoUnit.DAYS.between(assignT, out);
        int i = (int) daysDifference * Rfee;
        return func(i);
    }

    private int func(int calculated) {
        if (attribute == 0) return calculated / 2;
        if (1 <= attribute && attribute < 4) {
            switch (attribute) {
                case 1 -> {
                    return calculated;
                }
                case 2 -> {
                    return (int) (calculated * 1.5);
                }
                case 3 -> {
                    return calculated * 2;
                }
            }
        }
        if (4 <= attribute && attribute < 1000) {
            return calculated / 2;
        }
        return calculated;
    }

}
