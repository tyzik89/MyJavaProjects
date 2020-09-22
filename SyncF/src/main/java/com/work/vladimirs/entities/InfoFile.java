package com.work.vladimirs.entities;

import java.nio.file.Path;

public class InfoFile implements Comparable<InfoFile> {
    private final Path shortPath;
    private final String nameFile;
    private final String fullPath;
    private final boolean isFile;

    public static class Builder {
        private Path shortPath;
        private String nameFile;
        private String fullPath;
        private boolean isFile;

        public Builder() {}

        public Builder shortPath(Path shortPath) {
            this.shortPath = shortPath;
            return this;
        }

        public Builder nameFile(String nameFile) {
            this.nameFile = nameFile;
            return this;
        }

        public Builder fullPath(String fullPath) {
            this.fullPath = fullPath;
            return this;
        }

        public Builder isFile(boolean file) {
            isFile = file;
            return this;
        }

        public InfoFile build() {
            return new InfoFile(this);
        }
    }

    public InfoFile(Builder builder) {
        shortPath = builder.shortPath;
        nameFile = builder.nameFile;
        fullPath = builder.fullPath;
        isFile = builder.isFile;
    }

    @Override
    public int compareTo(InfoFile o) {
        return shortPath.compareTo(o.shortPath);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InfoFile infoFile = (InfoFile) o;

        if (isFile != infoFile.isFile) return false;
        if (!shortPath.equals(infoFile.shortPath)) return false;
        return fullPath.equals(infoFile.fullPath);
    }

    @Override
    public int hashCode() {
        int result = shortPath.hashCode();
        result = 31 * result + fullPath.hashCode();
        result = 31 * result + (isFile ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "InfoFile{" +
                "shortPath=" + shortPath +
                ", nameFile='" + nameFile + '\'' +
                ", fullPath='" + fullPath + '\'' +
                ", isFile=" + isFile +
                '}';
    }

    public Path getShortPath() {
        return shortPath;
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getFullPath() {
        return fullPath;
    }

    public boolean isFile() {
        return isFile;
    }
}
