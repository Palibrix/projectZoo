package Zoo;

//import Database.Cleaning;
//import Database.Connection;
import Database.DB_Main;


import java.util.Scanner;

public class Main {



    public static void main(String args[]){
        final String URL = "jdbc:mysql://localhost:3306/projectZoo";
        final String className = "com.mysql.cj.jdbc.Driver";

        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        DB_Main database = new DB_Main(username, password, URL, className);
        database.TestConnection();
        database.Cleaning();

// creating UID, future plans
//        for (int i = 0; i<30; i++){
//            int random = (int) (Math.random()*10000+1000);
//            System.out.println(random);
//        }


    }

}
