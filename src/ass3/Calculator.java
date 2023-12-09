package ass3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Calculator {
    private final int fee;
    private final int Rfee;
    private ParkingLot parkingLot;

    public Calculator(int Rfee, int fee, ParkingLot parkingLot) {
        this.Rfee = (int) Math.ceil((double) Rfee / 30);
        this.fee = fee;
        this.parkingLot = parkingLot;
    }

    public int calculate(LocalDateTime entryT, LocalDateTime out, int attribute) {
        long minutesDifference = ChronoUnit.MINUTES.between(entryT, out);
        int i = (int) Math.ceil((double) minutesDifference / 10);
        i = i == 1 ? 0 : fee * i;
        i = calcByT(i, attribute);
        if (parkingLot.isAssigned(i)) i /= 2;
        return i;
    }

    public int calculate(LocalDate assignT, LocalDate out, int attribute) {
        long daysDifference = ChronoUnit.DAYS.between(assignT, out);
        int i = (int) daysDifference * Rfee;
        return calcByT(i, attribute);
    }

    private int calcByT(int calculated, int attribute) {
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
