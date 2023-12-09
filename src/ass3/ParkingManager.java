package ass3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Scanner;

public class ParkingManager {
    private final MonthlyIncome monthlyIncome = new MonthlyIncome();
    Scanner in = new Scanner(System.in);
    private ParkingLot parkingLot;
    public ParkingManager(int NofSpots, int monthlyFee, int feePer10) {
        this.parkingLot = new ParkingLot(NofSpots);
        Calculator calc = new Calculator(monthlyFee, feePer10, parkingLot);
    }

    public void run() {
        while (true) {
            char command;
            int attribute;
            String contact, id;
            LocalDate ld;
            LocalDateTime ldt;
            System.out.print("명령을 입력하십시오. ");
            command = in.next().charAt(0);
            switch (command) {
                case 'a' -> {
                    contact = in.next();
                    id = in.next();
                    ld = ldRead();
                    attribute = classify(in.next().charAt(0));
                    assign(id, contact, ld, attribute);
                }
                case 'w' -> {
                    id = in.next();
                    ld = ldRead();
                    withdraw(id, ld);
                }
                case 'e' -> {
                    id = in.next();
                    ldt = ldtRead();
                    attribute = classify(in.next().charAt(0));
                    enter(id, ldt, attribute);
                }
                case 'x' -> {
                    id = in.next();
                    ldt = ldtRead();
                    exit(id, ldt);
                }
                case 's' -> show();
                case 'i' -> {
                    int y = in.nextInt();
                    int m = in.nextInt();
                    incomeOf(y, m);
                }
                default -> System.out.print("올바르지 않은 명령입니다.");
            }
        }
    }
    public LocalDate ldRead() {
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        return LocalDate.of(year, month, day);
    }

    public LocalDateTime ldtRead() {
        int year = in.nextInt();
        int month = in.nextInt();
        int day = in.nextInt();
        int hour = in.nextInt();
        int minute = in.nextInt();
        return LocalDateTime.of(year, month, day, hour, minute);
    }

    public int classify(char type) {
        switch (type) {
            case 'g', 'v' -> {
                return in.nextInt();
            }
            default -> {
                return 0;
            }
        }
    }

    public void enter(String id, LocalDateTime entryT, int attribute) {

    }

    public void exit(String id, LocalDateTime exitT) {

    }

    public void assign(String id, String contact, LocalDate assignT, int attribute) {
    }

    public void withdraw(String id, LocalDate withdrawT) {

    }

    public void show() {
    }

    public void incomeOf(int y, int m) {
        YearMonth yearMonth = YearMonth.of(y, m);
        System.out.println(monthlyIncome.get(yearMonth));
    }

}
