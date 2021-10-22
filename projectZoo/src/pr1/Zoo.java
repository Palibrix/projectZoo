
import java.util.Scanner;

class Zoo
 {

  
   public static void announce(){
       
        int count = 5;
        int i;
        System.out.println("Welcome to our zoo!\nThe show starts in...");
       
        for(i=0;i < 4;i++){
        System.out.println(count + " seconds");
        count = count-1;
      }
        System.out.println(count + " second");
    }
    
   int pass = 1; //UPDATE PASS FEATURE
  
   public static void phoneCall(){
     System.out.println("Hi! Youre calling to Zoo. What do you want to find out?");
     System.out.println("1 - Number of tickets left; 2 - Ticket price; 3 - Hours of work;");
     Scanner scanner = new Scanner(System.in);
     int response = scanner.nextInt(); //TYPE CHECK!!!!!!!!!!!!

       if(response == 1){ //UPDATE PASS FEATURE
         // тут просто кількість квитків - кількість куплених
         System.out.println("There are "+i+" tickets left.");
         int pass = 0;
         System.out.println("Anything else?");
         }
         }
       
       
   
   
    
   public static void main(String args[]){
//____________________________________________________________________________
//SCANNER_____________________________________________________________________
      System.out.println("Hi! And welcome to our Zoo! Enter your request:");
      phoneCall();
//IF STATEMENT: NAME__________________________________________________________
////____________________________________________________________________________
   }
   }
