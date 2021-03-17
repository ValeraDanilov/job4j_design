package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Setting st = new Setting();
        ClassLoader cl = Setting.class.getClassLoader();
        try (InputStream io = cl.getResourceAsStream("./app.properties")) {
            st.load(io);
        }
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(st.getValue("url"), st.getValue("login"), st.getValue("password"))) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
