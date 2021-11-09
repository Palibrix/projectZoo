package Database;

public class DB_Main {
    String username, password;

    String URL, className;

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


}
