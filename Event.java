package Zoo;

import java.text.ParseException;
import java.util.Scanner;

public class Event extends Main {
    Scanner sc = new Scanner(System.in);
    Zoo z = new Zoo();
    Person p = new Person();

    enum EventEnum {
        NAME,
        LOCATION,
        TYPE;
    }

    static String name;
    static String location;
    static String type;
    Person h = new Person();

    Event(String name, String location, String type) {
        this.name = name;
        this.location = location;
        this.type = type;
    }

    void theFirstStage() throws ParseException {
        if(Zoo.quantity == 0){
            System.out.println("Sorry,show has already started, there is no tickets left for you, too(" +
                    "If you want, you can wait a couple of hours, thought...");
        }
        else if(Zoo.quantity<=5){
            z.setVisitorsList(); //створення уявних відвідувачів, що вже купили квиток
            System.out.println("Oh, you're right on time! The show is nearly going to start. Would you like " +
                    "to buy a ticket right now?[Y/N]");
            buyTicketNow();
        }
        else{
            z.setVisitorsList(); //створення уявних відвідувачів, що вже купили квиток
            System.out.println("No need in hurry! We're just preparing to start a show. Do you want to " +
                    "buy a ticket[1] or maybe you have some questions[2]?");
            noNeedToHurry();
        }

    }

    void noNeedToHurry() throws ParseException {
        int answer = sc.nextInt();
        if (answer == 1){
            z.buyTicket();
        }
        else if (answer == 2){
            z.menu();
        }
        else{
            System.err.println("Please, enter 1 or 2");
            noNeedToHurry();
        }
    }

    void buyTicketNow() throws ParseException {
        String answer = sc.nextLine();
        answer = answer.toLowerCase();
        if (answer.equals("y")){
            z.buyTicket();
        }
        else if (answer.equals("n")){
            System.out.println("So you've come here just to find out, that the show hasn't started " +
                    "yet? That's weird...ANYWAY, we'll wait your visit again!");
        }
        else{
            System.out.println("Please enter [Y/N]");
            buyTicketNow();
        }
    }

}
