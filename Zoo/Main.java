package Zoo;

import Database.DB_Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static RandomQuantity random = new RandomQuantity();
    static int randomQuant = random.random();

    Ticket ticketBuy = new Ticket(randomQuant);

    static String names[] = {"Shapito", "Karamel", "Cucumber", "Dolce i Kaban", "Winni Duck"};
    static String locations[]= {"l`viv", "Taraso-Shevchenkivsk", "Old York", "Riznutsi", "Odessa-dad", "Pryamovo"};

    static Zoo first = new Zoo(names, locations, 50, randomQuant);

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
        Main m = new Main();
        try {
            m.choosing(database);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(first.toString());

        System.out.println("Welcome to our Zoo");

        m.phoneCall();



    }

    private void choosing(DB_Main database) throws IOException {
        System.out.println("Add user[1], Get all users[2], Remove user[3], Exit(default)");
        String number = br.readLine();
        if (number.equals("1")){
            System.out.print("Name: ");
            String name = br.readLine();
            System.out.print("Surname: ");
            String surname = br.readLine();
            System.out.print("Passport: ");
            String passport = br.readLine();;
            database.addNewUser(name, surname, passport);
            choosing(database);
            
        }
        else if (number.equals("2"))
        {
            database.getAllPeople();
            choosing(database);
        }
        else if(number.equals("3")){
            System.out.print("Name: ");
            String name = br.readLine();;
            System.out.print("UID: ");
            String UID = br.readLine();;
            database.removingUser(name, UID);
            choosing(database);
        }else{
            phoneCall();

        }



    }

    void phoneCall(){

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
                ticketBuy.buyTicket();
                randomQuant = ticketBuy.quantityOfTickets;
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
