package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            try (InputStream io = TableEditor.class.getClassLoader().getResourceAsStream("./app.properties")) {
                this.properties.load(io);
            }
            this.connection = DriverManager.getConnection(this.properties.getProperty("url"), this.properties.getProperty("login"), this.properties.getProperty("password"));
        } catch (SQLException | ClassNotFoundException | IOException eo) {
            eo.printStackTrace();
        }
    }

    private void execute(String value) {
        try (Statement statement = this.connection.createStatement()) {
            statement.execute(value);

        } catch (SQLException eo) {
            eo.printStackTrace();
        }
    }

    public void createTable(String tableName) {
        String table = String.format("create table if not exists %s%s", tableName, "();");
        execute(table);

    }

    public void dropTable(String tableName) {
        String table = String.format("drop table %s%s", tableName, ";");
        execute(table);

    }

    public void addColumn(String tableName, String columnName, String type) {
        String table = String.format("alter table %s%s%s%s%s", tableName, " add column ", columnName, " ", type);
        execute(table);
    }

    public void dropColumn(String tableName, String columnName) {
        String table = String.format("alter table %s%s%s%s", tableName, " drop column ", columnName, ";");
        execute(table);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String table = String.format("alter table %s%s%s%s%s%s", tableName, " rename column ", columnName, " to ", newColumnName, ";");
        execute(table);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = this.connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }
}
