package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           return in.lines()
                   .filter(c -> c.contains(" 404 "))
                   .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filter(file);
    }
    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)))) {
            out.println(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
    }
}