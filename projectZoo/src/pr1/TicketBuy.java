package pr1;

import pr1.RandomQuantity;
import pr1.Zoo;
import pr1.Main;

import java.util.Scanner;


public class TicketBuy extends Main{
static int quantityOfTickets = 5; //замінити цю змінну рандомним значенням
    
/*метод,в якому облаштовується випадок, коли користувач купує 0 квитків
і це ніби розуміється як небажання купувати щось.Тут якраз запитується
чи він дійсно хоче вийти з купівлі чи ні*/
  void mindChanging(){
     Scanner sc = new Scanner(System.in);
     String buyAnswer = sc.nextLine();
     buyAnswer = buyAnswer.toLowerCase();
        if(buyAnswer.equals("y")){
           phoneCall();
        }else if(buyAnswer.equals("n")){
           buyTicket();
        }else{
           System.out.println("Please enter [Y/N]");
           mindChanging();
    
  }
  }
  //власне метод купівлі квитка, де прописані всі виключення.
  void buyTicket(){
     Scanner sc = new Scanner(System.in);
     int numOfBuyTickets = sc.nextInt();
     
       if(numOfBuyTickets>quantityOfTickets){
         System.out.println("We don't have so many tickets already!Would you like to buy some less?");
         buyTicket();
       }else if(numOfBuyTickets==0){
         System.out.println("Uhh...Have you changed you're mind?[y/n]");
         mindChanging();
       }
       else if(numOfBuyTickets<0){
         System.out.println("That's not serious...");
         buyTicket();
       }
       else{
         System.out.println("There was " + quantityOfTickets + " tickets");
         quantityOfTickets = quantityOfTickets - numOfBuyTickets;
         System.out.println("And now there is " + quantityOfTickets + " of them");
         System.out.println("You've bought "+ numOfBuyTickets +" ticket(s). Thank you and have fun!");
           try {
               first.announce();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
     }
}


