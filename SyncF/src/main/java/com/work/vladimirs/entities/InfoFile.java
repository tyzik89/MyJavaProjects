package com.work.vladimirs.entities;

import java.nio.file.Path;

public class InfoFile implements Comparable<InfoFile> {
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

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InfoFile infoFile = (InfoFile) o;

        if (isFile != infoFile.isFile) return false;
        if (!path.equals(infoFile.path)) return false;
        if (!name.equals(infoFile.name)) return false;
        return fullPath.equals(infoFile.fullPath);
    }

    @Override
    public int hashCode() {
        int result = path.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + fullPath.hashCode();
        result = 31 * result + (isFile ? 1 : 0);
        return result;
    }

    @Override
    public int compareTo(InfoFile o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "InfoFile{" +
                "path=" + path +
                ", name='" + name + '\'' +
                ", fullPath='" + fullPath + '\'' +
                ", isFile=" + isFile +
                '}';
    }
}
