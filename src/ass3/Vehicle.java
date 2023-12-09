package ass3;

public abstract class Vehicle {
    private final String id;
    /**
     * 0 -> e, 1~3 -> v, 4~ -> g
     */
    private final int attribute;
    private final int spotIndex;

    public Vehicle(String id, int attribute, int spotIndex) {
        this.id = id;
        this.attribute = attribute;
        this.spotIndex = spotIndex;
    }
}
