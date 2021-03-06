package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int num;
            while ((num = in.read()) != -1) {
                    text.append((char) num);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                System.out.println("Четное ли число " + line + "?" + " " + ((Integer.parseInt(line) % 2 == 0) ? "четное" : "нечетное"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}