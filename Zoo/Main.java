package Zoo;

import Database.DB_Main;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        final String URL = "jdbc:mysql://localhost:3306/projectZoo";
        final String className = "com.mysql.cj.jdbc.Driver";

        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        DB_Main database = new DB_Main(username, password, URL, className);
        database.TestConnection();
        //comment next line after first start
//        database.firstEntry();
        database.Cleaning();


        Main m = new Main();
       m.choosing(database);



    }

    private void choosing(DB_Main database){
        System.out.println("Add user[1], Get all users[2], Exit[3]");
        int number = sc.nextInt();
        if (number == 1){
            System.out.println("Name: ");
            String name = sc.next();
            System.out.println("Surname: ");
            String surname = sc.next();
            System.out.println("Passport: ");
            String passport = sc.next();
            database.addNewUser(name, surname, passport);
            choosing(database);
            
        }
        else if (number == 2 )
        {
            database.getAllPeople();
            choosing(database);
        }else{
            System.exit(-1);
        }



    }


}
