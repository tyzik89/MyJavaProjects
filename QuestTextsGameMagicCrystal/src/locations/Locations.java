package locations;

public enum Locations {
    GARDEN("Сад"),
    ROOM("Комната"),
    LOFT("Чердак");

    private String name;

    Locations(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
