package Zoo;

import Database.DB_Main;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static RandomQuantity random = new RandomQuantity();
    static int randomQuant = random.random();

    Ticket ticketBuy = new Ticket(randomQuant);

    static String names[] = {"Shapito", "Karamel", "Cucumber", "Dolce i Kaban", "Winni Duck"};
    static String locations[]= {"l`viv", "Taraso-Shevchenkivsk", "Old York", "Riznutsi", "Odessa-dad", "Pryamovo"};

    static Zoo first = new Zoo(names, locations, 50, randomQuant);

    static int answer = -1;


    public static void main(String args[]) throws ClassNotFoundException, SQLException, InterruptedException {
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
//        database.Cleaning();

        Main m = new Main();
        m.choosing(database);

        System.out.println(first.toString());

        System.out.println("Welcome to our Zoo");

        m.phoneCall();



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
            phoneCall();

        }



    }


    void phoneCall(){

        System.out.println("Hi! You`re calling to Zoo. What do you want to find out?");
        System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]; Buy a ticket[5]");

        exepts();

    }

    void info(){
        String a = sc.nextLine();
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

    void reattemp(){
        String b = sc.nextLine();
        b.toLowerCase();
        if(b.equals("y")){
            System.out.println();
            System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]; Buy a ticket[5]");
            exepts();
        }else if (b.equals("n")){}
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
