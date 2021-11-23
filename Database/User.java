package Database;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;

public class User extends DB_Main {

    public void addNewUser(String name, String surname, String passport){
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

    public void removeUser(String name, String UID){
        String removing =   "delete from people " +
                            " where UID = ? AND name = ? ;";
        try {
            con = DriverManager.getConnection(URL, username, password);
            PreparedStatement prepStatREMOVING = con.prepareStatement(removing);

            prepStatREMOVING.setString(1, UID);
            prepStatREMOVING.setString(2, name);
            prepStatREMOVING.execute();
            System.out.println("User \""+name+"\" with UID:"+UID+" removed");
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
