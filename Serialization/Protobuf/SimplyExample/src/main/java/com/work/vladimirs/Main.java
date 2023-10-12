package com.work.vladimirs;

import com.work.vladimirs.proto.Person;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        String email = "j@gmail.com";
        int id = new Random().nextInt();
        String name = "Vovka Program";
        String number = "01234567890";
        Person person =
                Person.newBuilder()
                        .setId(id)
                        .setName(name)
                        .setEmail(email)
                        .addNumbers(number)
                        .build();

        System.out.println(person);
    }
}