package ass2;

import java.util.GregorianCalendar;

public class AllocatedRes extends Resident {
    private int vehicleNum;
    private GregorianCalendar date;

    public AllocatedRes(String contactNum, String name, int vehicleNum, GregorianCalendar date) {
        super(contactNum, name);
        this.vehicleNum = vehicleNum;
        this.date = date;
    }

    public int getVehicleNum() {
        return vehicleNum;
    }

    public void setVehicleNum(int vehicleNum) {
        this.vehicleNum = vehicleNum;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
}
