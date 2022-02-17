package com.revature.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public  class ConnectionUtil {

    private static Connection conn;
    private ConnectionUtil(){

    }

    public static Connection getConnection() {

        try{
            FileInputStream propertiesInput = new FileInputStream("C:\\Revature\\sql.properties");

            Properties props = new Properties();
            props.load(propertiesInput);

            String url = (String) props.get("url");
            String username = (String) props.get("username");
            String password = (String) props.get("password");

            if(conn == conn){
                try {
                    conn = DriverManager.getConnection(url, username, password);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
