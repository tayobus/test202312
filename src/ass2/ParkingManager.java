package ass2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParkingManager {
    public static void main(String[] args) throws FileNotFoundException {
        int spotNum, monthlyFee, FeePerMins;
        Scanner in = new Scanner(System.in);
        System.out.println("Starting ...");
        System.out.print("Enter the number of parking sopts : ");
        spotNum = in.nextInt();
        System.out.print("Enter the monthly parking fee for residents : ");
        monthlyFee = in.nextInt();
        System.out.print("Enter the parking fee per 10 minutes : ");
        FeePerMins = in.nextInt();

        ParkingSpot[] parkingLot = new ParkingSpot[spotNum];
        Scanner scanTxt = new Scanner(new File("res.txt"));
        Resident[] residents = new Resident[scanTxt.nextInt()];
        for (Resident res : residents) {
            res.setContact(scanTxt.next());
            res.setName(scanTxt.next());
        }
        Resident[] allocatedRes = new Resident[residents.length];

        while (true) {
            char command;
            int carNum;
            String contact, name;
            int[] time = new int[5];
            int[] date = new int[3];
            System.out.print("명령을 입력하십시오. ");
            command = in.next().charAt(0);
            switch (command) {
                case 'a' -> {
                    carNum = in.nextInt();
                    contact = in.next();
                    for (int d : date) {
                        d = in.nextInt();
                    }
                }
                case 'w' -> {
                    carNum = in.nextInt();
                    contact = in.next();
                    for (int d : date) {
                        d = in.nextInt();
                    }
//                    parkingLot.withdraw(carNum, date);
                }
                case 'e' -> {
                    carNum = in.nextInt();
                    for (int t : time) {
                        t = in.nextInt();
                    }
//                    parkingLot.entry(carNum, time);
                }
                case 'x' -> {
                    carNum = in.nextInt();
                    for (int t : time) {
                        t = in.nextInt();
                    }
                }
                case 's' -> {
                }
                case 'i' -> {
                }
                default -> System.out.print("올바르지 않은 명령입니다.");
            }
        }
    }
}
