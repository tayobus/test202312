package ass2;

public class Resident {
    private String contanct, name;
    public Resident(String contact, String name){
        this.contanct = contact;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contanct;
    }

    public void setContact(String contact){
        this.contanct = contanct;
    }
}
