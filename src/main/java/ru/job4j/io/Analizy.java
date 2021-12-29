package ru.job4j.io;

import java.io.*;

/**
 * класс описывает преобразование одного файла в другой
 * @author calvinHobbeson
 * @version 1.1
 * убрал циклы while
 */

public class Analizy {
    /**
     *
     * @param source путь к файлу лога
     * @param target имя путь к файлу результата анализа
     * создаем переменную, serverDown, которая показывает состояние сервера
     * используем конструкцию try-with-resources
     * создаем два потока на чтение и запись (декоратор)
     * разделяем входные данные
     * если  статус 400 или 500 то сервер падает, и идет запись
     * если при упавшем сервере статус становится 300 или 200 то сервер оживает и снова записываем
     */

    public void unavailable(String source, String target) {
        String[] status;
        boolean serverDown = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(source));
             PrintWriter writer = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                status = line.split(" ");
                    if (!serverDown && "400".equals(status[0]) || !serverDown && "500".equals(status[0])) {
                        serverDown = true;
                        writer.printf(status[1], "%s%n");
                    }
                    if (serverDown && "200".equals(status[0]) || serverDown && "300".equals(status[0])) {
                        writer.printf("%s%n", status[1]);
                        serverDown = false;
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