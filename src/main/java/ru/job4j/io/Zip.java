package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName parameters = ArgsName.of(args);
        Path directory = Paths.get(parameters.get("d"));
        String fileType = parameters.get("e");
        File target = Paths.get(parameters.get("o")).toFile();

        if (args.length != 3 || !directory.toFile().exists() || !directory.toFile().isDirectory()) {
            throw new IllegalArgumentException("Wrong args");
        }
        if (!fileType.startsWith(".")) {
            fileType = fileType.replace(fileType.charAt(0), '.');
        }
        String finalFileType = fileType;
        List<Path> pathsList = Search.search(directory, p -> p.endsWith(finalFileType));
        packFiles(pathsList, target);
    }
}