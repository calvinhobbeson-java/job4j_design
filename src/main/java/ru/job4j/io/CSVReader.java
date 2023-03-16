package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    /**
     * Записываем ключи, читаем  данные,  записываем  результат
     *
     * @param argsName
     * @throws Exception
     */
    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String filter = argsName.get("filter");
        List<String> data = readFile(path);
        writeData(data, filter, out, delimiter);
    }

    /**
     * Читаем файл сканером и собираем в список
     *
     * @param path
     * @return
     */
    private static List readFile(String path) {
        List<String> data = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream(path), StandardCharsets.UTF_8).useDelimiter(System.lineSeparator())) {
            while (scanner.hasNext()) {
                data.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Создаем массив фильтров из входного параметра
     * Создаем массив названий столбцов, парсингом первой строки списка
     * Создаем список индексов, проходимся по названиям столбцов и добавляем в список индексы названий, соответствующих фильтрам
     * Создаем массив куда по очереди передаем строки списка, затем проходимся разделенному делиметром  массиву и добавляем к  в строку result строки
     *
     * @param data
     * @param filter
     * @param out
     * @param delimiter
     * @throws FileNotFoundException
     */
    private static void writeData(List<String> data, String filter, String out, String delimiter) throws FileNotFoundException {
        String[] filters = filter.split(",");
        String[] dataHeaders = data.get(0).split(delimiter);
        List<Integer> indexes = new ArrayList<>();
        for (int q = 0; q < filters.length; q++) {
            for (int e = 0; e < dataHeaders.length; e++) {
                if (filters[q].equals(dataHeaders[e])) {
                    indexes.add(e);
                }
            }
        }
        String[] temp;
        String result = "";
        for (String str : data) {
            temp = str.split(delimiter);
            for (int index = 1; index < indexes.size(); index++) {
                result = result + temp[indexes.get(index)];
            }
            if (out.equals("stdout")) {
                System.out.println(result);
            } else {
                try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(out)))) {
                    printWriter.write(result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 4) {
            throw new IllegalArgumentException("Wrong number of arguments");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
