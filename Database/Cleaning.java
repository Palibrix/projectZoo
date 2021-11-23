package Database;

import java.sql.*;
import java.sql.Connection;

class Cleaning extends DB_Main {

    private static Connection con;

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
