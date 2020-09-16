package com.work.vladimirs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static final String REMOTE_DIR = "D:/Повышение";
    public static final String LOCAL_DIR = "C:/Повышение";


    public static void main(String[] args) throws IOException {
        File f1 = new File(REMOTE_DIR);
        File f2 = new File(LOCAL_DIR);

        Path startRemotePath = Paths.get(REMOTE_DIR);
        Path startLocalPath = Paths.get(LOCAL_DIR);

        CustomFileVisitor remoteFileVisitor = new CustomFileVisitor(new HashSet<>(), startRemotePath);
        Files.walkFileTree(Paths.get(REMOTE_DIR), Collections.EMPTY_SET, Integer.MAX_VALUE, remoteFileVisitor);
        Set<Path> remotePaths = remoteFileVisitor.getPathHashSet();

        CustomFileVisitor localFileVisitor = new CustomFileVisitor(new HashSet<>(), startLocalPath);
        Files.walkFileTree(Paths.get(LOCAL_DIR), Collections.EMPTY_SET, Integer.MAX_VALUE, localFileVisitor);
        Set<Path> localPaths = localFileVisitor.getPathHashSet();

        remotePaths.removeAll(localPaths);
        remotePaths.forEach(System.out::println);
        remotePaths.forEach(path -> {
            try {
                Files.copy(Paths.get(REMOTE_DIR + path), Paths.get(LOCAL_DIR + path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
