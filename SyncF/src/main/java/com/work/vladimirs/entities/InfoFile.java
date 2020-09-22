package com.work.vladimirs.entities;

import java.nio.file.Path;

public class InfoFile {
    private Path path;
    private String name;
    private String fullPath;
    private boolean isFile;

    public InfoFile(Path path, String name, String fullPath, boolean isFile) {
        this.path = path;
        this.name = name;
        this.fullPath = fullPath;
        this.isFile = isFile;
    }
}
