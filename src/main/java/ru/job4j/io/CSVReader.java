package ru.job4j.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class CSVReader {
    /**
     * Записываем ключи, читаем  данные,  записываем  результат
     * @param argsName
     * @throws Exception
     */
    public static void handle(ArgsName argsName) throws Exception {
        String path  = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String filter = argsName.get("filter");
        List<String> data = readFile(path);
        writeData(path, filter, out, delimiter);
    }
    private static List readFile(String path)  {
        List<String> data = new ArrayList<>();
        Scanner scanner = new Scanner(path);
        while(scanner.hasNext()) {
            data.add(scanner.nextLine());
        }
        return data;
    }
    private static writeData()


}
