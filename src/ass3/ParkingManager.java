package ass3;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ParkingManager {
    private final MonthlyIncome monthlyIncome = new MonthlyIncome();
    private final ParkingLot parkingLot;
    private final RMap rMap = new RMap();
    Scanner in = new Scanner(System.in);
    Calculator calc;

    HashMap<String, RVehicle> rvMap = new HashMap<>();
    HashMap<String, NonRVehicle> nonrvMap = new HashMap<>();
    HashMap<String, Vehicle> parkedVMap = new HashMap<>();

    public ParkingManager(int NofSpots, int monthlyFee, int feePer10) {
        this.parkingLot = new ParkingLot(NofSpots);
        Calculator calc = new Calculator(monthlyFee, feePer10, parkingLot);
        File res = new File("C:\\coding\\java\\ass3\\src\\res.txt");
        rMap.readTxt(res);
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

    public void assign(String id, String contact, LocalDate assignT, int attribute) {
        Resident res = rMap.get(contact);
        int spotNo = parkingLot.getMaxAssignable();
        parkingLot.assign(spotNo);
        RVehicle rVehicle = new RVehicle(id, attribute, assignT, spotNo, res);
        rvMap.put(id, rVehicle);
    }

    public void withdraw(String id, LocalDate withdrawT) {
        parkingLot.getSpot(rvMap.get(id).getSpotNo()).withdraw();
        RVehicle v = rvMap.remove(id);
        int earned = calc.calculate(v.getAssignT(), withdrawT, v.getAttribute());
        monthlyIncome.rEarn(YearMonth.from(withdrawT), earned);
    }

    public void enter(String id, LocalDateTime entryT, int attribute) {
        if (rvMap.containsKey(id)) {
            parkedVMap.put(id, rvMap.get(id));
            parkingLot.getSpot(rvMap.get(id).getSpotNo()).enter();
        } else {
            int spotNo = parkingLot.getMinParkable();
            NonRVehicle v = new NonRVehicle(id, attribute, entryT, spotNo);
            nonrvMap.put(id, v);
            parkingLot.getSpot(rvMap.get(id).getSpotNo()).enter();
        }
    }

    public void exit(String id, LocalDateTime exitT) {
        parkingLot.getSpot(rvMap.get(id).getSpotNo()).exit();
        Vehicle v = parkedVMap.remove(id);
        if (v instanceof NonRVehicle nv) {
            int earned = calc.calculate(nv.getEntryT(), exitT, nv.getAttribute());
            monthlyIncome.nrEarn(YearMonth.from(exitT), earned);
        }
    }

    public void show() {
        TreeMap<String, Vehicle> r = new TreeMap<>();
        TreeMap<String, Vehicle> nr = new TreeMap<>();
        parkedVMap.forEach((k, v) -> {
            if (v.getClass() == RVehicle.class) r.put(k, v);
            else if (v.getClass() == NonRVehicle.class) nr.put(k, v);
        });
        System.out.println("거주자 우선주차 차량");
        r.forEach((k, v) -> System.out.println(v));
        System.out.println("일반 차량");
        nr.forEach((k, v) -> System.out.println(v));
    }

    public void incomeOf(int y, int m) {
        YearMonth yearMonth = YearMonth.of(y, m);
        int r = monthlyIncome.getrIncome(yearMonth);
        int nr = monthlyIncome.getnrIncome(yearMonth);
        System.out.printf("총수입(%d년 %d월): %,d원%n", y, m, r + nr);
        System.out.printf(" - 거주자 우선주차 차량: %,d원%n", r);
        System.out.printf(" - 일반 차량: %,d원", nr);
    }
}

