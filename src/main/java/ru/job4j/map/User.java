package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>();
        User userOne = new User(
                "Garry", 1,
                new GregorianCalendar(2017, Calendar.SEPTEMBER, 25));
        User userTwo = new User(
                "Garry", 1,
                new GregorianCalendar(2017, Calendar.SEPTEMBER, 25));

        map.put(userOne, new Object());
        map.put(userTwo, new Object());

        System.out.println(map);
    }
}
