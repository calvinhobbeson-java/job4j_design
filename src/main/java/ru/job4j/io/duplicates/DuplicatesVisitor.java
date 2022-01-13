package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private Map<FileProperty, Path> paths = new HashMap<>();
    private List<Path> duplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty model = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!paths.containsKey(model)) {
            paths.put(model, file.toAbsolutePath());
        } else {
            duplicates.add(file);
        }
        return super.visitFile(file, attrs);
    }
}