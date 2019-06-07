package config;

import items.Combo;
import items.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RulesCatalog {

    private List<Combo> combos;

    public RulesCatalog() {
        this.combos = new ArrayList<Combo>();
    }

    public void addCombo(Combo combo) {
        combos.add(combo);
    }

    public boolean checkCombo(Item item_1, Item item_2) {
        for (Combo combo : combos) {
            if ((combo.getObj_1().equals(item_1) || combo.getObj_1().equals(item_2))
                    &&(combo.getObj_2().equals(item_1) || combo.getObj_2().equals(item_2))) {
                return true;
            }
        }
        return false;
    }

    public Combo getCombo(Item item_1, Item item_2){
        for (Combo combo : combos) {
            if ((combo.getObj_1().equals(item_1) || combo.getObj_1().equals(item_2))
                    &&(combo.getObj_2().equals(item_1) || combo.getObj_2().equals(item_2))) {
                return combo;
            }
        }
        return null;
    }
}
