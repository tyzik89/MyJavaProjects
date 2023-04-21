package com.work.vladimirs.annotations.social_network_bot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MessageListener messageListener = new MessageListener();

        while (true) {
            messageListener.onMessageReceived(scanner.nextLine());
        }
    }
}
