package ru.job4j.serialization.json;

public class Trader {

    private final int id;
    private final Login login;
    private final String[] statuses;
    private boolean isActive;

    public Trader(int id, Login login, String[] statuses, boolean isActive) {
        this.id = id;
        this.login = login;
        this.statuses = statuses;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public Login getLogin() {
        return login;
    }

    public String[] getStatuses() {
        return statuses;
    }

    public boolean isActive() {
        return isActive;
    }
}