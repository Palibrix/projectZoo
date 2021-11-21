package Database;

import java.sql.SQLException;

public class DB_Main {
    String username, password, URL, className;

    public DB_Main(){}

    public DB_Main(String username, String password, String URL, String className){
        this.username = username;
        this.password = password;
        this.URL = URL;
        this.className = className;
    }

    public void TestConnection(){
        Connection test = new Connection(username, password, URL, className);
        test.getConnection();
    }

    public void Cleaning(){
        Cleaning cleaning = new Cleaning(username, password, URL, className);
        try {
            cleaning.cleaning();
        }catch (Exception e){
        }
    }

    public void addNewUser(String name, String surname, String passport){
        User userOne = new User(username, password, URL, className);
        userOne.addingNewUser(name, surname, passport);
    }

    public void getAllPeople(){
        User userOne = new User(username, password, URL, className);
        userOne.getAllUsers();
    }

    public void firstEntry() throws ClassNotFoundException, SQLException {
        InitializationDB inDB = new InitializationDB(username, password, URL, className);
        inDB.peopleTable();
        inDB.zooTable();
        inDB.animalsTable();
        inDB.citiesTable();

    }

    public void removingUser(String name, String UID){
        User userOne = new User(username, password, URL, className);
        userOne.removeUser(name, UID);
    }

}
