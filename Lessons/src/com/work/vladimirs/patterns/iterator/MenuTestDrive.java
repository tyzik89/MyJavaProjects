package com.work.vladimirs.patterns.iterator;

import com.work.vladimirs.patterns.iterator.menu_implementation.DinerMenu;
import com.work.vladimirs.patterns.iterator.menu_implementation.PancakeHouseMenu;

public class MenuTestDrive {

    public static void main(String args[]) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
    }
}
