package locations;

import inventories.Inventory;
import items.Item;

public class Location {

    private Locations location;
    private String description;
    private Inventory locationInventory;

    public Location(Locations location, String description) {
        this.location = location;
        this.description = description;
        this.locationInventory = new Inventory();
    }

    public String getLocationName() {
        return location.getName();
    }

    public String getDescription() {
        return description;
    }

    public String showInventory() {
        return locationInventory.toString();
    }

    public Locations getLocation() {
        return location;
    }

    public Inventory getLocationInventory() {
        return locationInventory;
    }
}
