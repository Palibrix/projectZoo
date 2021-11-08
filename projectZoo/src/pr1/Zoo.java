package pr1; 
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Zoo extends Main{ 
 
    String name[]; 
    String location[]; 
    int price; static int quantity; 
 
    RandomQuantity random = new RandomQuantity();
    Person p = new Person();

    int rdName = random.rdName(); 
    int rdLoc1 = random.rdLocation(); 
    int rdLoc2 = random.rdLocation(); 
 
    Zoo(){} 
    Zoo(String name[], String location[], int price, int quantity){ 
        this.name = name; 
        this.location = location; 
        this.price = price; 
        this.quantity = quantity; 
    }
 
    void announce() throws InterruptedException { 
        int i; 
        System.out.println("Our Zoo opens in...");
 
        for(i=5;i >= 0 ;i--){ 
            System.out.println(i + " seconds"); 
            Thread.sleep(1000); 
        }
        System.out.println("Have fun!");
    } 
 
    void answerEqw1(){ 
        System.out.println(quantity + " ticket(s) left"); 
    } 
 
    void answerEqw2(){ 
        System.out.println("Tickets price: " + price + "₴"); 
    } 
 
    void answerEqw3(){ 
        System.out.println(name[rdName]); 
    } 
 
    void answerEqw4(){ 
        while(rdLoc1 == rdLoc2){ 
            rdLoc2 = random.rdLocation(); 
        } 
        System.out.println("We have our Zoo in " + location[rdLoc1] +" and " + location[rdLoc2]); 
    } 
 
    void answerEqw5() throws ParseException {
        buyTicket(); 
    }

    void buyTicket() throws ParseException {
        Scanner sc = new Scanner(System.in);
        Person p = new Person();
        Zoo z = new Zoo();

        System.out.println("Now let's take some notes!");
        z.getInfo();

        if(p.age < 18){
            System.out.println("Sorry, dude, you're not allowed to take a part in this show");
        }else {
            System.out.println("Enter the number of tickets you want to buy!");
            int numOfBuyTickets = sc.nextInt();

            if (numOfBuyTickets > quantity) {
                System.out.println("We don't have so many tickets already! Would you like to buy some less?");
                buyTicket();
            } else if (numOfBuyTickets == 0) {
                System.out.println("Uhh...Have you changed you're mind?[y/n]");
                mindChanging();
            } else if (numOfBuyTickets < 0) {
                System.out.println("That's not serious...");
                buyTicket();
            } else {
                System.out.println("There was " + quantity + " tickets");
                quantity = quantity - numOfBuyTickets;
                System.out.println("And now there is " + quantity + " of them");
                System.out.println("You've bought " + numOfBuyTickets + " ticket(s). Thank you and have fun!");
                try {
                    first.announce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void mindChanging() throws ParseException {
        Scanner sc = new Scanner(System.in);
        String buyAnswer = sc.nextLine();
        buyAnswer = buyAnswer.toLowerCase();
        if(buyAnswer.equals("y")){
            menu();
        }else if(buyAnswer.equals("n")){
            buyTicket();
        }else{
            System.out.println("Please enter [Y/N]");
            mindChanging();

        }
    }

    void getInfo() throws ParseException {
        System.out.println("Please enter your name: "); //ім'я
        p.name = sc.nextLine();

        System.out.println("And surname: ");            //прізвище
        p.surname = sc.nextLine();

        System.out.println("Ooh, pretty! Now please enter your birth date! [DD/MM/YYYY]"); //дата STRING
        p.dateOfBirthSTRING= sc.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dateOfBirth = formatter.parse(p.dateOfBirthSTRING);                            //дата DATE

        Date currentDate = new Date();
        long diff = currentDate.getTime() - dateOfBirth.getTime();
        long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        p.age = days/365;                                                               //вік

        System.out.println("Good! Now please enter the serial number of your passport");   //паспорт
        p.passportNumber = sc.nextLine();

        System.out.println("Awesome! You've been registered in show as "+p.name+" "+p.surname+", " //тотал
        +p.age+" years old. Passport serial number: "+ p.passportNumber);
    }

    @Override 
    public String toString() { 
        return "Zoo{" + 
                "name=" + Arrays.toString(name) + 
                ", location=" + Arrays.toString(location) + 
                ", price=" + price + 
                ", quantity=" + quantity + 
                '}'; 
    }
}
