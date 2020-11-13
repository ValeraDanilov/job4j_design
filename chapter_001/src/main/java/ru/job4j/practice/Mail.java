package ru.job4j.practice;

import java.util.*;

public class Mail {

    public Map<String, User> checkEmailUser(Map<String, User> useMap) {
        Map<String, User> newUsers = new LinkedHashMap<>();
        Map<String, String> userEmail = new LinkedHashMap<>();
        for (String entry: useMap.keySet()) {
            Set<String> emails = useMap.get(entry).getEmail();
            String newKey = null;
            String oldKey = entry;
            for (String email: emails) {
                if (userEmail.containsKey(email)) {
                    newKey = userEmail.get(email);
                    break;
                }
            }
            if (newKey == null) {
                newUsers.put(entry, useMap.get(entry));
            } else {
                newUsers.get(newKey).getEmail().addAll(emails);
                oldKey = newKey;
            }
            for (String value: emails) {
                userEmail.put(value, oldKey);
            }
        }
        return newUsers;
    }
}

/*
    private Map<String, User> newUsers = new LinkedHashMap<>();

    public Map<String, User> checkEmailUser(Map<String, User> useMap) {
        boolean run = true;

        Iterator<Map.Entry<String, User>> itr = useMap.entrySet().iterator();
        Map.Entry<String, User> map = itr.next();
        Map<String, User> map1 = new LinkedHashMap<>(useMap);
        Iterator<Map.Entry<String, User>> it = map1.entrySet().iterator();

        while (run) {
            Map.Entry<String, User> map2 = it.next();
            if (gropingUser(map.getValue(), map2.getValue(), map.getKey())) {
                it.remove();
            }
            if (!it.hasNext()) {
                map = itr.next();
                it = map1.entrySet().iterator();
            }
            if (!itr.hasNext() || map1.size() == 0) {
                if (map1.size() != 0) {
                    newUsers.putAll(map1);
                }
                run = false;
            }
        }
        return this.newUsers;
    }

    private boolean gropingUser(User first, User second, String user) {
        boolean result = false;
        for (String value : second.getEmail()) {
            if (first.getEmail().contains(value)) {
                first.getEmail().addAll(second.getEmail());
                this.newUsers.put(user, first);
                result = true;
                break;
            }
        }
        return result;
    }
 */
