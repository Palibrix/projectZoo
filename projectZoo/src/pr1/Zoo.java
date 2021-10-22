package pr1;

import java.util.Arrays;


public class Zoo extends Main{
    String name[];
    String location[];
    int price; int quantity;

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


    void announce() throws InterruptedException {
        int i;
        System.out.println("Welcome to our zoo!\nThe show starts in...");

        for(i=5;i >= 0 ;i--){
            System.out.println(i + " seconds");
            Thread.sleep(1000);
        }
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
