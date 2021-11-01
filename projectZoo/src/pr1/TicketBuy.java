package pr1;

import java.util.Scanner;

class TicketBuy{

    int quantityOfTickets;
    TicketBuy(int quantityOfTickets){
        this.quantityOfTickets = quantityOfTickets;
        System.out.println(quantityOfTickets);
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

  void buyTicket(){
      int numOfBuyTickets = Scanner();
      System.out.println("Кількість переданих квитків у клас TicketBuy:  "+quantityOfTickets);
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
      }
     }

     int Scanner(){
         Scanner sc = new Scanner(System.in);
         System.out.println("How many tickets would U like to buy?");
         return sc.nextInt();
     }

}


