package pr1; 
 
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Scanner;
import java.util.Arrays;

public class Zoo extends Main{
    String name[]; 
    String location[]; 
    int price; static int quantity;
 
    RandomQuantity random = new RandomQuantity();
    Person p = new Person();
    Main m = new Main();

    LocalDate currentDate = LocalDate.now();

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
        p.name = sc.nextLine();

        System.out.println("And surname: ");            //прізвище
        p.surname = sc.nextLine();

        System.out.println("Good! Now please enter the serial number of your passport");   //паспорт
        p.passportNumber = sc.nextLine();

        System.out.println("Ooh, pretty! Now please enter your year of birth! [YYYY]"); //дата
        p.yearOB= sc.nextInt();
        System.out.println("Month of birth! [MM]");
        p.monthOB = sc.nextInt();
        System.out.println("And the day of birth! [DD]");
        p.dayOB = sc.nextInt();

        LocalDate fullBD = LocalDate.of(p.yearOB, Month.of(p.monthOB), p.dayOB);
//_______________________________________________________
        if (calculateAge(fullBD, currentDate)<18){
            System.out.println("Sorry, you're not allowed no take a part in out show(((");
        }
        else {
           actualBuyTicket();
        }
//_______________________________________________________

    }

    void actualBuyTicket(){
        System.out.println("Enter the number of tickets you want to buy!");
        int numOfBuyTickets = sc.nextInt();

        if (numOfBuyTickets > quantity) {
            System.out.println("We don't have so many tickets already! Would you like to buy some less?");
            actualBuyTicket();
        } else if (numOfBuyTickets == 0) {
            System.out.println("Uhh...Have you changed you're mind?[y/n]");
            mindChanging();
        } else if (numOfBuyTickets < 0) {
            System.out.println("That's not serious...");
            actualBuyTicket();
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

//    public int getAge(int yearOB, int monthOB, int dayOB) {
//        return Period.between(
//                LocalDate.of(yearOB, monthOB, dayOB),
//                LocalDate.now()
//        ).getYears();
//    }

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
