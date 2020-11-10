package ru.job4j.practice;
import java.util.*;
public class Analyze {

    public Info diff(List<User> previous, List<User> current) {
        Map<Integer, String> map = new HashMap<>();
        Info info = new Info();
        for (User user : previous) {
            map.put(user.getId(), user.getName());
        }
        for (User user : current) {
            String value = map.get(user.getId());
            if (value == null) {
                info.added++;
            } else if (!value.equals(user.getName())) {
                info.changed++;
            }
        }
        info.deleted = (previous.size() + info.added) - current.size();
        return info;
    }

    public static class User {

        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        //        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            User user = (User) o;
//            return id == user.id &&
//                    Objects.equals(name, user.name);
//        }

//        @Override
//        public int hashCode() {
//            return Objects.hash(id, name);
//        }
    }

    public static class Info {

        int added;
        int changed;
        int deleted;

        public Info() {
        }

        @Override
        public String toString() {
            return "Info{" + "added = " + added + ", changed = " + changed + ", deleted = " + deleted + '}';
        }
    }
}
