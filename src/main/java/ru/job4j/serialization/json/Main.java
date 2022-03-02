package ru.job4j.serialization.json;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {

        Trader trader = new Trader(46, new Login("Nguen@gmail.com"),
                new String[]{"freeTrader", "VIP", "HighVIP"},
                true);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", trader.getId());
        jsonObject.put("login", trader.getLogin());
        jsonObject.put("statuses", trader.getStatuses());
        jsonObject.put("is active", trader.isActive());

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(trader).toString());
    }
}