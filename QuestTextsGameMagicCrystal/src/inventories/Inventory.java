package inventories;

import items.Item;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        this.items = new ArrayList<Item>();
    }

    public int countItems() {
        return items.size();
    }

    public boolean addItem (Item item) {
        return item != null && items.add(item);
    }

    public Item takeItem (String name) {
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = (Item)iterator.next();
            if (item.getName().equals(name)) {
                iterator.remove();
                return item;
            }
        }
        return null;
    }

    public Item demonstrateItem(String name) {
        for (Item item : items) {
            if (item.getName().equals(name))
                return item;
        }
        return null;
    }

    public boolean isItemExist(String name) {
        for (Item item : items) {
            if (item.getName().equals(name))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
