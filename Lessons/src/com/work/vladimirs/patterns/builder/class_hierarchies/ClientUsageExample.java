package com.work.vladimirs.patterns.builder.class_hierarchies;

public class ClientUsageExample {

    public static void main(String[] args) {
        NYPizza nyPizza = new NYPizza
                .Builder(NYPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();
        Calzone calzone = new Calzone
                .Builder()
                .addTopping(Pizza.Topping.HAM)
                .sauceInside()
                .build();
    }
}
