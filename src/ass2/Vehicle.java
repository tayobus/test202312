package ass2;

import java.util.*;

public class Vehicle {
    private int vehicleNum;
    private String ownerName, ownerContact;
    private GregorianCalendar entryTime, exitTime;


    public Vehicle(int vehicleNum, String ownerContact) {
        this.vehicleNum = vehicleNum;
        this.ownerContact = ownerContact;
    }

    public void enter(int spotNum, ParkingSpot[] parkingLot, GregorianCalendar cal) {
        entryTime = cal;
        parkingLot[spotNum].enter();
    }

    public int exit(int spotNum, ParkingSpot[] parkingLot, GregorianCalendar cal) {
        parkingLot[spotNum].exit();
        exitTime = cal;
        int term = (int)(exitTime.getTimeInMillis() - entryTime.getTimeInMillis())/(60*1000);
        return term;
    }

    public int getVehicleNum() {
        return vehicleNum;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerContact() {
        return ownerContact;
    }

    public GregorianCalendar getEntryTime() {
        return entryTime;
    }

    public GregorianCalendar getExitTime() {
        return exitTime;
    }
}
