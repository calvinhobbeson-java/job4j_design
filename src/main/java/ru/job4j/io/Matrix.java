package ru.job4j.io;

import java.io.FileOutputStream;

public class Matrix {
    public void multiple(int size) {
        try (FileOutputStream out = new FileOutputStream("multiTable.txt")) {
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    String result = i * j + " ";
                    out.write(result.getBytes());
                }  out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Matrix().multiple(10);
    }
}
