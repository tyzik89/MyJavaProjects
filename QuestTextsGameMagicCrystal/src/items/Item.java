package items;

import java.util.Objects;

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

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return name.equals(item.name) &&
                description.equals(item.description) &&
                moveable == item.moveable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, moveable);
    }
}
