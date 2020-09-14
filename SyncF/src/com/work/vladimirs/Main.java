package com.work.vladimirs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {
    public static final String REMOTE_DIR= "E://Тату";
    public static final String LOCAL_DIR= "C://Тату";


    public static void main(String[] args) throws IOException {
        File f1 = new File(REMOTE_DIR);
        File f2 = new File(LOCAL_DIR);

        File[] files = f1.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {

            } else if(file.isFile()) {
                //Files.copy(Paths.get(file.getPath()), f2.toPath());
                System.out.println(file.getPath());
                Files.copy(file.toPath(), Paths.get(f2.getPath() + "\\" + file.getName()));
            }
        }
    }
}
