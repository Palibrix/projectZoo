package Database;

import Zoo.Check;

import java.io.IOException;
import java.sql.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UserManager extends DB_Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Check check = new Check();

    private String setUserName(DB_Main database){
        System.out.print("Name: ");
        String name = null;

        try {
            name = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (name == null){
            setUserName(database);
        }

        if(!check.firstLetterIsUp(name)){
            System.out.println("Please enter your name with a capital letter");
            setUserName(database);
        }
        return name;
    }

    private String setUserSurname(DB_Main database){
        System.out.print("Surname: ");
        String surname = null;

        try {
            surname = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (surname == null){
            setUserName(database);
        }

        if(!check.firstLetterIsUp(surname)){
            System.out.println("Please enter your surname with a capital letter");
            setUserSurname(database);
        }
        return surname;
    }

    private String setUserPassport(DB_Main database){
        System.out.print("Passport [CExxxxCE]: ");
        String passport = null;

        try {
            passport = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (passport == null){
            setUserName(database);
        }
        else if (passport.charAt(0) != 'C' || passport.charAt(1) != 'E' ||
                passport.charAt(6) != 'C' || passport.charAt(7) != 'E'){
            System.out.println("Please enter your passport, using [CExxxxCE] format");
            setUserPassport(database);
        }

        return passport;
    }

    public String removeUserName(DB_Main database) {
        System.out.print("Name: ");
        String removeName = null;

        try {
            removeName = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!check.firstLetterIsUp(removeName)){
            System.out.println("Please enter the name with a capital letter");
            removeUserName(database);
        }

        return removeName;
    }

    public String removeUserUID(DB_Main database){
        System.out.print("UID: ");
        String removeUID = null;

        try {
            removeUID = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (removeUID == null){
            System.out.println("Please enter valid UID");
            removeUserUID(database);
        }

        return removeUID;
    }

    public void setUser(DB_Main database) throws IOException {
        database.addNewUser(
                setUserName(database),
                setUserSurname(database),
                setUserPassport(database));
    }

    public void addNewUser(String name, String surname, String passport){
        String addUserQuery = "insert into people (name, surname, passport, UID) values (?, ?, ?, ?)";

        try {
            con = DriverManager.getConnection(URL, username, password);

            PreparedStatement prepStatADDING = con.prepareStatement(addUserQuery);

            prepStatADDING.setString (1, name);
            prepStatADDING.setString (2, surname);
            prepStatADDING.setString (3, passport);
            prepStatADDING.setString (4, UID());

//Something is wrong here. setUser func is being called twice. Only second input is written down.

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
