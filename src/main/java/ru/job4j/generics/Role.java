package ru.job4j.generics;

public class Role extends Base {
    String id = Double.toString(Math.random());

    public Role(String id) {
        super(id);
    }

    @Override
    public String getId() {
        return id;
    }
}