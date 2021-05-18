package com.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Launcher {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/nau";
        String userName = "root";
        String password = "root";
        System.out.println("Connecting...");

        try (Connection connection = DriverManager.getConnection(url, userName, password)){
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

    }
}