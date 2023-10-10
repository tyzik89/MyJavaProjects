package entites;

import java.util.LinkedList;
import java.util.List;

public class DwarvesBand {

    private List<Dwarf> dwarves = new LinkedList<Dwarf>();

    public List<Dwarf> getDwarves() {
        return dwarves;
    }

    public void addDwarf(Dwarf dwarves) {
        this.dwarves.add(dwarves);
    }

    @Override
    public String toString() {
        return "DwarvesBand{" +
                "dwarves=" + dwarves +
                '}';
    }
}
