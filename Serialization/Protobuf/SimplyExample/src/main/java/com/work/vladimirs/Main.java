package com.work.vladimirs;

import com.google.protobuf.InvalidProtocolBufferException;
import com.work.vladimirs.proto.Person;

import java.util.List;
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

        final byte[] binaryPerson = person.toByteArray();
        
        Person personFromBinary = instantiatePersonFromBinary(binaryPerson);
        System.out.println(personFromBinary);
    }

    private static Person instantiatePersonFromBinary(final byte[] binaryPerson) {
        Person person = null;
        try {
            final Person copiedPersonProtos = Person.parseFrom(binaryPerson);;
            person = Person.newBuilder()
                    .setId(copiedPersonProtos.getId())
                    .setName(copiedPersonProtos.getName())
                    .setEmail(copiedPersonProtos.getEmail())
                    .addNumbers(copiedPersonProtos.getNumbers(0))
                    .build();
        } catch (InvalidProtocolBufferException ipbe) {
            System.out.println("ERROR: Unable to instantiate Person instance from provided binary data - " +
                    ipbe);
        }
        return person;
    }
}