package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }


    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines()
                    .filter(c -> !c.isEmpty())
                    .filter(c -> !c.contains("#"))
                    .peek(c -> {
                        if (!c.contains("=") || c.startsWith("=") || c.endsWith("=")) {
                            throw new IllegalArgumentException("Wrong args");
                        }
                    })
                    .map(c -> c.split("="))
                    .peek(c -> {
                        if (c.length != 2) {
                            throw new IllegalArgumentException("Wrong args");
                        }
                    })
                    .forEach(c -> values.put(c[0], c[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }

}