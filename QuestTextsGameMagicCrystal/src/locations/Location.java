package locations;

import inventories.Inventory;
import items.Item;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Location {

    private Locations location;
    private String description;
    private Inventory locationInventory;
    private Map<Direction, Location> directions;

    public Location(Locations location, String description, Map<Direction, Location> directions) {
        this.location = location;
        this.description = description;
        this.locationInventory = new Inventory();
        this.directions = directions;
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

    public void fillInventory(Item item){
        locationInventory.addItem(item);
    }

    public Map<Direction, Location> getDirections() {
        return directions;
    }

    public void addDirection(Direction direction, Location location) {
        directions.put(direction, location);
    }

    public String showDirections() {
        StringBuilder d = new StringBuilder("");
        for (Direction direction : directions.keySet()) {
            d.append(direction.getName()).append(" ");
        }
        return d.toString();
    }
}
