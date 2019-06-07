package locations;

public enum Direction {
    NORTH("Север"),
    SOUTH("Юг"),
    WEST("Запад"),
    EAST("Восток"),
    UP("Вверх"),
    DOWN("Вниз");

    private String name;

    Direction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
