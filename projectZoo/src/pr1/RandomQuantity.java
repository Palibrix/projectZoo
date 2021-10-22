package pr1;

import java.util.Random;

public class RandomQuantity extends Main {
    RandomQuantity(){}
    Random rd = new Random();

    int random(){
        double i = rd.nextInt(10);
        return ((int) i);
    }
    int rdName(){
        double i = rd.nextInt(5);
        return ((int) i);
    }
    int rdLocation(){
        double i = rd.nextInt(6);
        return ((int) i);
    }
}
