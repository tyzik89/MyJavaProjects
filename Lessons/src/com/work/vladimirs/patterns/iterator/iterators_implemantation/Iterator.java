package com.work.vladimirs.patterns.iterator.iterators_implemantation;

import com.work.vladimirs.patterns.iterator.menu_implementation.MenuItem;

public interface Iterator {

    boolean hasNext();

    MenuItem next();
}
