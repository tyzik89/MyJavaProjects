package entites;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedList;
import java.util.List;

public class Dwarf {

    private String name;

    @Expose
    private String lunch;

    @SerializedName("age")
    private int dwarfAge;

    private FacialHair facialHair;
    private List<Weapon> weapons = new LinkedList<Weapon>();

    public Dwarf() {
    }

    public Dwarf(String name, int dwarfAge) {
        this.name = name;
        this.dwarfAge = dwarfAge;
    }

    public String getName() {
        return name;
    }

    public String getLunch() {
        return lunch;
    }

    public int getDwarfAge() {
        return dwarfAge;
    }

    public FacialHair getFacialHair() {
        return facialHair;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public void setFacialHair(FacialHair facialHair) {
        this.facialHair = facialHair;
    }

    public void setDwarfAge(int dwarfAge) {
        this.dwarfAge = dwarfAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addWeapon(Weapon weapons) {
        this.weapons.add(weapons);
    }
}
