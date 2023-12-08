package ass3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class RMap {
    private static HashMap<String, Resident> residents;

    public boolean isResident(String contact) {
        return residents.containsKey(contact);
    }
    public Resident get(String contact) {
        return residents.get(contact);
    }
    public void readTxt(File f) {
        try (Scanner scanTxt = new Scanner(f)) {
            int rNum = scanTxt.nextInt();
            residents = new HashMap<>(rNum);
            for (int i = 0; i < rNum; i++) {
                String contact = scanTxt.next();
                String name = scanTxt.next();
                Resident r = new Resident(contact, name);
                residents.put(contact, r);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
