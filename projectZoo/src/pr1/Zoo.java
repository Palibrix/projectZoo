package pr1;

import java.util.Scanner;

public class Zoo extends Main{
    String name; String location;
    int price; int quantity;  int response;

    Zoo(){}
    Zoo(String name, String location, int price, int quantity){

    }


    void announce() throws InterruptedException {
        int count = 5;
        int i;
        System.out.println("Welcome to our zoo!\nThe show starts in...");

        for(i=5;i > 0 ;i--){
            System.out.println(count + " seconds");
            count = count-1;
            Thread.sleep(1000);
        }
        System.out.println(count + " second");
    }


        int pass = 1; //UPDATE PASS FEATURE
        void phoneCall(){
            System.out.println("Hi! Youre calling to Zoo. What do you want to find out?");
            System.out.println("1 - Number of tickets left; 2 - Ticket price; 3 - Hours of work;");
            Scanner scanner = new Scanner(System.in);

            try {
                response = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Type only number");
            }


            if(response == 1){ //UPDATE PASS FEATURE
                System.out.println("There are "+"   "+" tickets left.");
                int pass = 0;
                System.out.println("Anything else?");
            }
        }




}
