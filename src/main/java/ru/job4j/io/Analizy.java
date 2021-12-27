package ru.job4j.io;

import java.io.*;

public class Analizy {

    public void unavailable(String source, String target) {
        String[] status;
        boolean serverDown = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                status = line.split(" ");
                while (!serverDown) {
                    if (status[0].equals("400") || status[0].equals("500")) {
                        serverDown = true;
                        writer.println(status[1]);
                    }
                }
                while (serverDown) {
                    if (status[0].equals("200") || status[0].equals("300")) {
                        writer.println(status[1]);
                        serverDown = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("server.txt", "target.txt");
    }
}