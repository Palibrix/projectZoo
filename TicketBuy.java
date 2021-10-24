import java.util.Scanner;
import java.util.Locale;
/*знаю, що деякі речі можна було не писати от як наприклад оголошення
функцій, але програма попросту не запустилась б у мене)) Намагався
якнайчіткіше все розписати.Також варто доробити перевірку на
правильність вводу через отой трай кетч, що я, скоріш за все,
забуду зробити.Впринципі це, я так розумію
може бути не клас, а чисто функція TicketBuy, 
але то вже глянеш там))*/


class TicketBuy{
static int quantityOfTickets = 5; //замінити цю змінну рандомним значенням
    
/*метод,в якому облаштовується випадок, коли користувач купує 0 квитків
і це ніби розуміється як небажання купувати щось.Тут якраз запитується
чи він дійсно хоче вийти з купівлі чи ні*/
  public static void mindChanging(){  
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
  //власне метод купівлі квитка, де прописані всі виключення.
  public static void buyTicket(){    
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
      }
     }
  
public static void main(String args[]){  
  System.out.println("Enter a number of tickets you want to buy");
  buyTicket();
  
}
}


