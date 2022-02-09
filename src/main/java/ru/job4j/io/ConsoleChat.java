package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        List<String> read = readPhrases();
        boolean quit = false;
        boolean stop = false;
        System.out.println("Введите вопрос");
        while (!quit) {
            String enter = in.nextLine();
            log.add(enter);
            if (OUT.equals(enter)) {
                quit = true;
            }
            if (STOP.equals(enter)) {
                stop = true;
            }
            if (CONTINUE.equals(enter) && stop) {
                stop = false;
            }
            if (!quit && !stop) {
                String randomAnswer = read.get(random.nextInt(read.size()));
                System.out.println(randomAnswer);
                log.add(randomAnswer);
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            br.lines().forEach(answers::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/log.txt", "./data/answers.txt");
        cc.run();
    }
}