package menus;

import inventories.Inventory;
import items.Item;
import items.Moveable;
import locations.Location;
import players.Player;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void lookAround(Location location) {
        System.out.println(
                "Вы находитесь в локации "
                + location.getLocationName()
                + ". Это "
                + location.getDescription());
        System.out.println("Тут лежат: " + location.showInventory());
    }

    public static void goToLocation() {

    }

    public static void takeItem(Player player) {
        System.out.print("Введите имя предмета: ");
        String name = scanner.nextLine();
        Location location = player.getCurrentLocation();
        Inventory locInv = location.getLocationInventory();
        Inventory playerInv = player.getInventory();
        if (locInv.isItemExist(name)) {
            if (locInv.demonstrateItem(name).getMoveable() == Moveable.NO) {
                System.out.println("Ну и как я должен это взять с собой??? Нет уж...");
                return;
            }
            playerInv.addItem(locInv.takeItem(name));
            System.out.println("Вы взяли " + name);
        } else {
            System.out.println("Я тоже пьян? Такого предмета нет...");
        }
    }

    public static void researchItem(Player player) {
        System.out.print("Введите имя предмета: ");
        String name = scanner.nextLine();
        Inventory playerInv = player.getInventory();
        if (playerInv.isItemExist(name)) {
            Item item = playerInv.demonstrateItem(name);
            System.out.println("Вы внимательно разглядываете и щупаете этот предмет...");
            System.out.println(item.getName() + " как " + item.getName() + ", " + item.getDescription());
        } else {
            System.out.println("Причудилось штоле, такого предмета у меня нет...");
        }
    }

    public static void showInventory(Player player) {
        int count = player.getInventory().countItems();
        if (count == 0) {
            System.out.println("Вы гол как сокол...");
            return;
        }
        System.out.print("Количество ваших предметов: " + count + " , среди них: ");
        System.out.println(player.showInventory());
    }

    public static void modifyItem() {

    }

    public static void exitgame() {
        System.exit(0);
    }

}
