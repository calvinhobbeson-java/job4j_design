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

/**
 * класс описывает поиск дубликатов в файловой системе
 * @author Calvin Hobbeson
 * @version 1.5
 * выделил печать списка в отделный метод
 * добавил построчный вывод резалта
 */

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    /**
     * @param models карта для хранения обьектов  FileProperty в качестве ключа, и списка путей как значения
     * @param paths список для хранения путей
     * @param model экземпляр класса FileProperty
     * @param pathsList список списков для путей, чтобы вывести егов консоль методом getPaths в main
     * создаем карту для  хранения обьектов и путей
     * создаем экземпляр файла, отражающий нужные параметры для сравнения - имя и размер
     * проверяем, есть ли ключ в карте, если нет, то создаем новый список, помещаем туда пути, и добавляем пару в карту
     * если ключ в карте есть, то вызываем по ключу список путей, добавляем туда новый путь
     * добавляем в pathsList списки, размером больше 1
     */

    private Map<FileProperty, List<Path>> models = new HashMap<>();
    private List<List<Path>> pathsList = new ArrayList<>();

    public void getPaths() {
        pathsList.forEach(System.out::println);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty model = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!models.containsKey(model)) {
            List<Path> paths = new ArrayList<>();
            paths.add(file.toAbsolutePath());
            models.put(model, paths);
        } else {
            models.get(model).add(file);
        }
        if (models.get(model).size() > 1) {
            pathsList.add(models.get(model));
        }
            return super.visitFile(file, attrs);
        }
    }