package entites;

public class UniqueWeapon extends Weapon {

    private String name;
    private String origin;

    public UniqueWeapon(String type, String name, String origin) {
        super(type);
        this.name = name;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return "UniqueWeapon{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }
}
