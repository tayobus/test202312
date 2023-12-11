import java.util.Scanner;

public class Main {

    public static void main(String[] arg){
        int NofSpots, dailyFee, feePer10;
        Scanner in = new Scanner(System.in);
        System.out.println("Starting ...");
        System.out.print("Enter the number of parking spots : ");
        NofSpots = in.nextInt();
        System.out.print("Enter the monthly parking fee for residents : ");
        dailyFee = in.nextInt()/30;
        System.out.print("Enter the parking fee per 10 minutes : ");
        feePer10 = in.nextInt();

        ParkingManager manager = new ParkingManager(NofSpots, dailyFee, feePer10);
        manager.run();
    }
}
