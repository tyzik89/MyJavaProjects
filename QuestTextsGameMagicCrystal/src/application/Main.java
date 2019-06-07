package application;

import config.RulesCatalog;
import items.*;
import locations.Direction;
import locations.Location;
import locations.Locations;
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
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
//        ROOM.getDirections().put(Direction.SOUTH, GARDEN);
        ROOM.addDirection(Direction.SOUTH, GARDEN);
        ROOM.addDirection(Direction.UP, LOFT);
        GARDEN.addDirection(Direction.NORTH, ROOM);
        LOFT.addDirection(Direction.DOWN, ROOM);
        Item bottle = new Item("Бутылка", "Пустая бутылка из под виски", Moveable.YES);
        Item bucket = new Item("Ведро", "Пустое ведро", Moveable.YES);
        Item chain = new Item("Цепь", "Ржавая цепь", Moveable.YES);
        Item drinkWizard = new Item("Волшебник", "Пьянющий волшебник", Moveable.NO);
        Item frog = new Item("Лягушка", "Обычная зелёная квакающая лягушка", Moveable.YES);
        Item toad = new Item("Жаба", "Толстая отвратительная жаба", Moveable.YES);
        Item fountain = new Item("Колодец", "Глубокий колодец с отрезвляющей холодной водой", Moveable.NO);
        Item gasJet = new Item("Горелка", "Старая газовая горелка", Moveable.NO);
        Item bucketChain = new Item("Ведро и цепь", "Цепь на ведре...на соплях", Moveable.YES);
        Item bucketChainHard = new Item("Ведроцепь", "Удивительная и не повторимая", Moveable.YES);
        Item bottleFrog = new Item("Лягушка в бутылке", "Квакает, умоляет выпустить", Moveable.YES);
        Item crystal = new Item("Кристалл", "Кристал всевластия", Moveable.YES);
        Item waterBucket = new Item("Ведро с водой", "Старая добрая отрезвляющая водица", Moveable.YES);

        ROOM.fillInventory(bottle);
        ROOM.fillInventory(bucket);
        ROOM.fillInventory(drinkWizard);

        GARDEN.fillInventory(chain);
        GARDEN.fillInventory(frog);
        GARDEN.fillInventory(fountain);

        LOFT.fillInventory(gasJet);
        LOFT.fillInventory(toad);

        RULES_CATALOG.addCombo(new Combo(frog, bottle, bottleFrog, "Посадил лягушку в бутылку! я молодец."));
        RULES_CATALOG.addCombo(new Combo(bucket, chain, bucketChain, "Кое-как привязал - выглядит не надёжно..."));
        RULES_CATALOG.addCombo(new Combo(bucketChain, gasJet, bucketChainHard, "Надож до такого додуматься - ведроцепь!"));
        RULES_CATALOG.addCombo(new Combo(bucketChainHard, fountain, waterBucket, "Теперь есть ведро с отрезвляющей водой"));
        RULES_CATALOG.addCombo(new Combo(waterBucket, drinkWizard, crystal, "Волшебник очнулся и отдал кристал! УРА!"));

        System.out.println("Вы находитесь в гостиной в доме волшебника. А вот и он сам громко храпит на\n" +
                "кровати. Вам необходимо разбудить этого старого алкаша и забрать волшебный кристалл!\n" +
                "И с его помощью наконец-то захватить весь мир! Пора действовать!!!\n");
        int action;
        while (!player.getInventory().isItemExist("Кристалл")) {
            printMenu();
            try {
                action = SCANNER.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("\n\n\nВведите циферку пожалста.\n\n\n");
                continue;
            } finally {
                SCANNER.nextLine();
            }


            System.out.println("\n\n\n\n");
            switch (action) {
                case 1:
                    player.lookAround();
                    break;
                case 2:
                    player.goToLocation();
                    break;
                case 3:
                    player.takeItem();
                    break;
                case 4:
                    player.modifyItem();
                    break;
                case 5:
                    player.researchItem();
                    break;
                case 6:
                    player.showMyInventory();
                    break;
                case 7:
                    player.applyItem();
                    break;
                case 8:
                case 9:
                    System.out.println("И что делать?");
                    break;
                case 0:
                    player.exitGame();
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
}
