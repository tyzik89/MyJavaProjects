package players;

import application.Main;
import inventories.Inventory;
import items.Combo;
import items.Item;
import items.Moveable;
import locations.Direction;
import locations.Location;

import java.util.Map;
import java.util.concurrent.TimeUnit;

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

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void lookAround() {
        System.out.println(
                "Вы находитесь в локации "
                        + currentLocation.getLocationName()
                        + ". Это "
                        + currentLocation.getDescription());
        System.out.println("Тут лежат: " + currentLocation.showInventory());
        System.out.println("Отсюда можно пойти на: " + currentLocation.showDirections());
    }

    public void goToLocation() {
        System.out.print("Куда направляетесь?  ");
        String name = Main.SCANNER.nextLine();
        Location location = this.getCurrentLocation();
        Map<Direction, Location> directions= location.getDirections();
        for (Map.Entry<Direction, Location> directionLocationEntry : directions.entrySet()) {
            if (directionLocationEntry.getKey().getName().equals(name)) {
                this.setCurrentLocation(directionLocationEntry.getValue());
                System.out.println("Вы перешли в " + directionLocationEntry.getValue().getLocationName());
                return;
            }
        }
        System.out.println("Туда вы пойти не можете...");
    }

    public void takeItem() {
        System.out.print("Введите имя предмета: ");
        String name = Main.SCANNER.nextLine();
        Location location = this.getCurrentLocation();
        Inventory locInv = location.getLocationInventory();
        Inventory playerInv = this.getInventory();
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

    public void researchItem() {
        System.out.print("Введите имя предмета: ");
        String name = Main.SCANNER.nextLine();
        Inventory playerInv = this.getInventory();
        if (playerInv.isItemExist(name)) {
            Item item = playerInv.demonstrateItem(name);
            System.out.println("Вы внимательно разглядываете и щупаете этот предмет...");
            System.out.println(item.getName() + " как " + item.getName() + ", " + item.getDescription());
        } else {
            System.out.println("Причудилось штоле, такого предмета у меня нет...");
        }
    }

    public void showMyInventory() {
        int count = this.getInventory().countItems();
        if (count == 0) {
            System.out.println("Вы гол как сокол...");
            return;
        }
        System.out.print("Количество ваших предметов: " + count + " , среди них: ");
        System.out.println(this.showInventory());
    }

    public void modifyItem() {
        System.out.println("Вы хлопаете себя по карманам...");
        Inventory playerInv = this.getInventory();
        if (playerInv.countItems() <= 0) {
            System.out.println("Мде уж...нашёл только дырку от бублика");
        } else {
            System.out.println("В карманах лежит " + playerInv.toString());
            System.out.print("Попробуем собрать что-то полезное из ");
            String obj_1 = Main.SCANNER.next();
            if (!playerInv.isItemExist(obj_1)) {
                System.out.println("Здрасьте, " + obj_1 + " нет в инвентаре...");
                return;
            }
            System.out.print(obj_1);
            System.out.print(" и ");
            String obj_2 = Main.SCANNER.next();
            if (!playerInv.isItemExist(obj_2)) {
                System.out.println("Здрасьте, " + obj_2 + " нет в инвентаре...");
                return;
            }

            Item item_1 = playerInv.demonstrateItem(obj_1);
            Item item_2 = playerInv.demonstrateItem(obj_2);
            if (!Main.RULES_CATALOG.checkCombo(item_1, item_2)) {
                System.out.println("Не, получится что-то странное. Не будем так соединять.");
                return;
            }

            item_1 = playerInv.takeItem(obj_1);
            item_2 = playerInv.takeItem(obj_2);
            Combo combo = Main.RULES_CATALOG.getCombo(item_1, item_2);
            System.out.print("\nПроцесс соединения...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("завершён.");
            playerInv.addItem(combo.getResult());
            System.out.println(combo.getMessage());
        }
    }

    public void applyItem() {
        System.out.println("Вы хлопаете себя по карманам...");
        Inventory playerInv = this.getInventory();
        if (playerInv.countItems() <= 0) {
            System.out.println("Мде уж...нашёл только дырку от бублика");
        } else {
            System.out.println("У вас сейчас: " + this.showInventory() + " .Какой предмет выбрать?");
            String obj_1 = Main.SCANNER.nextLine();
            if (!playerInv.isItemExist(obj_1)) {
                System.out.println("Здрасьте, " + obj_1 + " нет в инвентаре...");
                return;
            }
            Location location = this.getCurrentLocation();
            System.out.println("На что применить предмет? Тут сейчас: " + location.showInventory());
            String subj_1 = Main.SCANNER.nextLine();
            if (!location.getLocationInventory().isItemExist(subj_1)) {
                System.out.println("Здрасьте, " + subj_1 + " нет в этой локации...");
                return;
            }
            Item item_1 = playerInv.demonstrateItem(obj_1);
            Item item_2 = location.getLocationInventory().demonstrateItem(subj_1);
            if (!Main.RULES_CATALOG.checkCombo(item_1, item_2)) {
                System.out.println("Тут что-то не то, надо бы подумать...");
                return;
            }
            if (item_2.getMoveable().equals(Moveable.YES)){
                System.out.println("Возьмите сначала предмет: " + item_2 + " в руки");
                return;
            }
            item_1 = playerInv.takeItem(obj_1);
            Combo combo = Main.RULES_CATALOG.getCombo(item_1, item_2);
            playerInv.addItem(combo.getResult());
            System.out.println(combo.getMessage());
        }
    }

    public void exitGame() {
        System.exit(0);
    }

}
