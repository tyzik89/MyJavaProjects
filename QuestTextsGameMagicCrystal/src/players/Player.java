package players;

import inventories.Inventory;
import locations.Location;

public class Player {
    private Inventory inventory;
    private Location currentLocation;

    public Player(Location location) {
        this.inventory = new Inventory();
        this.currentLocation = location;
    }

    public String showInventory() {
        return inventory.toString();
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
