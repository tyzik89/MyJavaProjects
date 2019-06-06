package items;

public abstract class Item {

    private String name;
    private String description;
    private Moveable moveable;

    public Item(String name, String description, Moveable moveable) {
        this.name = name;
        this.description = description;
        this.moveable = moveable;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Moveable getMoveable() {
        return moveable;
    }
}
