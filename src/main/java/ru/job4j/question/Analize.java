package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, User> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.getId(), user);
        }
        for (User user2 : current) {
            if (!map.containsKey(user2.getId())) {
                info.setAdded(info.getAdded() + 1);
            }
            if (!Objects.equals(map.get(user2.getId()), user2)) {
                info.setChanged(info.getChanged() + 1);
            }
            map.remove(user2.getId());
        }

        info.setDeleted(map.size());
        return info;
    }
}