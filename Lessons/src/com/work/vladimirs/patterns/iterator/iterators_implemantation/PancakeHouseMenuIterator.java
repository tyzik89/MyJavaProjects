package com.work.vladimirs.patterns.iterator.iterators_implemantation;

import com.work.vladimirs.patterns.iterator.menu_implementation.MenuItem;

import java.util.List;

public class PancakeHouseMenuIterator implements Iterator {

    private List<MenuItem> menuItems;
    private int position = 0;

    public PancakeHouseMenuIterator(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.size()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = menuItems.get(position);
        position++;
        return menuItem;
    }
}
