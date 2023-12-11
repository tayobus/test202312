public class Resident {
    private final String name, contact;

    public Resident(String contact, String name) {
        this.contact = contact;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}
