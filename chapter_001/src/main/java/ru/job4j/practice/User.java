package ru.job4j.practice;

import java.util.*;

public class User {

   private Set<String> email = new HashSet<>();

    public void add(String email) {
        this.email.add(email);
    }

    public Set<String> getEmail() {
        return email;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(email, user.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(email);
//    }

    @Override
    public String toString() {
        return "{" +
                "email=" + email;
    }
}
