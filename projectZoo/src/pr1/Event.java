package pr1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Event {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Zoo z = new Zoo();
    Main m = new Main();
    Person p = new Person();

    enum EventEnum {
        NAME,
        LOCATION,
        TYPE;
    }

    static String name;
    static String location;
    static String type;

    Event(String name, String location, String type) {
        this.name = name;
        this.location = location;
        this.type = type;
    }

    void theFirstStage() throws ParseException {
        if(z.quantityOfTickets == 0){
            System.out.println("Sorry,show has already started, there is no tickets left for you, too(" +
                    "If you want, you can wait a couple of hours, thought...");
        }
        else if(Zoo.quantityOfTickets <= 5){
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

    void noNeedToHurry() {
        int answer = 0;
        try {
            answer = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (answer == 1){
            z.buyTicket();
        }
        else if (answer == 2){
            m.menu();
        }
        else{
            System.err.println("Please, enter 1 or 2");
            noNeedToHurry();
        }
    }

    void buyTicketNow() throws ParseException {
        String answer = null;
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
