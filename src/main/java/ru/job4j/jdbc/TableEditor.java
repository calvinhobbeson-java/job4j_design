package ru.job4j.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;
    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName(properties.getProperty("driver"));
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
    }

    public void makeStatement(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws Exception {
            String sql = String.format("create table if not exists %s();", tableName);
            makeStatement(sql);
    }

    public void dropTable(String tableName) throws Exception {
            String sql = String.format("drop table if exists %s;", tableName);
            makeStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
            String sql = String.format("alter table %s add column %s %s;", tableName, columnName, type);
            makeStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
            String sql = String.format("alter table %s drop column %s;", tableName, columnName);
            makeStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
            String sql = String.format("alter table %s rename column %s to %s;", tableName, columnName, newColumnName);
            makeStatement(sql);
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(in);
            TableEditor tableEditor = new TableEditor(properties);
            tableEditor.createTable("test");
            System.out.println(getTableScheme(tableEditor.connection, "test"));
            tableEditor.addColumn("test", "test1", "text");
            System.out.println(getTableScheme(tableEditor.connection, "test"));
            tableEditor.renameColumn("test", "test1", "test2");
            System.out.println(getTableScheme(tableEditor.connection, "test"));
            tableEditor.dropColumn("test", "test2");
            System.out.println(getTableScheme(tableEditor.connection, "test"));
            tableEditor.dropTable("test");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}