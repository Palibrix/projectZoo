package pr1; 
 
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedReader;

public class Zoo{
    Zoo(){}
    Zoo(String name[], String location[], int price, int quantity){
        this.name = name;
        this.location = location;
        this.price = price;
        this.quantityOfTickets = quantity;
    }

    String name[]; 
    String location[]; 
    int price; static int quantityOfTickets;
    ArrayList<Object> visitorsList = new ArrayList<>();
 
    RandomQuantity random = new RandomQuantity();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Person p = new Person();
    Main m = new Main();

    LocalDate currentDate = LocalDate.now();

    int rdName = random.rdName(); 
    int rdLoc1 = random.rdLocation(); 
    int rdLoc2 = random.rdLocation();
 
    void announce() throws InterruptedException { 
        int i; 
        System.out.println("Our Zoo opens in...");
 
        for(i=5;i >= 0 ;i--){ 
            System.out.println(i + " seconds"); 
            Thread.sleep(1000); 
        }
        System.out.println("Welcome!");
    } 
 
    void answerEqw1(){ 
        System.out.println(quantityOfTickets + " ticket(s) left");
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
 
    void answerEqw5() {
        buyTicket();
    }

    void mindChanging() {
        Scanner sc = new Scanner(System.in);
        String buyAnswer = sc.nextLine();
        buyAnswer = buyAnswer.toLowerCase();
        if(buyAnswer.equals("y")){
            m.menu();
        }else if(buyAnswer.equals("n")){
            actualBuyTicket();
        }else{
            System.out.println("Please enter [Y/N]");
            mindChanging();

        }
    }

    void getVisitorInfo() {
        System.out.println("Please enter your name: "); //ім'я
        try {
            p.name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("And surname: ");            //прізвище
        try {
            p.surname = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Good! Now please enter the serial number of your passport");   //паспорт
        try {
            p.passportNumber = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ooh, pretty! Now please enter your year of birth! [YYYY]"); //дата
        try {
            p.yearOB= Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Month of birth! [MM]");
        try {
            p.monthOB = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("And the day of birth! [DD]");
        try {
            p.dayOB = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        LocalDate fullBD = LocalDate.of(p.yearOB, Month.of(p.monthOB), p.dayOB);
//_______________________________________________________
        if (calculateAge(fullBD, currentDate) < Const.ageOfMajority){
            System.out.println("Sorry, you're not allowed no take a part in out show(((");
        }
        else {
           actualBuyTicket();
        }
//_______________________________________________________

    }

    void actualBuyTicket(){
        System.out.println("Enter the number of tickets you want to buy!");
        int numOfBuyTickets = 0;
        try {
            numOfBuyTickets = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (numOfBuyTickets > quantityOfTickets) {
            System.out.println("We don't have so many tickets already! Would you like to buy some less?");
            actualBuyTicket();
        } else if (numOfBuyTickets == 0) {
            System.out.println("Uhh...Have you changed you're mind?[y/n]");
            mindChanging();
        } else if (numOfBuyTickets < 0) {
            System.out.println("That's not serious...");
            actualBuyTicket();
        } else {
            System.out.println("There was " + quantityOfTickets + " tickets");
            quantityOfTickets = quantityOfTickets - numOfBuyTickets;
            System.out.println("And now there is " + quantityOfTickets + " of them");
            System.out.println("You've bought " + numOfBuyTickets + " ticket(s). Thank you!");

            System.out.println("*** a couple of people arrived and also bought some tickets ***");
            System.out.println("Okay, we're ready to start our show. Take your places and enjoy!");
            try {
                announce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    void setVisitorsList(){
        p.countOfVisitors = Const.quantityOfAllVisitors-quantityOfTickets;

        for(int i = 1;i<p.countOfVisitors+1;i++){
            Person visitor = new Person(i,random.rdVisitorAge());
            visitorsList.add(visitor);
        }
    }

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        if ((birthDate != null) && (currentDate != null)) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }

    void buyTicket(){
        Zoo z = new Zoo();

        System.out.println("Now let's take some notes!");
        z.getVisitorInfo();
    }

    @Override 
    public String toString() { 
        return "Zoo{" + 
                "name=" + Arrays.toString(name) + 
                ", location=" + Arrays.toString(location) + 
                ", price=" + price + 
                ", quantity=" + quantityOfTickets +
                '}'; 
    }
}
