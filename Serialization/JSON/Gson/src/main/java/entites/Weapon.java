package entites;

public class Weapon {

    private String type;

    public Weapon(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "type='" + type + '\'' +
                '}';
    }
}
