package com.work.vladimirs.patterns.decorator.example_1;

import com.work.vladimirs.patterns.decorator.example_1.beverages.Beverage;
import com.work.vladimirs.patterns.decorator.example_1.beverages.DarkRoast;
import com.work.vladimirs.patterns.decorator.example_1.beverages.Espresso;
import com.work.vladimirs.patterns.decorator.example_1.beverages.HouseBlend;
import com.work.vladimirs.patterns.decorator.example_1.decorators.Mocha;
import com.work.vladimirs.patterns.decorator.example_1.decorators.Soy;
import com.work.vladimirs.patterns.decorator.example_1.decorators.Whip;

public class Main {

    public static void main(String[] args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " $" + espresso.cost());

        Beverage darkRoast = new DarkRoast();
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Mocha(darkRoast);
        darkRoast = new Whip(darkRoast);
        System.out.println(darkRoast.getDescription() + " $" + darkRoast.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new Soy(houseBlend);
        houseBlend = new Mocha(houseBlend);
        houseBlend = new Whip(houseBlend);
        System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
    }
}
