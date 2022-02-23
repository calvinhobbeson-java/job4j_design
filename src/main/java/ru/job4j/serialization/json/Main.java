package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Trader trader = new Trader(46, new Login("Nguen@gmail.com"),
                new String[]{"freeTrader", "VIP", "HighVIP"},
                true);

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(trader));
        final String traderJson = gson.toJson(trader);

        final Trader traderMod = gson.fromJson(traderJson, Trader.class);
        System.out.println(traderMod);
    }
}
