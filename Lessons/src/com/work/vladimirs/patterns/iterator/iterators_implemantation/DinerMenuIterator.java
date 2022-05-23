package com.work.vladimirs.patterns.iterator.iterators_implemantation;

import com.work.vladimirs.patterns.iterator.menu_implementation.MenuItem;

public class DinerMenuIterator implements Iterator {

    private MenuItem[] items;
    private int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }
}
