package pr1; 
 
import java.util.Scanner; 
import java.util.Arrays;

public class Zoo extends Main{ 
 
    String name[]; 
    String location[]; 
    int price; static int quantity; 
 
    RandomQuantity random = new RandomQuantity(); 
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
 
    void mindChanging(){ 
        Scanner sc = new Scanner(System.in); 
        String buyAnswer = sc.nextLine(); 
        buyAnswer = buyAnswer.toLowerCase(); 
        if(buyAnswer.equals("y")){ 
            System.out.println("Returning you to menu"); 
            // phoneCall(); 
        }else if(buyAnswer.equals("n")){ 
            buyTicket(); 
        }else{ 
            System.out.println("Please enter [Y/N]"); 
            mindChanging(); 
 
        } 
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
 
    void answerEqw5(){
        System.out.println("Enter a number of tickets you want to buy!");
        buyTicket(); 
    }

    void buyTicket() {
        int numOfBuyTickets = sc.nextInt();
        if (numOfBuyTickets > quantity) {
            System.out.println("We don't have so many tickets already!Would you like to buy some less?");
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
        }
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
