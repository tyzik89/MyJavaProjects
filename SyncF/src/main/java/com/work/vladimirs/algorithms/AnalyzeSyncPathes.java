package com.work.vladimirs.algorithms;

import com.work.vladimirs.entities.InfoFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.TreeSet;

public class AnalyzeSyncPathes {

    public static final TreeSet<InfoFile> analyzeDir(String strDir) throws IOException {
        CustomFileVisitor customFileVisitor = new CustomFileVisitor(new TreeSet<>(), Paths.get(strDir));
        Files.walkFileTree(Paths.get(strDir), Collections.EMPTY_SET, Integer.MAX_VALUE, customFileVisitor);
        return customFileVisitor.getInfoFiles();
    }

    /* remotePaths.removeAll(localPaths);
        remotePaths.forEach(path -> {
            try {
                Files.copy(Paths.get(REMOTE_DIR + path), Paths.get(LOCAL_DIR + path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    */
}
