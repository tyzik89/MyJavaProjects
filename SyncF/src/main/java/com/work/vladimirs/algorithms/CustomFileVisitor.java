package com.work.vladimirs.algorithms;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.TreeSet;

class CustomFileVisitor implements FileVisitor<Path> {
    private TreeSet<Path> pathSet;
    private Path startPath;
    private String stringStartPath;

    public CustomFileVisitor(TreeSet<Path> pathSet, Path startPath) {
        this.pathSet = pathSet;
        this.startPath = startPath;
        stringStartPath = startPath.toString().replace("\\", "\\\\");   //Замена для использования в регулярном выражении
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newPath = getPathForRegexp(dir);
        if (!newPath.toString().isEmpty()) pathSet.add(newPath);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path newPath = getPathForRegexp(file);
        if (!newPath.toString().isEmpty()) pathSet.add(newPath);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public TreeSet<Path> getPathSet() {
        return pathSet;
    }

    private Path getPathForRegexp(Path pathWithRoot) {
        String stringPathWithRoot = pathWithRoot.toString();
        String stringClearPath = stringPathWithRoot.replaceFirst(stringStartPath, "");    // Выделяем из пути часть, не содержащую сам корневой путь.
        return Paths.get(stringClearPath);
    }
}