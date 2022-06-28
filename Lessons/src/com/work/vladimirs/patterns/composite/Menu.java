package com.work.vladimirs.patterns.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс комбинации может содержать элементы MenuItem или другие Menu
 */
class Menu extends MenuComponent {

    private List<MenuComponent> menuComponents;
    private String name;
    private String description;

    public Menu(String name, String description) {
        this.menuComponents = new ArrayList<>();
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");
        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int idx) {
        return menuComponents.get(idx);
    }
}
