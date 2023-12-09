package ass3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;

public class ParkingManager {
    private ParkingLot parkingLot;
    private MonthlyIncome monthlyIncome = new MonthlyIncome();

    public ParkingManager(int NofSpots, int monthlyFee, int feePer10) {
        this.parkingLot = new ParkingLot(NofSpots);
        Calculator calc = new Calculator(monthlyFee, feePer10, parkingLot);
    }

    public void enter(String id, int y, int m, int d, int h, int min, int attribute) {
        LocalDateTime t = LocalDateTime.of(y, m, d, h, min);
    }

    public void exit(String id, int y, int m, int d, int h, int min) {
        LocalDateTime t = LocalDateTime.of(y, m, d, h, min);
    }

    public void assign(String id, String contact, int y, int m, int d, int attribute) {
        LocalDate t = LocalDate.of(y, m, d);

    }

    public void withdraw(String id, int y, int m, int d) {
        LocalDate t = LocalDate.of(y, m, d);

    }

    public void show() {
    }

    public void incomeOf(int y, int m) {
        YearMonth yearMonth = YearMonth.of(y, m);
        System.out.println(monthlyIncome.get(yearMonth));
    }

}
