package parameter;

public class Location {
    private int x;
    private Integer y; //Поле не может быть null
    private Float z; //Поле не может быть null
    private String name; //Поле может быть null

    public Location(int x, Integer y, Float z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Float getZ() {
        return z;
    }

    public String getName() {
        return name;
    }
}
