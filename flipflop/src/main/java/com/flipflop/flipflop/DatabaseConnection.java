package com.flipflop.flipflop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.JDBC.*;

public class DatabaseConnection {
    public Connection databaseLink;
    public Connection getDatabaseConnection() {
        String url = "jdbc:sqlite:/Users/drmadhushan/Documents/dev/flipflop_project/flipflop/src/main/resources/com/flipflop/flipflop/db/flipfloptest.db";
        try {
            databaseLink = DriverManager.getConnection(url);
            System.out.println("Connected to DB!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
}
