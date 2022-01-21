package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * класс описывает разделение листа параметров и предачу их в карту
 * @author Calvin Hobbeson
 * @version 1.1
 * добавил валидацию в метод get
 */

public class ArgsName {

    /**
     * @param values карта для хранения пар ключ значение
     * проверяем, что в листе находятся подходящие аргументы, которые можно распарсить
     * убираем дефис в начале строки(его не должно быть согласно тесту)
     * разделяем строку на  две через разделитель
     * кладем в карту первый аргумент как ключ, второй как значение
     * в методе гет проверяем, и выдаем исключение, если ключа нет в карте
     */

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Wrong args");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        Arrays.stream(args).peek(c -> {
                    if (c.endsWith("=")) {
                        throw new IllegalArgumentException("Wrong args");
                    }
                })
                .map(c -> c.replaceFirst("-", ""))
                .map(c -> c.split("=", 2))
                .forEach(c -> values.put(c[0], c[1]));
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}