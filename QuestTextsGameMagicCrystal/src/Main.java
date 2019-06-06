import items.*;
import locations.Location;
import locations.Locations;
import menus.Menu;
import players.Player;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Item bottle = new Bottle("Бутылка", "Пустая бутылка из под виски", Moveable.YES);
        Item bucket = new Bucket("Ведро", "Пустое ведро", Moveable.YES);
        Item chain = new Chain("Цепь", "Ржавая цепь", Moveable.YES);
        Item drinkWizard = new DrinkWizard("Волшебник", "Пьянющий волшебник", Moveable.NO);
        Item frog = new Frog("Лягушка", "Обычная зелёная квакающая лягушка", Moveable.YES);
        Item toad = new Frog("Жаба", "Толстая отвратительная жаба", Moveable.YES);
        Item fountain = new Fountain("Колодец", "Глубокий колодец с отрезвляющей холодной водой", Moveable.NO);
        Item gasJet = new GasJet("Горелка", "Старая газовая горелка", Moveable.NO);


        Location room = new Location(Locations.ROOM,"Обыкновенная комнатушка в старом доме");
        Location garden = new Location(Locations.GARDEN, "Чудесный сад с цветами для алхимии и старым глубоким колодцем");
        Location loft = new Location(Locations.LOFT, "Старый чердак, с разным хламом");

        room.getLocationInventory().addItem(bottle);
        room.getLocationInventory().addItem(bucket);
        room.getLocationInventory().addItem(drinkWizard);

        garden.getLocationInventory().addItem(chain);
        garden.getLocationInventory().addItem(frog);
        garden.getLocationInventory().addItem(fountain);

        loft.getLocationInventory().addItem(gasJet);
        loft.getLocationInventory().addItem(toad);

        Player player = new Player(room);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Вы находитесь в гостиной в доме волшебника. А вот и он сам громко храпит на\n" +
                "кровати. Вам необходимо разбудить этого старого алкаша и забрать волшебный кристалл!\n" +
                "И с его помощью наконец-то захватить весь мир! Пора действовать!!!\n");
        while (true) {
            printMenu();
            int action = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\n\n\n\n");
            switch (action) {
                case 1:
                    Menu.lookAround(player.getCurrentLocation());
                    break;
                case 2:
                    Menu.goToLocation();
                    break;
                case 3:
                    Menu.takeItem(player);
                    break;
                case 4:
                    Menu.modifyItem();
                    break;
                case 5:
                    Menu.researchItem(player);
                    break;
                case 6:
                    Menu.showInventory(player);
                    break;
                case 7:
                case 8:
                case 9:
                    System.out.println("И что делать?");
                    break;
                case 0:
                    Menu.exitgame();
                    break;
            }
            System.out.println("\n");
        }
    }

    private static void printMenu(){
        System.out.println("============================\nВы можете: ");
        System.out.println("1 - Осмотреться");
        System.out.println("2 - Идти");
        System.out.println("3 - Взять   ");
        System.out.println("4 - Использовать");
        System.out.println("5 - Исследовать предмет");
        System.out.println("6 - Инвентарь");
        System.out.println("0 - Выход");
        System.out.print("Ваше действие: ");
    }

/*    private static void init() {
        Item bottle = new Bottle("Бутылка", "Пустая бутылка из под виски", Moveable.YES);
        Item bucket = new Bucket("Ведро", "Пустое ведро", Moveable.YES);
        Item chain = new Chain("Цепь", "Ржавая цепь", Moveable.YES);
        Item drinkWizard = new DrinkWizard("Волшебник", "Пьянющий волшебник", Moveable.NO);
        Item frog = new Frog("Лягушка", "Обычная зелёная квакающая лягушка", Moveable.YES);
        Item toad = new Frog("Жаба", "Толстая отвратительная жаба", Moveable.YES);
        Item fountain = new Fountain("Колодец", "Глубокий колодец с отрезвляющей холодной водой", Moveable.NO);
        Item gasJet = new GasJet("Горелка", "Старая газовая горелка", Moveable.NO);


        Location room = new Location(Locations.ROOM,"Обыкновенная комнатушка в старом доме");
        Location garden = new Location(Locations.GARDEN, "Чудесный сад с цветами для алхимии и старым глубоким колодцем");
        Location loft = new Location(Locations.LOFT, "Старый чердак, с разным хламом");

        room.putItem(bottle);
        room.putItem(bucket);
        room.putItem(drinkWizard);

        garden.putItem(chain);
        garden.putItem(frog);
        garden.putItem(fountain);

        loft.putItem(gasJet);
        loft.putItem(toad);

        Player player = new Player(room);
    }*/
}
