package Zoo;

import Database.DB_Main;
import Database.UserManager;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static RandomQuantity random = new RandomQuantity();
    static int randomQuant = random.random();

    static String names[] = {"Shapito", "Karamel", "Cucumber", "Dolce i Kaban", "Winni Duck"};
    static String locations[]= {"l`viv", "Taraso-Shevchenkivsk", "Old York", "Riznutsi", "Odessa-dad", "Pryamovo"};

    static Zoo first = new Zoo(names, locations, 50, randomQuant);
    static UserManager userManager = new UserManager();
    static Main m = new Main();


    static int answer = -1;


    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        final String URL = "jdbc:mysql://localhost:3306/projectZoo";
        final String className = "com.mysql.cj.jdbc.Driver";

        String username = null;
        String password = null;
        try {
            System.out.print("Username: ");
            username = br.readLine();
            System.out.print("Password: ");
            password = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        DB_Main database = new DB_Main(username, password, URL, className);
        database.testConnection();

        ArrayList locations = database.getZooWhereIsAnimal("Doxy");
        System.out.println(locations);

//        database.Cleaning();
//        database.firstEntry();
        try {
            choosing(database);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Welcome to our Zoo");
        m.menu();
    }

    static int i=0;

    public static void choosing(DB_Main database) throws IOException {
        System.out.println("Add user[1], Get all users[2], Remove user[3], Exit(default)");
        String numOfAnswer = br.readLine();

        if (numOfAnswer.equals("1")){
            userManager.setUser(database);
            choosing(database);
        }
        else if (numOfAnswer.equals("2"))
        {
            database.getAllPeople();
            choosing(database);
        }
        else if(numOfAnswer.equals("3")){
            database.removingUser(
                    userManager.removeUserName(database),
                    userManager.removeUserUID(database));

            choosing(database);
        }else{
            m.menu();
        }
    }



    void menu(){

        System.out.println("Hi! You`re calling to Zoo. What do you want to find out?");
        System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]; Buy a ticket[5]");

        exepts();

    }

    void info() throws IOException {
        String a = br.readLine();
        answer = Integer.parseInt(a);
        if (answer > 5 | answer < 1) {
            exeptToString();
            exepts();
        }else{

            if(answer == 1){
                first.answerEqw1();
            } else if(answer == 2){
                first.answerEqw2();
            } if(answer == 3){
                first.answerEqw3();
            } else if(answer == 4){
                first.answerEqw4();
            } else if(answer == 5){
                first.buyTicket();
                randomQuant = first.quantityOfTickets;
                first = new Zoo(names, locations, 50, randomQuant);


            }
            System.out.println("Would you like to ask something more?[y/n]");
            reattemp();

        }
    }

    void exepts(){
        try {
            info();
        }catch(Exception e){
            exeptToString();
            exepts();
        }
    }

    void reattemp() throws IOException {
        String b = br.readLine();
        b.toLowerCase();
        if(b.equals("y")){
            System.out.println();
            System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]; Buy a ticket[5]");
            exepts();
        }else if (b.equals("n")){System.exit(-20);}
        else{
            System.out.println("Type \"y\" or \"n\"");
            reattemp();
        }
    }

    void exeptToString(){
        System.err.println("Type only 1, 2, 3, 4 or 5");
        System.out.println();
        System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]; Buy a ticket[5]");
    }

}
