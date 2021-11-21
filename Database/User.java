package Database;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class User extends DB_Main {

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public User(String username, String password, String URL, String className ) {
        super(username, password, URL, className);

    }

    public void addingNewUser(String name, String surname, String passport){
        String addUserQuery = "insert into people (name, surname, passport, UID) values (?, ?, ?, ?)";

        try {
            con = DriverManager.getConnection(URL, username, password);

            PreparedStatement prepStatADDING = con.prepareStatement(addUserQuery);

            prepStatADDING.setString (1, name);
            prepStatADDING.setString (2, surname);
            prepStatADDING.setString (3, passport);
            prepStatADDING.setString (4, UID());

            prepStatADDING.execute();
            System.out.println("User added");

            con.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getAllUsers(){
        String getUsersQuery = "select name, surname, passport, UID from people";

        try {
            con = DriverManager.getConnection(URL, username, password);

            stmt = con.createStatement();

            rs = stmt.executeQuery(getUsersQuery);

            while (rs.next()) {
                String getName = rs.getString("name");
                String getSurname = rs.getString("surname");
                String getPassport = rs.getString("passport");
                String getUID = rs.getString("UID");
                ArrayList people = new ArrayList();

                System.out.println("Name: " + getName + ", Surname: " + getSurname + ", Passport: " + getPassport + ", UID: " + getUID );
            }
            con.close();
            stmt.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private String UID(){
        int random = (int) (Math.random()*10000+1000);
        return random + "";
    }

}
