package Database;

import java.sql.*;
import java.sql.Connection;

public class InitializationDB extends DB_Main {

    InitializationDB(String username, String password, String URL, String className){
        super(username, password, URL, className);
    }

    private static Connection con;

    public void peopleTable() throws ClassNotFoundException {
        Class.forName(className);
        String create = "create table people (\n" +
                "\tPersonID INTEGER AUTO_INCREMENT PRIMARY KEY, \n" +
                "\tname text, \n" +
                "\tsurname text,\n" +
                "    passport text,\n" +
                "    UID text\n" +
                " );";
        try {
            con = DriverManager.getConnection(URL, username, password);

            PreparedStatement prepStatCREATING = con.prepareStatement(create);

            prepStatCREATING.execute();
            System.out.println("Table \"people\" created");
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void zooTable() throws ClassNotFoundException {
        Class.forName(className);
        String create = "create table zoo (\n" +
                "\tzooID INTEGER AUTO_INCREMENT PRIMARY KEY, \n" +
                "\tname text\n" +
                " );";
        try {
            con = DriverManager.getConnection(URL, username, password);

            PreparedStatement prepStatCREATING = con.prepareStatement(create);

            prepStatCREATING.execute();
            System.out.println("Table \"zoo\" created");
            zooTableFilling();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void zooTableFilling() throws SQLException, ClassNotFoundException {
        Class.forName(className);
        con = DriverManager.getConnection(URL, username, password);

        String addZoo = "insert into zoo (name) value (?);";

        String mas[] = {"Shapito", "karamel", "Cucumber", "Dolce i Kaban", "Winni Duck"};

        PreparedStatement prepStatINSERT = con.prepareStatement(addZoo);

        for (String zoo: mas) {
            prepStatINSERT.setString(1, zoo);
            prepStatINSERT.execute();
        }
        System.out.println("All \"Zoo\" names inserted");
        con.close();
    }

    public void animalsTable() throws ClassNotFoundException {
        Class.forName(className);
        String create = "create table animals(\n" +
                        "\tname text,\n" +
                        "    zooID int,\n" +
                        "    Foreign key (zooID) references zoo(zooID)\n" +
                        "    );";

        try {
            con = DriverManager.getConnection(URL, username, password);

            PreparedStatement prepStatCREATING = con.prepareStatement(create);

            prepStatCREATING.execute();
            System.out.println("Table \"animals\" created");
            animalsTableFilling();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void animalsTableFilling() throws SQLException, ClassNotFoundException {
        Class.forName(className);
        con = DriverManager.getConnection(URL, username, password);

        String addAnimal_1_1 = "insert into animals (name, zooID) value (\"Billywiq\", 2);";
        String addAnimal_1_2 = "insert into animals (name, zooID) value (\"Billywiq\", 3);";

        String addAnimal_2_1 = "insert into animals (name, zooID) value (\"Bowtruckle\", 1);";
        String addAnimal_2_2 = "insert into animals (name, zooID) value (\"Bowtruckle\", 3);";
        String addAnimal_2_3 = "insert into animals (name, zooID) value (\"Bowtruckle\", 4);";

        String addAnimal_3_1 = "insert into animals (name, zooID) value (\"Demiguise\", 2);";
        String addAnimal_3_2 = "insert into animals (name, zooID) value (\"Demiguise\", 3);";
        String addAnimal_3_3 = "insert into animals (name, zooID) value (\"Demiguise\", 4);";
        String addAnimal_3_4 = "insert into animals (name, zooID) value (\"Demiguise\", 5);";

        String addAnimal_4_1 = "insert into animals (name, zooID) value (\"Diricawl\", 1);";
        String addAnimal_4_2 = "insert into animals (name, zooID) value (\"Diricawl\", 5);";

        String addAnimal_5_1 = "insert into animals (name, zooID) value (\"Doxy\", 2);";
        String addAnimal_5_2 = "insert into animals (name, zooID) value (\"Doxy\", 4);";

        String addAnimal_6_1 = "insert into animals (name, zooID) value (\"Erumpant\", 3);";

        String addAnimal_7_1 = "insert into animals (name, zooID) value (\"Nundu\", 1);";
        String addAnimal_7_2 = "insert into animals (name, zooID) value (\"Nundu\", 4);";
        String addAnimal_7_3 = "insert into animals (name, zooID) value (\"Nundu\", 5);";

        String addAnimal_8_1 = "insert into animals (name, zooID) value (\"Murtlap\", 2);";
        String addAnimal_8_2 = "insert into animals (name, zooID) value (\"Murtlap\", 5);";

        String mas[] = {addAnimal_1_1, addAnimal_1_2,
                        addAnimal_2_1, addAnimal_2_2, addAnimal_2_3,
                        addAnimal_3_1, addAnimal_3_2, addAnimal_3_3, addAnimal_3_4,
                        addAnimal_4_1, addAnimal_4_2,
                        addAnimal_5_1, addAnimal_5_2,
                        addAnimal_6_1,
                        addAnimal_7_1, addAnimal_7_2, addAnimal_7_3,
                        addAnimal_8_1, addAnimal_8_2
                        };

        for (String animal: mas) {
            PreparedStatement prepStatINSERT = con.prepareStatement(animal);
            prepStatINSERT.execute();
        }

        System.out.println("All \"Animals\" names inserted");
        con.close();
    }

    public void citiesTable() throws SQLException, ClassNotFoundException{
        Class.forName(className);
        String create = "create table cities(\n" +
                "    name text,\n" +
                "    zooID int,\n" +
                "    Foreign key (zooID) references zoo(zooID)\n" +
                "    );";

        con = DriverManager.getConnection(URL, username, password);
        PreparedStatement prepStatCREATING = con.prepareStatement(create);
        prepStatCREATING.execute();
        System.out.println("Table \"cities\" created");
        citiesTableFilling();
        con.close();

    }

    private void citiesTableFilling() throws SQLException, ClassNotFoundException{
        Class.forName(className);
        con = DriverManager.getConnection(URL, username, password);
        String addCity_1_1 = "insert into cities (name, zooID) values (\"L`viv\", 2)";
        String addCity_1_2 = "insert into cities (name, zooID) values (\"L`viv\", 4)";

        String addCity_2_1 = "insert into cities values (\"Taraso-Shevchenkivsk\", 1)";
        String addCity_2_2 = "insert into cities values (\"Taraso-Shevchenkivsk\", 3)";
        String addCity_2_3 = "insert into cities values (\"Taraso-Shevchenkivsk\", 5)";

        String addCity_3_1 = "insert into cities values (\"Old York\", 1)";
        String addCity_3_2 = "insert into cities values (\"Old York\", 2)";
        String addCity_3_3 = "insert into cities values (\"Old York\", 3)";
        String addCity_3_4 = "insert into cities values (\"Old York\", 4)";

        String addCity_4_1 = "insert into cities values (\"Riznutsi\", 1)";
        String addCity_4_2 = "insert into cities values (\"Riznutsi\", 4)";

        String addCity_5_1 = "insert into cities values (\"Odessa-dad\", 2)";
        String addCity_5_2 = "insert into cities values (\"Odessa-dad\", 3)";

        String addCity_6_1 = "insert into cities values (\"Pryamovo\", 5)";

        String mas[] = {addCity_1_1, addCity_1_2,
                        addCity_2_1, addCity_2_2, addCity_2_3,
                        addCity_3_1, addCity_3_2, addCity_3_3, addCity_3_4,
                        addCity_4_1, addCity_4_2,
                        addCity_5_1, addCity_5_2,
                        addCity_6_1
        };

        for (String city : mas) {
            PreparedStatement prepStatINSERT = con.prepareStatement(city);
            prepStatINSERT.execute();
        }
        System.out.println("All \"Cities\" names inserted");
        con.close();

    }

}
