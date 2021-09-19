package utils;

import models.ToDoItem;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PrintView {
    public static void printMyView(int i , ToDoItem obj) {
        System.out.print((i+1) + ") [" );
        if (obj.isComplete()) {
            System.out.print("*");
        } else {
            System.out.print(" ");
        }
        System.out.println("] " + obj.getToDoText());
    }

    public static class ConnectionManager {
        private static Connection conn;

        private ConnectionManager() {

        }

        public static Connection getConnection() throws SQLException, IOException {
            if (conn == null) {
                Properties props = new Properties();
                FileReader connectionProperties = new FileReader("src/main/resources/connection.properties");
                props.load(connectionProperties);
                String connString = "jdbc:mariadb://" + props.getProperty("hostname") +  ":" + props.getProperty("port") + "/" + props.getProperty("databaseName") + "?user=" +
                        props.getProperty("user") + "&password=" + props.getProperty("password");
                conn = DriverManager.getConnection(connString);
            }
            return conn;
        }

    //    public static void main(String[] args) {
    //
    //        try {
    //            Properties props = new Properties();
    //            FileReader connectionProperties = new FileReader("src/main/resources/connection.properties");
    //            props.load(connectionProperties);
    //            String connString = "jdbc:mariadb://" + props.getProperty("hostname") + ":3306/" + props.getProperty("databaseName") + "?user=" +
    //                    props.getProperty("user") + "&password=" + props.getProperty("password");
    //            System.out.println(connString);
    //
    //        } catch (FileNotFoundException e) {
    //            e.printStackTrace();
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //
    //    }
    }
}
