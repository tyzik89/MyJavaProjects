package application;

import config.RulesCatalog;
import items.*;
import locations.Direction;
import locations.Location;
import locations.Locations;
import menus.Menu;
import players.Player;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final Location ROOM = new Location(
            Locations.ROOM,
            "Обыкновенная комнатушка в старом доме",
            new HashMap<Direction, Location>());
    public static final Location GARDEN = new Location(
            Locations.GARDEN,
            "Чудесный сад с цветами для алхимии и старым глубоким колодцем",
            new HashMap<Direction, Location>(){});
    public static final Location LOFT = new Location(
            Locations.LOFT,
            "Старый чердак, с разным хламом",
            new HashMap<Direction, Location>(){});

    public static final Player player = new Player(ROOM);
    public static final RulesCatalog RULES_CATALOG = new RulesCatalog();

    public static void main(String[] args) {
        ROOM.getDirections().put(Direction.SOUTH, GARDEN);
        ROOM.getDirections().put(Direction.UP, LOFT);
        GARDEN.getDirections().put(Direction.NORTH, ROOM);
        LOFT.getDirections().put(Direction.DOWN, ROOM);
        Item bottle = new Bottle("Бутылка", "Пустая бутылка из под виски", Moveable.YES);
        Item bucket = new Bucket("Ведро", "Пустое ведро", Moveable.YES);
        Item chain = new Chain("Цепь", "Ржавая цепь", Moveable.YES);
        Item drinkWizard = new DrinkWizard("Волшебник", "Пьянющий волшебник", Moveable.NO);
        Item frog = new Frog("Лягушка", "Обычная зелёная квакающая лягушка", Moveable.YES);
        Item toad = new Frog("Жаба", "Толстая отвратительная жаба", Moveable.YES);
        Item fountain = new Fountain("Колодец", "Глубокий колодец с отрезвляющей холодной водой", Moveable.NO);
        Item gasJet = new GasJet("Горелка", "Старая газовая горелка", Moveable.NO);
        Item bucketChain = new BucketChain("Ведро и цепь", "Цепь на ведре...на соплях", Moveable.YES);
        Item bucketChainHard = new BucketChain("Ведроцепь", "Удивительная и не повторимая", Moveable.YES);
        Item bottleFrog = new BottleFrog("Лягушка в бутылке", "Квакает, умоляет выпустить", Moveable.YES);
        Item crystal = new Crystal("Кристалл", "Кристал всевластия", Moveable.YES);
        Item waterBucket = new WaterBucket("Ведро с водой", "Старая добрая отрезвляющая водица", Moveable.YES);

        ROOM.getLocationInventory().addItem(bottle);
        ROOM.getLocationInventory().addItem(bucket);
        ROOM.getLocationInventory().addItem(drinkWizard);

        GARDEN.getLocationInventory().addItem(chain);
        GARDEN.getLocationInventory().addItem(frog);
        GARDEN.getLocationInventory().addItem(fountain);

        LOFT.getLocationInventory().addItem(gasJet);
        LOFT.getLocationInventory().addItem(toad);


        RULES_CATALOG.addCombo(new Combo(frog, bottle, bottleFrog, "Посадил лягушку в бутылку! я молодец."));
        RULES_CATALOG.addCombo(new Combo(bucket, chain, bucketChain, "Кое-как привязал - выглядит не надёжно..."));
        RULES_CATALOG.addCombo(new Combo(bucketChain, gasJet, bucketChainHard, "Надож до такого додуматься - ведроцепь!"));
        RULES_CATALOG.addCombo(new Combo(bucketChainHard, fountain, waterBucket, "Теперь есть ведро с отрезвляющей водой"));
        RULES_CATALOG.addCombo(new Combo(waterBucket, drinkWizard, crystal, "Волшебник очнулся и отдал кристал! УРА!"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Вы находитесь в гостиной в доме волшебника. А вот и он сам громко храпит на\n" +
                "кровати. Вам необходимо разбудить этого старого алкаша и забрать волшебный кристалл!\n" +
                "И с его помощью наконец-то захватить весь мир! Пора действовать!!!\n");
        int action;
        while (!player.getInventory().isItemExist("Кристалл")) {
            printMenu();
            try {
                action = scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\n\n\nВведите циферку пожалста.\n\n\n");
                continue;
            } finally {
                scanner.nextLine();
            }


            System.out.println("\n\n\n\n");
            switch (action) {
                case 1:
                    Menu.lookAround(player.getCurrentLocation());
                    break;
                case 2:
                    Menu.goToLocation(player);
                    break;
                case 3:
                    Menu.takeItem(player);
                    break;
                case 4:
                    Menu.modifyItem(player);
                    break;
                case 5:
                    Menu.researchItem(player);
                    break;
                case 6:
                    Menu.showInventory(player);
                    break;
                case 7:
                    Menu.applyItem(player);
                    break;
                case 8:
                case 9:
                    System.out.println("И что делать?");
                    break;
                case 0:
                    Menu.exitGame();
                    break;
            }
            System.out.println("\n");
        }
        System.out.println("ВЫ ВЫИГРАЛИ! КРИСТАЛЛ У ВАС!");
    }

    private static void printMenu(){
        System.out.println("============================\nВы можете: ");
        System.out.println("1 - Осмотреться");
        System.out.println("2 - Идти");
        System.out.println("3 - Взять   ");
        System.out.println("4 - Скрафтить предметы из инвентаря");
        System.out.println("5 - Исследовать предмет");
        System.out.println("6 - Инвентарь");
        System.out.println("7 - Применить предмет в локации");
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


        Location ROOM = new Location(Locations.ROOM,"Обыкновенная комнатушка в старом доме");
        Location GARDEN = new Location(Locations.GARDEN, "Чудесный сад с цветами для алхимии и старым глубоким колодцем");
        Location LOFT = new Location(Locations.LOFT, "Старый чердак, с разным хламом");

        ROOM.putItem(bottle);
        ROOM.putItem(bucket);
        ROOM.putItem(drinkWizard);

        GARDEN.putItem(chain);
        GARDEN.putItem(frog);
        GARDEN.putItem(fountain);

        LOFT.putItem(gasJet);
        LOFT.putItem(toad);

        Player player = new Player(ROOM);
    }*/
}
