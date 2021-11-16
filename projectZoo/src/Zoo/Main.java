package Zoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import Database.DB_Main;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Scanner sc = new Scanner(System.in);


    static RandomQuantity random = new RandomQuantity();
    static int randomQuant = random.random();

    static String[] names = {"Shapito", "Karamel", "Cucumber", "Dolce i Kaban", "Winni Duck"};
    static String[] locations = {"l`viv", "Taraso-Shevchenkivsk", "Old York", "Riznutsi", "Odessa-dad", "Pryamovo"};
    static Zoo first = new Zoo(names, locations, 50, randomQuant);

    static int answer = -1;
//_______________________________________________________________________
    public static void main(String[] args) throws InterruptedException, IOException, ParseException,
            ClassNotFoundException, SQLException {
        Event e = new Event("First stage", "Outside", "Recruiting people");
        Main m = new Main();

        final String URL = "jdbc:mysql://localhost:3306/projectZoo";
        final String className = "com.mysql.cj.jdbc.Driver";

        System.out.print("Username: ");
        String username = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        DB_Main database = new DB_Main(username, password, URL, className);
        database.TestConnection();
        //comment next line after first start
        database.firstEntry();
        database.Cleaning();
        m.choosing(database);

//        e.theFirstStage();
    }
 
    protected void menu(){
 
        System.out.println("You`re calling to Zoo. What do you want to find out or do?"); 
        System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]; Buy a ticket[5]"); 
 
        exepts(); 
 
    } 
 
    void info() {
        String a = null;
        try {
            a = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert a != null;
        answer = Integer.parseInt(a);
        if (answer > Const.maxAnswerLimit | answer < Const.minAnswerLimit) {
            exceptToString();
            exepts();
        }else{

            if(answer == 1){
                  first.answerEqw1();
                System.out.println("Would you like to ask something more?[y/n]");
                reattemp();
            } else if(answer == 2){
                first.answerEqw2();
                System.out.println("Would you like to ask something more?[y/n]");
                reattemp();
            } if(answer == 3){
                first.answerEqw3();
                System.out.println("Would you like to ask something more?[y/n]");
                reattemp();
            } else if(answer == 4){
                first.answerEqw4();
                System.out.println("Would you like to ask something more?[y/n]");
                reattemp();
            } else if(answer == 5)
                first.answerEqw5();
        }
    }
 
    void exepts(){ 
        try { 
            info(); 
        }catch(Exception e){ 
            exceptToString();
            exepts(); 
        } 
    } 
 
    void reattemp(){
        String b = null;
        try {
            b = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        b = b.toLowerCase();
        if(b.equals("y")){ 
            System.out.println(); 
            System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]; Buy a ticket[5];"); 
            exepts(); 
        }else if (b.equals("n")){}
            else{
                System.out.println("Type \"y\" or \"n\""); 
                reattemp(); 
            }
    } 
 
    void exceptToString(){
        System.err.println("Type only 1, 2, 3 or 4"); 
        System.out.println(); 
        System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]"); 
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