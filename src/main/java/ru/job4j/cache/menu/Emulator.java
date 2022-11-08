package ru.job4j.cache.menu;

import ru.job4j.cache.DirFileCache;

import java.util.Scanner;

public class Emulator {
    DirFileCache dirFileCache;
    Scanner scanner = new Scanner(System.in);

    public static final int ADD_DIRECTORY = 1;
    public static final int LOAD_TO_CACHE = 2;
    public static final int GET_FROM_CACHE = 3;
    public static final String MENU = """
                    Выберите пункт меню:
                    1-выбрать  директорию
                    3-выгрузить файл из кэша
                    Любая другая клавиша - выход""";


    private void insertDirectory() {
        System.out.println("Введите путь до директории");
        String directory = scanner.nextLine();
        dirFileCache = new DirFileCache(directory);
    }

    private void getCache() {
        System.out.println("Введите имя файла");
        String name = scanner.nextLine();
        String result = dirFileCache.get(name);
        System.out.println(result);
    }

    private void start() {
        boolean run = true;
        while (run) {
            System.out.println(MENU);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                insertDirectory();
            } else if (choice == 3) {
                getCache();
            } else {
                run = false;
            }
        }
    }

    public static void main(String[] args) {
        Emulator emul = new Emulator();
        emul.start();
    }
}