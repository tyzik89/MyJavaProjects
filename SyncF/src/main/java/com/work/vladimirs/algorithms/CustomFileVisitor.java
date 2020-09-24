package com.work.vladimirs.algorithms;

import com.work.vladimirs.entities.InfoFile;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;

class CustomFileVisitor implements FileVisitor<Path> {
    private TreeSet<InfoFile> infoFiles;
    private Path startPath;
    private String stringStartPath;
    private AtomicLong sizeDir;

    public CustomFileVisitor(TreeSet<InfoFile> infoFiles, Path startPath) {
        this.infoFiles = infoFiles;
        this.startPath = startPath;
        stringStartPath = startPath.toString().replace("\\", "\\\\");   //Замена для использования в регулярном выражении
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        sizeDir  = new AtomicLong(0);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path shortPath = getShortPathForRegexp(file);
        if (!shortPath.toString().isEmpty()) {
            sizeDir.addAndGet(attrs.size());
            InfoFile infoFile = new InfoFile.Builder()
                    .fullPath(file.toString())
                    .isFile(true)
                    .shortPath(shortPath)
                    .size(attrs.size())
                    .build();
            infoFiles.add(infoFile);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        Path shortPath = getShortPathForRegexp(dir);
        if (!shortPath.toString().isEmpty()) {
            InfoFile infoFile = new InfoFile.Builder()
                    .fullPath(dir.toString())
                    .isFile(false)
                    .shortPath(shortPath)
                    .size(sizeDir.get())
                    .build();
            infoFiles.add(infoFile);
        }
        return FileVisitResult.CONTINUE;
    }

    public TreeSet<InfoFile> getInfoFiles() {
        return infoFiles;
    }

    private Path getShortPathForRegexp(Path pathWithRoot) {
        String stringPathWithRoot = pathWithRoot.toString();
        String stringClearPath = stringPathWithRoot.replaceFirst(stringStartPath, "");    // Выделяем из пути часть, не содержащую сам корневой путь.
        return Paths.get(stringClearPath);
    }
}
