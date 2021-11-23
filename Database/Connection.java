package Database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    String user, password, URL, className;
    java.sql.Connection connection;

    public Connection(String user, String password, String URL, String className) {
        this.user = user;
        this.password = password;
        this.URL = URL;
        this.className = className;
        this.connection = null;
    }


    public void getConnection() {
        try {
            Class.forName(className);
            System.out.println("Driver successfully loaded");
        } catch (ClassNotFoundException ex) {
            System.out.println("Unable to load the class. Terminating the program");
            System.exit(-1);
        }

        try {
            connection = DriverManager.getConnection(URL, user, password);
            System.out.println("Successfully connected");
        } catch (SQLException ex) {
            System.out.println("Error getting connection: " + ex.getMessage());
            System.exit(-1);
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            System.exit(-1);
        }
    }

}
