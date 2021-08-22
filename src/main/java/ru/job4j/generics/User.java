package ru.job4j.generics;

public class User extends Base {
    String id = Double.toString(Math.random());

    public User(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return id;
    }
}
