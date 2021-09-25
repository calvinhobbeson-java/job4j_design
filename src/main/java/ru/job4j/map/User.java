package ru.job4j.map;

import java.util.*;

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
        Calendar calendar = new GregorianCalendar(2017, Calendar.SEPTEMBER, 25);
        Map<User, Object> map = new HashMap<>();
        User userOne = new User(
                "Garry", 1,
                calendar);
        User userTwo = new User(
                "Garry", 1,
                calendar);

        map.put(userOne, new Object());
        map.put(userTwo, new Object());

        System.out.println(map);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}
