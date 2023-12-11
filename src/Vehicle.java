public abstract class Vehicle {
    private final String id;
    /**
     * 0 -> e, 1~3 -> v, 4~ -> g
     */
    private final int attribute;
    private final int spotNo;

    public Vehicle(String id, int attribute, int spotNo) {
        this.id = id;
        this.attribute = attribute;
        this.spotNo = spotNo;
    }

    public int getAttribute() {
        return attribute;
    }

    public int getSpotNo() {
        return spotNo;
    }

    public String getId() {
        return id;
    }

    public String attribute2str() {
        switch (attribute) {
            case 0 -> {
                return "electric";
            }
            case 1 -> {
                return "van 소형";
            }
            case 2 -> {
                return "van 중형";
            }
            case 3 -> {
                return "van 대형";
            }
            default -> {
                return "gasoline " + attribute + "cc";
            }
        }
    }
}
