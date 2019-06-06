package inventories;

import items.Item;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        this.items = new ArrayList<Item>();
    }

    public boolean addItem (Item item) {
        return item != null && items.add(item);
    }

    public Item getItem (String name) {

        int index = items.indexOf(item);
        return index == -1 ? null : items.get(index);
    }

    @Override
    public String toString() {
        return "Хранимые предметы: " + items;
    }
}
