package ass3;

public class Resident {
    private String name, contact;

    public Resident(String contact, String name) {
        this.contact = contact;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String conact) {
        this.contact = contact;
    }
}
