package com.work.vladimirs.algorithms;

import com.work.vladimirs.entities.InfoFile;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.TreeSet;

public class PathsWorker {

    public TreeSet<InfoFile> analyzeDir(String strDir) throws IOException {
        CustomFileVisitor customFileVisitor = new CustomFileVisitor(new TreeSet<>(), Paths.get(strDir));
        Files.walkFileTree(Paths.get(strDir), Collections.EMPTY_SET, Integer.MAX_VALUE, customFileVisitor);
        return customFileVisitor.getInfoFiles();
    }

    public void syncFiles(ObservableList<InfoFile> filesPaths, String strDirTo) {
        filesPaths.forEach(path -> {
            try {
                Files.copy(Paths.get(path.getFullPath()), Paths.get(strDirTo + path.getShortPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
