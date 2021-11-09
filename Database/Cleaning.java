package Database;

import java.sql.*;
import java.sql.Connection;

class Cleaning extends DB_Main {

   Cleaning(String username, String password, String URL, String className){
        super(username, password, URL, className);
    }

    private static Connection con;

    private static Statement stmt;

    private static ResultSet rs;

    public void cleaning() throws ClassNotFoundException {
        Class.forName(className);
        String drop = "drop table people";
        String create = "create table people (\n" +
                "\tPersonID INTEGER AUTO_INCREMENT PRIMARY KEY, \n" +
                "\tname text, \n" +
                "\tsurname text,\n" +
                "    passport text,\n" +
                "    UID text\n" +
                " );";

        try {
            con = DriverManager.getConnection(URL, username, password);

            PreparedStatement prepStatDROPING = con.prepareStatement(drop);
            PreparedStatement prepStatCREATING = con.prepareStatement(create);

            prepStatDROPING.execute();
            System.out.println("dropped");
            prepStatCREATING.execute();
            System.out.println("created");
            con.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
