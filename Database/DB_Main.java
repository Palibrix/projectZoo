package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB_Main {
    static String username, password, URL, className;
    static java.sql.Connection con;
    static Statement stmt;
    static ResultSet rs;

    public DB_Main(){}
    public DB_Main(String username, String password, String URL, String className){
        this.username = username;
        this.password = password;
        this.URL = URL;
        this.className = className;
    }

    private static Action action = new Action();
    private static User user= new User();
    private static InitializationDB inDB = new InitializationDB();
    private static Cleaning cleaning = new Cleaning();

    public void testConnection(){
        Connection testConnection = new Connection(username, password, URL, className);
        testConnection.getConnection();
    }

    public void Cleaning(){
        try {
            cleaning.cleaning();
        }catch (Exception e){
        }
    }

    public void addNewUser(String name, String surname, String passport){
        user.addNewUser(name, surname, passport);
    }

    public void getAllPeople(){
        user.getAllUsers();
    }

    public void firstEntry() throws ClassNotFoundException, SQLException {
        inDB.peopleTable();
        inDB.zooTable();
        inDB.animalsTable();
        inDB.citiesTable();

    }

    public void removingUser(String name, String UID){
        user.removeUser(name, UID);
    }

    public ArrayList getZooWhereIsAnimal(String name){
        ArrayList locations = action.getZooWhereIsAnimal(name);
        return locations;
    };

}
