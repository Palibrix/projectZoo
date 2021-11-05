package pr1; 

import java.util.Scanner;
import java.util.Date;

public class Main {
    Scanner sc = new Scanner(System.in);
    static Date date = new Date();

    static RandomQuantity random = new RandomQuantity(); 
    static int randomQuant = random.random(); 
 
    static String names[] = {"Shapito", "Karamel", "Cucumber", "Dolce i Kaban", "Winni Duck"}; 
    static String locations[]= {"l`viv", "Taraso-Shevchenkivsk", "Old York", "Riznutsi", "Odessa-dad", "Pryamovo"}; 
    static Zoo first = new Zoo(names, locations, 50, randomQuant);

    static int answer = -1;

    public static void main(String args[]) throws InterruptedException {
        Main m = new Main();

        System.out.println("We are happy to see you again!");
        /*System.out.println(h.humansList);
        System.out.println(h.getAge()); ISSUE: виводить вік одного відвідувача, коли потрібно,
        щоб виводило вік кожного. Як звернутись до параметру об'єкта, який сидить в списку? */


    }
 
    protected void menu(){
 
        System.out.println("You`re calling to Zoo. What do you want to find out or do?"); 
        System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]; Buy a ticket[5]"); 
 
        exepts(); 
 
    } 
 
    void info(){ 
        String a = sc.nextLine(); 
        answer = Integer.parseInt(a); 
        if (answer > 5 | answer < 1) { 
            exceptToString();
            exepts(); 
        }else{ 
 
            if(answer == 1){ 
                  first.answerEqw1(); 
            } else if(answer == 2){ 
                first.answerEqw2(); 
            } if(answer == 3){ 
                first.answerEqw3(); 
            } else if(answer == 4){ 
                first.answerEqw4(); 
            } else if(answer == 5) 
                first.answerEqw5(); 
            System.out.println("Would you like to ask something more?[y/n]"); 
            reattemp(); 
 
            //// 
        } 
    } 
 
    void exepts(){ 
        try { 
            info(); 
        }catch(Exception e){ 
            exceptToString();
            exepts(); 
        } 
    } 
 
    void reattemp(){ 
        String b = sc.nextLine(); 
        b = b.toLowerCase();
        if(b.equals("y")){ 
            System.out.println(); 
            System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]; Buy a ticket[5];"); 
            exepts(); 
        }else if (b.equals("n")){}
            else{
                System.out.println("Type \"y\" or \"n\""); 
                reattemp(); 
            }
    } 
 
    void exceptToString(){
        System.err.println("Type only 1, 2, 3 or 4"); 
        System.out.println(); 
        System.out.println("Number of tickets left[1]; Ticket price[2]; Name[3]; Locations[4]"); 
    } 
 
}
